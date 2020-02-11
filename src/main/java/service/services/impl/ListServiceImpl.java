package service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.forms.CourierForm;
import service.forms.OrderTypeForm;
import service.models.Courier;
import service.models.OrderType;
import service.repositories.*;
import service.services.ListService;
import service.transfer.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    OrderTypeRepository orderTypeRepository;

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Autowired
    StreetRepository streetRepository;

    @Autowired
    NumberCodeRepository numberCodeRepository;

    @Autowired
    CouriersRepository couriersRepository;

    @Override
    public List<OrderTypeDto> getOrderTypes() {
        return OrderTypeDto.from(orderTypeRepository.findAll(new Sort(Sort.Direction.ASC, "id")));
    }

    @Override
    public List<PaymentMethodDto> getPaymentMethods() {
        return PaymentMethodDto.from(paymentMethodRepository.findAll(new Sort(Sort.Direction.ASC, "id")));
    }

    @Override
    public List<StreetDto> getStreets() {
        return StreetDto.from(streetRepository.findAll(new Sort(Sort.Direction.ASC, "id")));
    }

    @Override
    public List<NumberCodeDto> getNumberCodes() {
        return NumberCodeDto.from(numberCodeRepository.findAll(new Sort(Sort.Direction.ASC, "id")));
    }

    @Override
    public List<CourierDto> getCouriers() {
        return CourierDto.from(couriersRepository.findAll(new Sort(Sort.Direction.ASC, "id")));
    }

    @Override
    public void deleteCourier(CourierForm courierForm) {
        Courier courier = Courier.builder()
                .id(courierForm.getId())
                .data(courierForm.getData())
                .build();

        Example<Courier> example = Example.of(courier);

        try{
            Courier actual = couriersRepository.findOne(example);
            couriersRepository.delete(actual);
        } catch (Exception e){
            throw new IllegalArgumentException("No such order");
        }
    }

    @Override
    public void addCourier(CourierForm courierForm) {
        Courier courier = Courier.builder()
                .data(courierForm.getData())
                .build();

        couriersRepository.save(courier);
    }

    @Override
    public void deleteOrderType(OrderTypeForm orderType) {
        OrderType order = OrderType.builder()
                .id(orderType.getId())
                .name(orderType.getName())
                .build();

        Example<OrderType> example = Example.of(order);

        try{
            OrderType actual = orderTypeRepository.findOne(example);
            orderTypeRepository.delete(actual);
        } catch (Exception e){
            throw new IllegalArgumentException("No such order");
        }
    }

    @Override
    public void addOrderType(OrderTypeForm orderTypeForm) {
        OrderType orderType = OrderType.builder()
                .name(orderTypeForm.getName())
                .build();

        orderTypeRepository.save(orderType);
    }
}
