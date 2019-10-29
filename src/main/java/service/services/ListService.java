package service.services;

import service.forms.OrderTypeForm;
import service.transfer.NumberCodeDto;
import service.transfer.OrderTypeDto;
import service.transfer.PaymentMethodDto;
import service.transfer.StreetDto;

import java.util.List;

public interface ListService {
    List<OrderTypeDto> getOrderTypes();
    List<PaymentMethodDto> getPaymentMethods();
    List<StreetDto> getStreets();
    List<NumberCodeDto> getNumberCodes();
    void deleteOrderType(OrderTypeForm orderType);
    void addOrderType(OrderTypeForm orderType);
}
