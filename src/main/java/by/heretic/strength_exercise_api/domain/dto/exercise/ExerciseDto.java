package by.heretic.strength_exercise_api.domain.dto.exercise;

import java.time.LocalDate;

public record ExerciseDto(

        Long exerciseId,
        String exerciseName,
        Integer setCount,
        Integer repetition,
        LocalDate exerciseDate

) {
}