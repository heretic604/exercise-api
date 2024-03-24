package by.heretic.coach.service;

import by.heretic.coach.domain.dto.exercise.ExerciseCreateDto;
import by.heretic.coach.domain.dto.exercise.ExerciseDto;
import by.heretic.coach.mapper.ExerciseMapper;
import by.heretic.coach.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseService {

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