package by.heretic.coach.service;

import by.heretic.coach.domain.dto.strength_exercise.StrengthExerciseCreateDto;
import by.heretic.coach.domain.dto.strength_exercise.StrengthExerciseDto;
import by.heretic.coach.mapper.StrengthExerciseMapper;
import by.heretic.coach.repository.StrengthExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StrengthExerciseService {

    private final StrengthExerciseRepository strengthExerciseRepository;
    private final StrengthExerciseMapper strengthExerciseMapper;

    public void create(StrengthExerciseCreateDto strengthExerciseCreateDto) {
        strengthExerciseRepository.save(strengthExerciseMapper.toEntity(strengthExerciseCreateDto));
    }

    public Page<StrengthExerciseDto> getAll(Pageable pageable) {
        var list = strengthExerciseRepository.findAll(pageable).stream()
                .map(strengthExerciseMapper::toStrengthExerciseDto)
                .toList();

        var total = strengthExerciseRepository.count();

        return new PageImpl<>(list, pageable, total);
    }

    public void delete(Long id) {
        strengthExerciseRepository.deleteById(id);
    }

}