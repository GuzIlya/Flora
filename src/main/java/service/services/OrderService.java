package service.services;

import service.forms.OrderForm;
import service.transfer.OrderDto;

import java.util.ArrayList;
import java.util.List;

public interface OrderService {
    List<OrderDto> findByCustomerNumber(String customerNumber);
    List<OrderDto> findByCustomer(String customer);
    List<OrderDto> findByReceiverNumber(String receiverNumber);
    List<OrderDto> findByReceiver(String receiver);
    List<OrderDto> findByOrderList(ArrayList<String> orderList);
    OrderDto getOrderById(Long id);
    void addOrder(OrderForm orderForm);
    void deleteOrder(OrderForm orderForm);
    void changeOrder(OrderForm orderForm);
    List<OrderDto> getOrders();
}
