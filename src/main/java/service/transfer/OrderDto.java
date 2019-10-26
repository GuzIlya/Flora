package service.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import service.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Long id;

    private String date;

    private String timeFrom;

    private String timeTo;

    private ArrayList<String> orderList;

    private String orderPrice;

    private String customer;

    private String customerNumber;

    private String receiver;

    private String receiverNumber;

    private String street;

    private String house;

    private String porch;

    private String floor;

    private String flat;

    private String paymentMethod;

    private String notes;

    private String status;

    private Boolean poster;


    public static OrderDto from(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .date(order.getDate())
                .timeFrom(order.getTimeFrom())
                .timeTo(order.getTimeTo())
                .orderList(order.getOrderList())
                .orderPrice(order.getOrderPrice())
                .customer(order.getCustomer())
                .customerNumber(order.getCustomerNumber())
                .receiver(order.getReceiver())
                .receiverNumber(order.getReceiverNumber())
                .street(order.getStreet())
                .house(order.getHouse())
                .porch(order.getPorch())
                .floor(order.getFloor())
                .flat(order.getFlat())
                .paymentMethod(order.getPaymentMethod())
                .notes(order.getNotes())
                .status(order.getStatus())
                .poster(order.getPoster())
                .build();
    }

    public static List<OrderDto> from(List<Order> orders) {
        return orders.stream().map(OrderDto::from).collect(Collectors.toList());
    }
}
