package by.heretic.exercise.domain.dto.jogging;

import java.time.LocalDate;
import java.time.LocalTime;

public record JoggingCreateDto(

        LocalDate joggingDate,
        Integer meters,
        LocalTime joggingTime

) {
}