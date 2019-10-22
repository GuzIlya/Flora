package service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
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
    public void addOrder(OrderForm orderForm) {
            Order order = Order.builder()
                    .date(orderForm.getDate())
                    .time(orderForm.getTime())
                    .orderList(orderForm.getOrderList())
                    .orderPrice(orderForm.getOrderPrice())
                    .customer(orderForm.getCustomer())
                    .customerNumber(orderForm.getCustomerNumber())
                    .receiver(orderForm.getReceiver())
                    .receiverNumber(orderForm.getReceiverNumber())
                    .address(orderForm.getAddress())
                    .paymentMethod(orderForm.getPaymentMethod())
                    .notes(orderForm.getNotes())
                    .build();

            orderRepository.save(order);
    }

   @Override
    public void deleteOrder(OrderForm orderForm) {
        Order order = Order.builder()
                .date(orderForm.getDate())
                .time(orderForm.getTime())
                .orderList(orderForm.getOrderList())
                .orderPrice(orderForm.getOrderPrice())
                .customer(orderForm.getCustomer())
                .customerNumber(orderForm.getCustomerNumber())
                .receiver(orderForm.getReceiver())
                .receiverNumber(orderForm.getReceiverNumber())
                .address(orderForm.getAddress())
                .paymentMethod(orderForm.getPaymentMethod())
                .notes(orderForm.getNotes())
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
