package service.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import service.models.OrderType;
import service.models.PaymentMethod;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class PaymentMethodDto {
    private String name;

    public static PaymentMethodDto from(PaymentMethod paymentMethod) {
        return new PaymentMethodDto(paymentMethod.getMethodName());
    }

    public static List<PaymentMethodDto> from(List<PaymentMethod> paymentMethodList) {
        return paymentMethodList.stream().map(PaymentMethodDto::from).collect(Collectors.toList());
    }
}
