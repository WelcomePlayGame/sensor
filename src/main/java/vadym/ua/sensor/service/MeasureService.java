package vadym.ua.sensor.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vadym.ua.sensor.models.Measur;
import vadym.ua.sensor.repository.MeasurRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasureService {

    private  final MeasurRepository measurRepository;

    public MeasureService(MeasurRepository measurRepository) {
        this.measurRepository = measurRepository;
    }

//    find List of Measure
    public List<Measur> findAllMeasure() {
        return measurRepository.findAll();
    }
}
