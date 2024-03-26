package by.heretic.strength_exercise_api.domain.dto.exercise;

import java.time.LocalDate;

public record ExerciseCreateDto(

        Long exerciseNameId,
        Integer setCount,
        Integer repetition,
        LocalDate exerciseDate

) {
}