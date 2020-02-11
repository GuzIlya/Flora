package service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.forms.CourierForm;
import service.forms.OrderTypeForm;
import service.models.Courier;
import service.services.ListService;
import service.transfer.*;

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

    @PostMapping("/addOrderType")
    public ResponseEntity<Object> addOrderType(@RequestBody OrderTypeForm orderTypeForm) {
        listService.addOrderType(orderTypeForm);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deleteOrderType")
    public ResponseEntity<Object> deleteOrderType(@RequestBody OrderTypeForm orderTypeForm) {
        listService.deleteOrderType(orderTypeForm);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getPaymentMethods")
    public ResponseEntity<List<PaymentMethodDto>> getPaymentMethods() { return ResponseEntity.ok(listService.getPaymentMethods()); }

    @GetMapping("/getNumberCodes")
    public ResponseEntity<List<NumberCodeDto>> getNumberCodes() { return ResponseEntity.ok(listService.getNumberCodes()); }

    @GetMapping("/getCouriers")
    public ResponseEntity<List<CourierDto>> getCouriers() { return ResponseEntity.ok(listService.getCouriers()); }

    @PostMapping("/addCourier")
    public ResponseEntity<Object> addCourier(@RequestBody CourierForm courierForm) {
        listService.addCourier(courierForm);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deleteCourier")
    public ResponseEntity<Object> deleteCourier(@RequestBody CourierForm courierForm) {
        listService.deleteCourier(courierForm);
        return ResponseEntity.ok().build();
    }

}
