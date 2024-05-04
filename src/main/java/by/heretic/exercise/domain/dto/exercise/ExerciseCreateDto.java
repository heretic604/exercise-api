package by.heretic.exercise.domain.dto.exercise;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ExerciseCreateDto(

        Long exerciseNameId,
        Integer setCount,
        Integer repetition,
        LocalDate exerciseDate

) {
}