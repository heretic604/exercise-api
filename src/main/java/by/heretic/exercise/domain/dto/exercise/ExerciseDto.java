package by.heretic.exercise.domain.dto.exercise;

import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@FieldNameConstants
public record ExerciseDto(

        Long exerciseId,
        String exerciseName,
        Integer setCount,
        Integer repetition,
        LocalDate exerciseDate

) {
}