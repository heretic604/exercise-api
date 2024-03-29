package by.heretic.strength_exercise_api.service;

import by.heretic.strength_exercise_api.domain.dto.exercise.ExerciseCreateDto;
import by.heretic.strength_exercise_api.domain.dto.exercise.ExerciseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExerciseService {

    /**
     * Create exercise
     *
     * @param exerciseCreateDto exercise create DTO
     */
    void create(ExerciseCreateDto exerciseCreateDto);

    /**
     * Get all exercises
     *
     * @param pageable pagination parameters
     * @return exercise DTO list
     */
    Page<ExerciseDto> getAll(Pageable pageable);

    /**
     * Remove exercise
     *
     * @param id exercise ID
     */
    void delete(Long id);

}