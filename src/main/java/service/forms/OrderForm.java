package service.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm {
    private Long id;

    private String date;

    private String timeFrom;

    private String timeTo;

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
}
