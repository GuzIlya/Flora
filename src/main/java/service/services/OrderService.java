package service.services;

import service.forms.OrderForm;
import service.transfer.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> findByCustomerNumber(String customerNumber);
    OrderDto getOrderById(Long id);
    void addOrder(OrderForm orderForm);
    void deleteOrder(OrderForm orderForm);
    void changeOrder(OrderForm orderForm);
    List<OrderDto> getOrders();
}
