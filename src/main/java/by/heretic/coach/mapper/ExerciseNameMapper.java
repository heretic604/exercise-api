package by.heretic.coach.mapper;

import by.heretic.coach.domain.dto.exercise.name.ExerciseNameCreateDto;
import by.heretic.coach.domain.dto.exercise.name.ExerciseNameDto;
import by.heretic.coach.domain.entity.ExerciseName;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ExerciseNameMapper {

    List<ExerciseNameDto> toStrengthExerciseDtoList(List<ExerciseName> entityNames);

    @Mapping(target = "exerciseNameId", ignore = true)
    ExerciseName toEntity(ExerciseNameCreateDto createDto);

}