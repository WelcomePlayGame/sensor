package vadym.ua.sensor.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vadym.ua.sensor.models.Measur;
import vadym.ua.sensor.models.Sensor;
import vadym.ua.sensor.repository.MeasurRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasureService {

    private  final MeasurRepository measurRepository;
    private final SensorService sensorService;

    public MeasureService(MeasurRepository measurRepository, SensorService sensorService) {
        this.measurRepository = measurRepository;
        this.sensorService = sensorService;
    }

//    find List of Measure
    public List<Measur> findAllMeasure() {
        return measurRepository.findAll();
    }

    @Transactional
    public void deleteMeasurById(long id) {
        measurRepository.deleteById(id);
    }


    @Transactional
    public void addMeasur(Measur measur) {
        requireSensor(measur);
        measurRepository.save(measur);
    }

    public void requireSensor(Measur measur) {
        measur.setSensor(sensorService.findByName(measur.getSensor().getName()).get());
        measur.setNowTime(LocalDate.now());
    }

}
