package service.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import service.models.PaymentMethod;
import service.models.Street;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class StreetDto {
    private String name;

    public static StreetDto from(Street street) {
        return new StreetDto(street.getName());
    }

    public static List<StreetDto> from(List<Street> streets) {
        return streets.stream().map(StreetDto::from).collect(Collectors.toList());
    }
}
