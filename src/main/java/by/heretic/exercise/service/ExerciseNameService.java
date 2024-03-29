package by.heretic.exercise.service;

import by.heretic.exercise.domain.dto.exercise.name.ExerciseNameCreateDto;
import by.heretic.exercise.domain.dto.exercise.name.ExerciseNameDto;
import by.heretic.exercise.domain.entity.ExerciseName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExerciseNameService {

    /**
     * Get all exercise names
     *
     * @return exercise name DTO list
     */
    List<ExerciseNameDto> getAll();

    /**
     * Create exercise name
     *
     * @param createDto exercise name create DTO
     */
    void create(ExerciseNameCreateDto createDto);

    /**
     * Get exercise name by ID
     *
     * @param id exercise name ID
     * @return exercise name
     */
    ExerciseName get(Long id);

}