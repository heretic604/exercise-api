package by.heretic.strength_exercise_api.mapper;

import by.heretic.strength_exercise_api.domain.dto.exercise.name.ExerciseNameCreateDto;
import by.heretic.strength_exercise_api.domain.dto.exercise.name.ExerciseNameDto;
import by.heretic.strength_exercise_api.domain.entity.ExerciseName;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ExerciseNameMapper {

    List<ExerciseNameDto> toStrengthExerciseDtoList(List<ExerciseName> entityNames);

    @Mapping(target = "exerciseNameId", ignore = true)
    ExerciseName toEntity(ExerciseNameCreateDto createDto);

}