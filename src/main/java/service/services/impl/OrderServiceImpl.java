package service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import service.forms.OrderForm;
import service.models.GenerateExcelReport;
import service.models.Order;
import service.repositories.OrderRepository;
import service.services.OrderService;
import service.transfer.OrderDto;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDto> findByCustomerNumber(String customerNumber) {
        return OrderDto.from(orderRepository.findAllByCustomerNumber(customerNumber));
    }

    @Override
    public List<OrderDto> findByCustomer(String customer) {
        return OrderDto.from(orderRepository.findAllByCustomer(customer));
    }

    @Override
    public List<OrderDto> findByReceiverNumber(String receiverNumber) {
        return OrderDto.from(orderRepository.findAllByReceiverNumber(receiverNumber));
    }

    @Override
    public List<OrderDto> findByReceiver(String receiver) {
        return OrderDto.from(orderRepository.findAllByReceiver(receiver));
    }

    @Override
    public List<OrderDto> findByOrderList(String orderList) {
        return OrderDto.from(orderRepository.findAllByOrderList(orderList));
    }

    @Override
    public List<OrderDto> findByStatus(String status) {
        return OrderDto.from(orderRepository.findAllByStatus(status));
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Optional<Order> actual = orderRepository.findOneById(id);
        if(actual.isPresent())
            return OrderDto.from(actual.get());
        else throw new IllegalArgumentException("No such order");
    }

    @Override
    public void addOrder(OrderForm orderForm) {
            Order order = Order.builder()
                    .date(orderForm.getDate())
                    .timeFrom(orderForm.getTimeFrom())
                    .timeTo(orderForm.getTimeTo())
                    .orderList(orderForm.getOrderList())
                    .orderPrice(orderForm.getOrderPrice())
                    .customer(orderForm.getCustomer())
                    .customerNumber(orderForm.getCustomerNumber())
                    .customerNumberCode(orderForm.getCustomerNumberCode())
                    .receiver(orderForm.getReceiver())
                    .receiverNumber(orderForm.getReceiverNumber())
                    .receiverNumberCode(orderForm.getReceiverNumberCode())
                    .street(orderForm.getStreet())
                    .house(orderForm.getHouse())
                    .porch(orderForm.getPorch())
                    .floor(orderForm.getFloor())
                    .flat(orderForm.getFlat())
                    .paymentMethod(orderForm.getPaymentMethod())
                    .notes(orderForm.getNotes())
                    .status(orderForm.getStatus())
                    .poster(orderForm.getPoster())
                    .payStatus(orderForm.getPayStatus())
                    .build();

        orderRepository.save(order);
    }

   @Override
    public void changeOrder(OrderForm orderForm) {
        Order order = Order.builder()
                .id(orderForm.getId())
                .date(orderForm.getDate())
                .timeFrom(orderForm.getTimeFrom())
                .timeTo(orderForm.getTimeTo())
                .orderList(orderForm.getOrderList())
                .orderPrice(orderForm.getOrderPrice())
                .customer(orderForm.getCustomer())
                .customerNumber(orderForm.getCustomerNumber())
                .customerNumberCode(orderForm.getCustomerNumberCode())
                .receiver(orderForm.getReceiver())
                .receiverNumber(orderForm.getReceiverNumber())
                .receiverNumberCode(orderForm.getReceiverNumberCode())
                .street(orderForm.getStreet())
                .house(orderForm.getHouse())
                .porch(orderForm.getPorch())
                .floor(orderForm.getFloor())
                .flat(orderForm.getFlat())
                .paymentMethod(orderForm.getPaymentMethod())
                .notes(orderForm.getNotes())
                .status(orderForm.getStatus())
                .poster(orderForm.getPoster())
                .payStatus(orderForm.getPayStatus())
                .build();

        Optional<Order> actual = orderRepository.findOneById(order.getId());
        if (actual.isPresent()){
            orderRepository.delete(actual.get());
        } else throw new IllegalArgumentException("No such order");
        orderRepository.save(order);

    }

    @Override
    public void deleteOrder(OrderForm orderForm) {
        Order order = Order.builder()
                .id(orderForm.getId())
                .date(orderForm.getDate())
                .timeFrom(orderForm.getTimeFrom())
                .timeTo(orderForm.getTimeTo())
                .orderList(orderForm.getOrderList())
                .orderPrice(orderForm.getOrderPrice())
                .customer(orderForm.getCustomer())
                .customerNumber(orderForm.getCustomerNumber())
                .customerNumberCode(orderForm.getCustomerNumberCode())
                .receiver(orderForm.getReceiver())
                .receiverNumber(orderForm.getReceiverNumber())
                .receiverNumberCode(orderForm.getReceiverNumberCode())
                .street(orderForm.getStreet())
                .house(orderForm.getHouse())
                .porch(orderForm.getPorch())
                .floor(orderForm.getFloor())
                .flat(orderForm.getFlat())
                .paymentMethod(orderForm.getPaymentMethod())
                .notes(orderForm.getNotes())
                .status(orderForm.getStatus())
                .poster(orderForm.getPoster())
                .payStatus(orderForm.getPayStatus())
                .build();

        Optional<Order> actual = orderRepository.findOneById(order.getId());
        if(actual.isPresent())
            orderRepository.delete(actual.get());
        else throw new IllegalArgumentException("No such order");
    }

    @Override
    public List<OrderDto> getOrders() {
        return OrderDto.from(orderRepository.findAll(new Sort(Sort.Direction.ASC, "date")));
    }

    @Override
    public InputStreamResource getOrdersInExcel(String date) throws IOException {
        ByteArrayInputStream in = GenerateExcelReport.usersToExcel(orderRepository.findAllByStatusAndDateGreaterThanEqual("order-done", date));

        for(Order order : orderRepository.findAllByStatusAndDateGreaterThanEqual("order-done", date))
            orderRepository.delete(order);

        return new InputStreamResource(in);
    }
}
