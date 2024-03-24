package by.heretic.coach.mapper.exercise.strength.name;

import by.heretic.coach.domain.dto.strength_exercise.StrengthExerciseCreateDto;
import by.heretic.coach.domain.dto.strength_exercise.StrengthExerciseDto;
import by.heretic.coach.domain.dto.strength_exercise.name.StrengthExerciseNameDto;
import by.heretic.coach.domain.entity.exercise.strength.StrengthExercise;
import by.heretic.coach.domain.entity.exercise.strength.name.StrengthExerciseName;
import by.heretic.coach.repository.exercise.strength.name.StrengthExerciseNameRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface StrengthExerciseNameMapper {

    List<StrengthExerciseNameDto> toStrengthExerciseDtoList(List<StrengthExerciseName> entityNames);

}