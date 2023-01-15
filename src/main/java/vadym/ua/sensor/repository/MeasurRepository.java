package vadym.ua.sensor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vadym.ua.sensor.models.Measur;

@Repository
public interface MeasurRepository extends JpaRepository<Measur, Long> {


}
