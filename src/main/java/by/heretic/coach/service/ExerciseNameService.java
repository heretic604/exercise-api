package by.heretic.coach.service;

import by.heretic.coach.domain.dto.exercise.name.ExerciseNameCreateDto;
import by.heretic.coach.domain.dto.exercise.name.ExerciseNameDto;
import by.heretic.coach.mapper.ExerciseNameMapper;
import by.heretic.coach.repository.ExerciseNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseNameService {

    private final ExerciseNameRepository exerciseNameRepository;
    private final ExerciseNameMapper exerciseNameMapper;

    public List<ExerciseNameDto> getAll() {
        return exerciseNameMapper.toStrengthExerciseDtoList(exerciseNameRepository.findAll());
    }

    public void create(ExerciseNameCreateDto createDto) {
        exerciseNameRepository.save(exerciseNameMapper.toEntity(createDto));
    }

}