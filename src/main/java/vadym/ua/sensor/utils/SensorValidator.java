package vadym.ua.sensor.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vadym.ua.sensor.models.Sensor;
import vadym.ua.sensor.service.SensorService;

@Component
public class SensorValidator implements Validator {

    private  final SensorService sensorService;
    @Autowired
    public SensorValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        Sensor sensor = (Sensor) target;
        if (sensorService.findByName(sensor.getName()).isPresent())
            errors.rejectValue("name", "We have this scanner");

    }
}
