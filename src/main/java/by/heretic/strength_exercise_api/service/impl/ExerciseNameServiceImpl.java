package by.heretic.strength_exercise_api.service.impl;

import by.heretic.strength_exercise_api.domain.dto.exercise.name.ExerciseNameCreateDto;
import by.heretic.strength_exercise_api.domain.dto.exercise.name.ExerciseNameDto;
import by.heretic.strength_exercise_api.exeption.DuplicateExerciseNameException;
import by.heretic.strength_exercise_api.mapper.ExerciseNameMapper;
import by.heretic.strength_exercise_api.repository.ExerciseNameRepository;
import by.heretic.strength_exercise_api.service.ExerciseNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static by.heretic.strength_exercise_api.util.Constants.DUPLICATE_MESSAGE;

@Service
@RequiredArgsConstructor
public class ExerciseNameServiceImpl implements ExerciseNameService {

    private final ExerciseNameRepository exerciseNameRepository;
    private final ExerciseNameMapper exerciseNameMapper;

    public List<ExerciseNameDto> getAll() {
        return exerciseNameMapper.toStrengthExerciseDtoList(exerciseNameRepository.findAll());
    }

    public void create(ExerciseNameCreateDto createDto) {
        var exerciseName = createDto.exerciseName();

        if (exerciseNameRepository.existsExerciseNameByExerciseName(exerciseName)) {
            throw new DuplicateExerciseNameException(exerciseName + DUPLICATE_MESSAGE);
        }

        exerciseNameRepository.save(exerciseNameMapper.toEntity(createDto));
    }

}