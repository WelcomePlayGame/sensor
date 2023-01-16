package vadym.ua.sensor.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vadym.ua.sensor.models.Measur;
import vadym.ua.sensor.service.MeasureService;

import java.util.List;

@RestController
@RequestMapping(path = "/measur", produces = {"application/json", "application/text"})
@CrossOrigin("http://localhost:8080/")
public class MeasurController {


    private final MeasureService measureService;

    public MeasurController(MeasureService measureService) {
        this.measureService = measureService;
    }

    @GetMapping()
    public List<Measur> getMeasurList() {
        return measureService.findAllMeasure();
    }


    @GetMapping(path = "/israin")
    public Long daysIsRain() {
        return measureService.findAllMeasure().stream().filter(Measur::isRaining).count();
    }

    @GetMapping(path = "/norain")
    public Long daysNoRain() {
        return measureService.findAllMeasure().stream().filter(s->s.isRaining()==false).count();
    }


    @PostMapping(path = "/add", consumes = "application/json")
    public ResponseEntity<HttpStatus> addMeasur(@RequestBody Measur measur) {
        measureService.addMeasur(measur);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> deleteMeasurById(@PathVariable("id") long id) {
        measureService.deleteMeasurById(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
