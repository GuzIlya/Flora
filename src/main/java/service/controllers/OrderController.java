package service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.forms.OrderForm;
import service.services.OrderService;
import service.transfer.OrderDto;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/addOrder")
    public ResponseEntity<Object> addOrder(@RequestBody OrderForm orderForm){
        orderService.addOrder(orderForm);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deleteOrder")
    public ResponseEntity<Object> deleteOrder(@RequestBody OrderForm orderForm){
        orderService.deleteOrder(orderForm);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findByCustomerNumber")
    public ResponseEntity<List<OrderDto>> findByCustomerNumber(@RequestParam("customerNumber") String customerNumber){
        return ResponseEntity.ok(orderService.findByCustomerNumber(customerNumber));
    }

    @GetMapping("/getOrders")
    public ResponseEntity<List<OrderDto>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }
}
