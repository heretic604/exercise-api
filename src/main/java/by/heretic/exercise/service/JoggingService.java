package by.heretic.exercise.service;

import by.heretic.exercise.domain.dto.jogging.JoggingCreateDto;
import by.heretic.exercise.domain.dto.jogging.JoggingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JoggingService {

    /**
     * Get all jogging list
     *
     * @return jogging DTO list
     */
    Page<JoggingDto> getAll(Pageable pageable);

    /**
     * Save jogging
     *
     * @param createDto Jogging create DTO
     */
    void create(JoggingCreateDto createDto);

    /**
     * Remove jogging
     *
     * @param id jogging to remove
     */
    void delete(Long id);

}