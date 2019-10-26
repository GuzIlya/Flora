package service.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import service.models.OrderType;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class OrderTypeDto {
    private Long id;

    private String name;

    public static OrderTypeDto from(OrderType orderType) {
        return new OrderTypeDto(orderType.getId(), orderType.getName());
    }

    public static List<OrderTypeDto> from(List<OrderType> orderTypes) {
        return orderTypes.stream().map(OrderTypeDto::from).collect(Collectors.toList());
    }
}
