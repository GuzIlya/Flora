package service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.repositories.OrderTypeRepository;
import service.repositories.PaymentMethodRepository;
import service.repositories.StreetRepository;
import service.services.ListService;
import service.transfer.OrderTypeDto;
import service.transfer.PaymentMethodDto;
import service.transfer.StreetDto;

import java.util.List;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    OrderTypeRepository orderTypeRepository;

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Autowired
    StreetRepository streetRepository;

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
}
