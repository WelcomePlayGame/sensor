package vadym.ua.sensor.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorDTO {

    @NotNull(message = "Can't be is Empty")
    @Size(min = 3, max = 20, message = "Length to name should be from 3 to 20 ")
    private String name;

}
