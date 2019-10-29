package service.transfer;


import lombok.AllArgsConstructor;
import lombok.Data;
import service.models.NumberCode;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class NumberCodeDto {
    private String name;

    public static NumberCodeDto from(NumberCode numberCode) {
        return new NumberCodeDto(numberCode.getName());
    }

    public static List<NumberCodeDto> from(List<NumberCode> numberCodeList) {
        return numberCodeList.stream().map(NumberCodeDto::from).collect(Collectors.toList());
    }
}
