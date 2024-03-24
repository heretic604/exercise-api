package by.heretic.coach.mapper.exercise.strength;

import by.heretic.coach.domain.dto.strength_exercise.StrengthExerciseCreateDto;
import by.heretic.coach.domain.dto.strength_exercise.StrengthExerciseDto;
import by.heretic.coach.domain.entity.exercise.strength.StrengthExercise;
import by.heretic.coach.domain.entity.exercise.strength.name.StrengthExerciseName;
import by.heretic.coach.repository.exercise.strength.name.StrengthExerciseNameRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class StrengthExerciseMapper {

    @Autowired
    private StrengthExerciseNameRepository strengthExerciseNameRepository;

    @Mapping(target = "strengthExerciseId", ignore = true)
    @Mapping(target = "strengthExerciseName", expression = "java(mapStrengthExerciseName(strengthExerciseCreateDto))")
    public abstract StrengthExercise toEntity(StrengthExerciseCreateDto strengthExerciseCreateDto);

    @Mapping(target = "strengthExerciseName", source = "strengthExerciseName.strengthExerciseName")
    public abstract StrengthExerciseDto toStrengthExerciseDto(StrengthExercise strengthExercise);

    protected StrengthExerciseName mapStrengthExerciseName(StrengthExerciseCreateDto strengthExerciseCreateDto) {
        return strengthExerciseNameRepository.findById(strengthExerciseCreateDto.getStrengthExerciseNameId())
                .orElseThrow();
    }

}