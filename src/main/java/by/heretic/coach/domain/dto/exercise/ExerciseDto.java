package by.heretic.coach.domain.dto.exercise;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExerciseDto {

    private String exerciseName;
    private Integer setCount;
    private Integer repetition;
    private LocalDate exerciseDate;

}