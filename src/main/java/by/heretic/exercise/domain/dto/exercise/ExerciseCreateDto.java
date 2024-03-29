package by.heretic.exercise.domain.dto.exercise;

import java.time.LocalDate;

public record ExerciseCreateDto(

        Long exerciseNameId,
        Integer setCount,
        Integer repetition,
        LocalDate exerciseDate

) {
}