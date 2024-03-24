package by.heretic.coach.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@FieldNameConstants
public class StrengthExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long strengthExerciseId;
    private String strengthExerciseName;
    private Integer setCount;
    private Integer repetition;
    private LocalDate strengthExerciseDate;

}