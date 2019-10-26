package service.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm {
    private Long id;

    private String date;

    private String timeFrom;

    private String timeTo;

    private Array orderList;

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
