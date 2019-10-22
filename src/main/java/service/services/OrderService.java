package service.services;

import service.forms.OrderForm;
import service.transfer.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> findByCustomerNumber(String customerNumber);
    void addOrder(OrderForm orderForm);
    void deleteOrder(OrderForm orderForm);
    List<OrderDto> getOrders();
}
