package by.heretic.exercise.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class ExerciseName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exerciseNameId;
    private String exerciseName;

}