package service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.forms.OrderForm;
import service.forms.OrderListWrapper;
import service.services.OrderService;
import service.transfer.OrderDto;

import java.io.IOException;
import java.util.ArrayList;
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

    @PostMapping("/changeOrder")
    public ResponseEntity<Object> changeOrder(@RequestBody OrderForm orderForm){
        orderService.changeOrder(orderForm);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findByCustomerNumber")
    public ResponseEntity<List<OrderDto>> findByCustomerNumber(@RequestParam("customerNumber") String customerNumber){
        return ResponseEntity.ok(orderService.findByCustomerNumber(customerNumber));
    }

    @GetMapping("/findByCustomer")
    public ResponseEntity<List<OrderDto>> findByCustomer(@RequestParam("customer") String customer){
        return ResponseEntity.ok(orderService.findByCustomer(customer));
    }

    @GetMapping("/findByReceiverNumber")
    public ResponseEntity<List<OrderDto>> findByReceiverNumber(@RequestParam("receiverNumber") String receiverNumber){
        return ResponseEntity.ok(orderService.findByReceiverNumber(receiverNumber));
    }

    @GetMapping("/findByReceiver")
    public ResponseEntity<List<OrderDto>> findByReceiver(@RequestParam("receiver") String receiver){
        return ResponseEntity.ok(orderService.findByReceiver(receiver));
    }

    @PostMapping("/findByOrderList")
    public ResponseEntity<List<OrderDto>> findByOrderList(@RequestBody OrderListWrapper orderListWrapper){
        return ResponseEntity.ok(orderService.findByOrderList(orderListWrapper.getOrderList()));
    }

    @GetMapping("/findByStatus")
    public ResponseEntity<List<OrderDto>> findByStatus(@RequestParam("status") String status){
        return ResponseEntity.ok(orderService.findByStatus(status));
    }

    @GetMapping("/findByPayStatus")
    public ResponseEntity<List<OrderDto>> findByPayStatus(@RequestParam("payStatus") String status){
        return ResponseEntity.ok(orderService.findByStatus(status));
    }

    @GetMapping("/getOrders")
    public ResponseEntity<List<OrderDto>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @GetMapping("/getOrderById")
    public ResponseEntity<OrderDto> getOrderById(@RequestParam("id") Long id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping("/getOrdersInExcel")
    public ResponseEntity<InputStreamResource> getOrdersInExcel(@RequestParam("date") String date) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=orders.xlsx");
        headers.add("Content-Encoding", "UTF-8");
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(orderService.getOrdersInExcel(date));
    }


}
