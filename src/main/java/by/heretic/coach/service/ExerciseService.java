package by.heretic.coach.service;

import by.heretic.coach.domain.dto.exercise.ExerciseCreateDto;
import by.heretic.coach.domain.dto.exercise.ExerciseDto;
import by.heretic.coach.mapper.exercise.ExerciseMapper;
import by.heretic.coach.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    public void create(ExerciseCreateDto exerciseCreateDto) {
        exerciseRepository.save(exerciseMapper.toEntity(exerciseCreateDto));
    }

    public List<ExerciseDto> getAll() {
        return exerciseRepository.findAll().stream()
                .map(exerciseMapper::toExerciseDto)
                .toList();
    }

}