package service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.services.ListService;
import service.transfer.OrderTypeDto;
import service.transfer.PaymentMethodDto;
import service.transfer.StreetDto;

import java.util.List;


@RestController
public class ListController {

    @Autowired
    private ListService listService;

    @GetMapping("/getStreets")
    public ResponseEntity<List<StreetDto>> getStreets() {
        return ResponseEntity.ok(listService.getStreets());
    }

    @GetMapping("/getOrderTypes")
    public ResponseEntity<List<OrderTypeDto>> getOrderTypes() {
        return ResponseEntity.ok(listService.getOrderTypes());
    }

    @GetMapping("/getPaymentMethods")
    public ResponseEntity<List<PaymentMethodDto>> getPaymentMethods() { return ResponseEntity.ok(listService.getPaymentMethods()); }
}
