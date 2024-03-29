package by.heretic.exercise.domain.dto.jogging;

import java.time.LocalDate;

public record JoggingCreateDto(

        LocalDate joggingDate,
        Integer meters,
        Integer minutes

) {
}