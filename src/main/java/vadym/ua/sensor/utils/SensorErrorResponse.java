package vadym.ua.sensor.utils;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class SensorErrorResponse {
    private String message;
    private LocalDate time;

    public SensorErrorResponse(String message) {
        this.message = message;
        this.time = LocalDate.now();
        System.out.println(time);
    }
}
