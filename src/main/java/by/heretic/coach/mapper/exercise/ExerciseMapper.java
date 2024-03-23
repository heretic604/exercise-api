package by.heretic.coach.mapper.exercise;

import by.heretic.coach.domain.dto.exercise.ExerciseCreateDto;
import by.heretic.coach.domain.dto.exercise.ExerciseDto;
import by.heretic.coach.domain.entity.Exercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class ExerciseMapper {

    @Mapping(target = "exerciseId", ignore = true)
    public abstract Exercise toEntity(ExerciseCreateDto exerciseCreateDto);

    public abstract ExerciseDto toExerciseDto(Exercise exercise);

}