package by.heretic.coach.domain.entity.exercise.strength.name;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class StrengthExerciseName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long strengthExerciseNameId;
    private String strengthExerciseName;

}