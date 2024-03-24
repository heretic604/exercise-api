package by.heretic.coach.domain.entity.exercise.strength;

import by.heretic.coach.domain.entity.exercise.strength.name.StrengthExerciseName;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "strength_exercise_name_id")
    private StrengthExerciseName strengthExerciseName;

    private Integer setCount;
    private Integer repetition;
    private LocalDate strengthExerciseDate;

}