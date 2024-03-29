package by.heretic.exercise.service.impl;

import by.heretic.exercise.domain.dto.exercise.name.ExerciseNameCreateDto;
import by.heretic.exercise.domain.dto.exercise.name.ExerciseNameDto;
import by.heretic.exercise.domain.entity.ExerciseName;
import by.heretic.exercise.exeption.DuplicateExerciseNameException;
import by.heretic.exercise.mapper.ExerciseNameMapper;
import by.heretic.exercise.repository.ExerciseNameRepository;
import by.heretic.exercise.service.ExerciseNameService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static by.heretic.exercise.util.Constants.DUPLICATE_MESSAGE;

@Service
@RequiredArgsConstructor
public class ExerciseNameServiceImpl implements ExerciseNameService {

    private final ExerciseNameRepository exerciseNameRepository;
    private final ExerciseNameMapper exerciseNameMapper;

    @Override
    public List<ExerciseNameDto> getAll() {
        return exerciseNameMapper.toExerciseDtoList(exerciseNameRepository.findAll());
    }

    @Override
    public void create(ExerciseNameCreateDto createDto) {
        var exerciseName = createDto.exerciseName();

        if (exerciseNameRepository.existsExerciseNameByExerciseName(exerciseName)) {
            throw new DuplicateExerciseNameException(exerciseName + DUPLICATE_MESSAGE);
        }
        exerciseNameRepository.save(exerciseNameMapper.toEntity(createDto));
    }

    @Override
    public ExerciseName get(Long id) {
        return exerciseNameRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}