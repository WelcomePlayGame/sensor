package vadym.ua.sensor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vadym.ua.sensor.models.Sensor;

import java.util.Optional;


@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {


    @Query(value = "select * from sensor s where s.name=?1" , nativeQuery = true)
    Optional<Sensor> findByName( String name);

}
