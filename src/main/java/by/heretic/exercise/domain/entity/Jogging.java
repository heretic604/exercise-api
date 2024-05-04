package by.heretic.exercise.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;
import java.time.LocalTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@FieldNameConstants
public class Jogging {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long joggingId;

    private LocalDate joggingDate;
    private Integer meters;
    private LocalTime joggingTime;
    private Double metersPerMinute;
    private Double kilometersPerHour;

}