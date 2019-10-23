package service.services;

import service.transfer.OrderTypeDto;
import service.transfer.PaymentMethodDto;
import service.transfer.StreetDto;

import java.util.List;

public interface ListService {
    List<OrderTypeDto> getOrderTypes();
    List<PaymentMethodDto> getPaymentMethods();
    List<StreetDto> getStreets();
    void deleteOrderType(OrderTypeDto orderType);
    void addOrderType(OrderTypeDto orderType);
}
