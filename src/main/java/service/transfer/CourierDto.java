package service.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import service.models.Courier;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CourierDto {
    private Long id;

    private String data;

    public static CourierDto from(Courier courier) {
        return new CourierDto(courier.getId(), courier.getData());
    }

    public static List<CourierDto> from(List<Courier> couriers) {
        return couriers.stream().map(CourierDto::from).collect(Collectors.toList());
    }
}
