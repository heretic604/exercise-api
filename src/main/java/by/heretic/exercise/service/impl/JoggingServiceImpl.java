package by.heretic.exercise.service.impl;

import by.heretic.exercise.domain.dto.jogging.JoggingCreateDto;
import by.heretic.exercise.domain.dto.jogging.JoggingDto;
import by.heretic.exercise.mapper.JoggingMapper;
import by.heretic.exercise.repository.JoggingRepository;
import by.heretic.exercise.service.JoggingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoggingServiceImpl implements JoggingService {

    private final JoggingRepository joggingRepository;
    private final JoggingMapper joggingMapper;

    @Override
    public Page<JoggingDto> getAll(Pageable pageable) {
        return joggingMapper.toDtoPage(joggingRepository.findAll(pageable));
    }

    @Override
    public void create(JoggingCreateDto createDto) {
        joggingRepository.save(joggingMapper.toEntity(createDto));
    }

    @Override
    public void delete(Long id) {
        joggingRepository.deleteById(id);
    }

}