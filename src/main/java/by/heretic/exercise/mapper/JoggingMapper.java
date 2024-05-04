package by.heretic.exercise.mapper;

import by.heretic.exercise.calculator.SpeedCalculator;
import by.heretic.exercise.domain.dto.jogging.JoggingCreateDto;
import by.heretic.exercise.domain.dto.jogging.JoggingDto;
import by.heretic.exercise.domain.entity.Jogging;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper
public abstract class JoggingMapper {

    @Autowired
    private SpeedCalculator speedCalculator;

    @Mapping(target = "joggingId", ignore = true)
    @Mapping(target = "metersPerMinute", expression = "java(mapMetersPerMinute(createDto))")
    @Mapping(target = "kilometersPerHour", expression = "java(mapKmPerHour(createDto))")
    public abstract Jogging toEntity(JoggingCreateDto createDto);

    public abstract JoggingDto toDto(Jogging jogging);

    public Page<JoggingDto> toDtoPage(Page<Jogging> joggingPage) {
        return new PageImpl<>(pageToListDto(joggingPage), joggingPage.getPageable(), joggingPage.getTotalElements());
    }

    public List<JoggingDto> pageToListDto(Page<Jogging> joggingPage) {
        return joggingPage.getContent().stream()
                .map(this::toDto)
                .toList();
    }

    public Double mapMetersPerMinute(JoggingCreateDto createDto) {
        return speedCalculator.calculateMetersPerMinute(createDto.meters(), createDto.joggingTime());
    }

    public Double mapKmPerHour(JoggingCreateDto createDto) {
        return speedCalculator.calculateKilometersPerHour(createDto.meters(), createDto.joggingTime());
    }

}