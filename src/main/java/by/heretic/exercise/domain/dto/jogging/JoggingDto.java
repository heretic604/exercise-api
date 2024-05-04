package by.heretic.exercise.domain.dto.jogging;

import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;
import java.time.LocalTime;

@FieldNameConstants
public record JoggingDto(

        Long joggingId,
        LocalDate joggingDate,
        Integer meters,
        LocalTime joggingTime,
        Double metersPerMinute,
        Double kilometersPerHour

) {
}