package service.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import service.models.Order;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Long id;

    private String date;

    private String time;

    private String orderList;

    private String orderPrice;

    private String customer;

    private String customerNumber;

    private String receiver;

    private String receiverNumber;

    private String address;

    private String paymentMethod;

    private String notes;

    private String status;


    public static OrderDto from(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .date(order.getDate())
                .time(order.getTime())
                .orderList(order.getOrderList())
                .orderPrice(order.getOrderPrice())
                .customer(order.getCustomer())
                .customerNumber(order.getCustomerNumber())
                .receiver(order.getReceiver())
                .receiverNumber(order.getReceiverNumber())
                .address(order.getAddress())
                .paymentMethod(order.getPaymentMethod())
                .notes(order.getNotes())
                .status(order.getStatus())
                .build();
    }

    public static List<OrderDto> from(List<Order> orders) {
        return orders.stream().map(OrderDto::from).collect(Collectors.toList());
    }
}
