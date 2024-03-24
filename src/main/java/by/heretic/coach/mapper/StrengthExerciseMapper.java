package by.heretic.coach.mapper;

import by.heretic.coach.domain.dto.strength_exercise.StrengthExerciseCreateDto;
import by.heretic.coach.domain.dto.strength_exercise.StrengthExerciseDto;
import by.heretic.coach.domain.entity.StrengthExercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class StrengthExerciseMapper {

    @Mapping(target = "strengthExerciseId", ignore = true)
    public abstract StrengthExercise toEntity(StrengthExerciseCreateDto strengthExerciseCreateDto);

    public abstract StrengthExerciseDto toStrengthExerciseDto(StrengthExercise strengthExercise);

}