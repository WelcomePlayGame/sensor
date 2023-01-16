package vadym.ua.sensor.models;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "measur")
public class Measur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "value")
    private double value;

    @NotNull
    @Column(name = "raining")
    private boolean raining;

    @NotNull
    @Column(name = "nowtime")
    private LocalDate nowTime;

    @NotNull

    @ManyToOne
    @JoinColumn(name = "sensor", referencedColumnName = "name")
    private Sensor sensor;

}
