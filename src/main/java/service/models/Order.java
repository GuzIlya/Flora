package service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "time_from")
    private String timeFrom;

    @Column(name = "time_to")
    private String timeTo;

    @Column(name = "order_list")
    private String orderList;

    @Column(name = "order_price")
    private String orderPrice;

    @Column(name = "customer")
    private String customer;

    @Column(name = "customer_number")
    private String customerNumber;

    @Column(name = "customer_number_code")
    private String customerNumberCode;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "receiver_number")
    private String receiverNumber;

    @Column(name = "receiver_number_code")
    private String receiverNumberCode;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @Column(name = "porch")
    private String porch;

    @Column(name = "floor")
    private String floor;

    @Column(name = "flat")
    private String flat;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "notes")
    private String notes;

    @Column(name = "status")
    private String status;

    @Column(name = "courier")
    private String courier;

    @Column(name = "poster")
    private Boolean poster;

    @Column(name = "pay_status")
    private Boolean payStatus;
}
