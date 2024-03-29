package by.heretic.exercise.mapper;

import by.heretic.exercise.domain.dto.jogging.JoggingCreateDto;
import by.heretic.exercise.domain.dto.jogging.JoggingDto;
import by.heretic.exercise.domain.entity.Jogging;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

import static by.heretic.exercise.util.Calculator.calculateKilometersPerHour;
import static by.heretic.exercise.util.Calculator.calculateMetersPerMinute;

@Mapper
public interface JoggingMapper {

    @Mapping(target = "joggingId", ignore = true)
    @Mapping(target = "metersPerMinute", expression = "java(mapMetersPerMinute(createDto))")
    @Mapping(target = "kilometersPerHour", expression = "java(mapKmPerHour(createDto))")
    Jogging toEntity(JoggingCreateDto createDto);

    JoggingDto toDto(Jogging jogging);

    default Page<JoggingDto> toDtoPage(Page<Jogging> joggingPage) {
        return new PageImpl<>(pageToListDto(joggingPage), joggingPage.getPageable(), joggingPage.getTotalElements());
    }

    default List<JoggingDto> pageToListDto(Page<Jogging> joggingPage) {
        return joggingPage.getContent().stream()
                .map(this::toDto)
                .toList();
    }

    default Integer mapMetersPerMinute(JoggingCreateDto createDto) {
        return calculateMetersPerMinute(createDto.meters(), createDto.minutes());
    }

    default Integer mapKmPerHour(JoggingCreateDto createDto) {
        return calculateKilometersPerHour(createDto.meters(), createDto.minutes());
    }

}