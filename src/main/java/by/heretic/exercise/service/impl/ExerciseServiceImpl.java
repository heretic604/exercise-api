package by.heretic.exercise.service.impl;

import by.heretic.exercise.domain.dto.exercise.ExerciseCreateDto;
import by.heretic.exercise.domain.dto.exercise.ExerciseDto;
import by.heretic.exercise.mapper.ExerciseMapper;
import by.heretic.exercise.repository.ExerciseRepository;
import by.heretic.exercise.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    public void create(ExerciseCreateDto exerciseCreateDto) {
        exerciseRepository.save(exerciseMapper.toEntity(exerciseCreateDto));
    }

    public Page<ExerciseDto> getAll(Pageable pageable) {
        var list = exerciseRepository.findAll(pageable).stream()
                .map(exerciseMapper::toStrengthExerciseDto)
                .toList();

        var total = exerciseRepository.count();
        return new PageImpl<>(list, pageable, total);
    }

    public void delete(Long id) {
        exerciseRepository.deleteById(id);
    }

}