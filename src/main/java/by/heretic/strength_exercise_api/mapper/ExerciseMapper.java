package by.heretic.strength_exercise_api.mapper;

import by.heretic.strength_exercise_api.domain.dto.exercise.ExerciseCreateDto;
import by.heretic.strength_exercise_api.domain.dto.exercise.ExerciseDto;
import by.heretic.strength_exercise_api.domain.entity.Exercise;
import by.heretic.strength_exercise_api.domain.entity.ExerciseName;
import by.heretic.strength_exercise_api.repository.ExerciseNameRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class ExerciseMapper {

    @Autowired
    private ExerciseNameRepository exerciseNameRepository;

    @Mapping(target = "exerciseId", ignore = true)
    @Mapping(target = "exerciseName", expression = "java(mapStrengthExerciseName(exerciseCreateDto))")
    public abstract Exercise toEntity(ExerciseCreateDto exerciseCreateDto);

    @Mapping(target = "exerciseName", source = "exerciseName.exerciseName")
    public abstract ExerciseDto toStrengthExerciseDto(Exercise exercise);

    protected ExerciseName mapStrengthExerciseName(ExerciseCreateDto exerciseCreateDto) {
        return exerciseNameRepository.findById(exerciseCreateDto.exerciseNameId())
                .orElseThrow();
    }

}