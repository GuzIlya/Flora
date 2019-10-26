package service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.reflect.Array;

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
    private Array orderList;

    @Column(name = "order_price")
    private String orderPrice;

    @Column(name = "customer")
    private String customer;

    @Column(name = "customer_number")
    private String customerNumber;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "receiver_number")
    private String receiverNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "notes")
    private String notes;

    @Column(name = "status")
    private String status;


}
