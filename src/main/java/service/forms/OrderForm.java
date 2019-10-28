package service.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm {
    private Long id;

    private String date;

    private String timeFrom;

    private String timeTo;

    private String[] orderList;

    private String orderPrice;

    private String customer;

    private String customerNumber;

    private String customerNumberCode;

    private String receiver;

    private String receiverNumber;

    private String receiverNumberCode;

    private String street;

    private String house;

    private String porch;

    private String floor;

    private String flat;

    private String paymentMethod;

    private String notes;

    private String status;

    private Boolean poster;
}
