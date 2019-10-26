package service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import service.forms.OrderForm;
import service.models.Order;
import service.repositories.OrderRepository;
import service.services.OrderService;
import service.transfer.OrderDto;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDto> findByCustomerNumber(String customerNumber) {
        return OrderDto.from(orderRepository.findAllByCustomerNumber(customerNumber));
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
                    .receiver(orderForm.getReceiver())
                    .receiverNumber(orderForm.getReceiverNumber())
                    .street(orderForm.getStreet())
                    .house(orderForm.getHouse())
                    .porch(orderForm.getPorch())
                    .floor(orderForm.getFloor())
                    .flat(orderForm.getFlat())
                    .paymentMethod(orderForm.getPaymentMethod())
                    .notes(orderForm.getNotes())
                    .status(orderForm.getStatus())
                    .poster(orderForm.getPoster())
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
                .receiver(orderForm.getReceiver())
                .receiverNumber(orderForm.getReceiverNumber())
                .street(orderForm.getStreet())
                .house(orderForm.getHouse())
                .porch(orderForm.getPorch())
                .floor(orderForm.getFloor())
                .flat(orderForm.getFlat())
                .paymentMethod(orderForm.getPaymentMethod())
                .notes(orderForm.getNotes())
                .status(orderForm.getStatus())
                .poster(orderForm.getPoster())
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
                .date(orderForm.getDate())
                .timeFrom(orderForm.getTimeFrom())
                .timeTo(orderForm.getTimeTo())
                .orderList(orderForm.getOrderList())
                .orderPrice(orderForm.getOrderPrice())
                .customer(orderForm.getCustomer())
                .customerNumber(orderForm.getCustomerNumber())
                .receiver(orderForm.getReceiver())
                .receiverNumber(orderForm.getReceiverNumber())
                .street(orderForm.getStreet())
                .house(orderForm.getHouse())
                .porch(orderForm.getPorch())
                .floor(orderForm.getFloor())
                .flat(orderForm.getFlat())
                .paymentMethod(orderForm.getPaymentMethod())
                .notes(orderForm.getNotes())
                .status(orderForm.getStatus())
                .poster(orderForm.getPoster())
                .build();

        Example<Order> example = Example.of(order);

        try{
            Order actual = orderRepository.findOne(example);
            if (!actual.equals(null)){
                orderRepository.delete(actual);
            }
        } catch (Exception e){
            throw new IllegalArgumentException("No such order");
        }
    }

    @Override
    public List<OrderDto> getOrders() {
        return OrderDto.from(orderRepository.findAll());
    }
}
