package vadym.ua.sensor.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vadym.ua.sensor.dto.SensorDTO;
import vadym.ua.sensor.models.Sensor;
import vadym.ua.sensor.service.SensorService;
import vadym.ua.sensor.utils.MeasureException;
import vadym.ua.sensor.utils.SensorErrorResponse;
import vadym.ua.sensor.utils.SensorValidator;

import java.util.List;

import static vadym.ua.sensor.utils.ErrorUtil.returnErrorsToClient;

@RestController
@RequestMapping(path = "/sensor", produces = {"application/json"})
@CrossOrigin("localhost:8080")
public class SensorContorller {
    private final SensorService sensorService;
    private final ModelMapper modelMapper;

    private final SensorValidator validator;

    public SensorContorller(SensorService sensorService, ModelMapper modelMapper, SensorValidator validator) {
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @GetMapping
    public List<Sensor> findListSensor() {
        return sensorService.getAllSensor();
    }

    @GetMapping(path = "/{id}")
    public Sensor getById(@PathVariable("id") long id) {
        return sensorService.getSensorById(id);
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public ResponseEntity<HttpStatus> addSensor(@RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult) {
        Sensor sensor = convertToSensor(sensorDTO);
        validator.validate(sensor, bindingResult);
        if (bindingResult.hasErrors()) {
            returnErrorsToClient(bindingResult);
        }
        sensorService.addSensor(sensor);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> deleteSensorById(@RequestBody @PathVariable("id") long id) {
        sensorService.deleteSensorById(id);
    return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    public ResponseEntity<SensorErrorResponse> getError(MeasureException e) {
        SensorErrorResponse response = new SensorErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    public Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }
}
