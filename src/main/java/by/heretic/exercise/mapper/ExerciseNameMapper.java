package by.heretic.exercise.mapper;

import by.heretic.exercise.domain.dto.exercise.name.ExerciseNameCreateDto;
import by.heretic.exercise.domain.dto.exercise.name.ExerciseNameDto;
import by.heretic.exercise.domain.entity.ExerciseName;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ExerciseNameMapper {

    List<ExerciseNameDto> toExerciseDtoList(List<ExerciseName> entityNames);

    @Mapping(target = "exerciseNameId", ignore = true)
    ExerciseName toEntity(ExerciseNameCreateDto createDto);

}