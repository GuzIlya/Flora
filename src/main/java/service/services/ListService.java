package service.services;

import service.forms.CourierForm;
import service.forms.OrderTypeForm;
import service.transfer.*;

import java.util.List;

public interface ListService {
    List<OrderTypeDto> getOrderTypes();
    List<PaymentMethodDto> getPaymentMethods();
    List<StreetDto> getStreets();
    List<NumberCodeDto> getNumberCodes();
    List<CourierDto> getCouriers();
    void deleteCourier(CourierForm courierForm);
    void addCourier(CourierForm courierForm);
    void deleteOrderType(OrderTypeForm orderType);
    void addOrderType(OrderTypeForm orderType);
}
