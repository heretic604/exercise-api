package by.heretic.exercise.mapper;

import by.heretic.exercise.domain.dto.exercise.ExerciseCreateDto;
import by.heretic.exercise.domain.dto.exercise.ExerciseDto;
import by.heretic.exercise.domain.entity.Exercise;
import by.heretic.exercise.domain.entity.ExerciseName;
import by.heretic.exercise.service.ExerciseNameService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper
public abstract class ExerciseMapper {

    @Autowired
    private ExerciseNameService exerciseNameService;

    @Mapping(target = "exerciseId", ignore = true)
    @Mapping(target = "exerciseName", expression = "java(mapExerciseName(exerciseCreateDto))")
    public abstract Exercise toEntity(ExerciseCreateDto exerciseCreateDto);

    public Page<ExerciseDto> toDtoPage(Page<Exercise> exercisePage) {
        return new PageImpl<>(pageToListDto(exercisePage), exercisePage.getPageable(), exercisePage.getTotalElements());
    }

    @Mapping(target = "exerciseName", source = "exerciseName.exerciseName")
    public abstract ExerciseDto toDto(Exercise exercise);

    protected List<ExerciseDto> pageToListDto(Page<Exercise> exercisePage) {
        return exercisePage.getContent().stream()
                .map(this::toDto)
                .toList();
    }

    protected ExerciseName mapExerciseName(ExerciseCreateDto exerciseCreateDto) {
        return exerciseNameService.get(exerciseCreateDto.exerciseNameId());
    }

}