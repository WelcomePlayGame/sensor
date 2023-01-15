package vadym.ua.sensor.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vadym.ua.sensor.models.Sensor;
import vadym.ua.sensor.repository.SensorRepository;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class SensorService{

    private final SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }


   public List<Sensor> getAllSensor() {
        return sensorRepository.findAll();
    }

    @Transactional
   public void addSensor(Sensor sensor) {
        sensorRepository.save(sensor);
   }

   public Sensor getSensorById(long id) {
        Optional<Sensor> sensor = sensorRepository.findById(id);
        return sensor.orElse(null);
   }

   @Transactional
   public void deleteSensorById(long id) {
        sensorRepository.deleteById(id);
   }



   public  Optional<Sensor> findByName(String name) {
    return sensorRepository.findByName(name);
   }

}
