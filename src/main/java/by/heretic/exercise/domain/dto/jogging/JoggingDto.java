package by.heretic.exercise.domain.dto.jogging;

import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@FieldNameConstants
public record JoggingDto(

        Long joggingId,
        LocalDate joggingDate,
        Integer meters,
        Integer minutes,
        Integer metersPerMinute,
        Integer kilometersPerHour

) {
}