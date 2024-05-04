package by.heretic.exercise.service;

import by.heretic.exercise.domain.dto.exercise.name.ExerciseNameCreateDto;
import by.heretic.exercise.domain.dto.exercise.name.ExerciseNameDto;
import by.heretic.exercise.domain.entity.ExerciseName;
import by.heretic.exercise.exeption.DuplicateExerciseNameException;
import by.heretic.exercise.mapper.ExerciseNameMapper;
import by.heretic.exercise.repository.ExerciseNameRepository;
import by.heretic.exercise.service.impl.ExerciseNameServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExerciseNameServiceImplTest {

    @Mock
    private ExerciseNameRepository repository;
    @Mock
    private ExerciseNameMapper mapper;
    @InjectMocks
    private ExerciseNameServiceImpl service;

    @ParameterizedTest
    @MethodSource("provideExerciseNameDtoList")
    public void getAllTest(List<ExerciseNameDto> dtoList) {
        when(repository.findAll()).thenReturn(new ArrayList<>());
        when(mapper.toExerciseDtoList(new ArrayList<>())).thenReturn(dtoList);

        assertEquals(dtoList, service.getAll());

        verify(repository).findAll();
        verify(mapper).toExerciseDtoList(anyList());
    }

    @ParameterizedTest
    @MethodSource("getExerciseNameStream")
    public void getExerciseNameDtoByIdTest(ExerciseName exerciseName) {
        when(repository.findById(anyLong())).thenReturn(Optional.of(exerciseName));

        assertEquals(exerciseName, service.get(anyLong()));

        verify(repository).findById(anyLong());
    }

    @ParameterizedTest
    @MethodSource("getExerciseNameCreateDtoStream")
    public void createExerciseNameSuccess(ExerciseNameCreateDto createDto) {
        var exerciseName = getExerciseNameStream().findFirst().orElse(new ExerciseName());

        when(repository.existsExerciseNameByExerciseName(anyString())).thenReturn(false);
        when(mapper.toEntity(any(ExerciseNameCreateDto.class))).thenReturn(exerciseName);
        when(repository.save(exerciseName)).thenReturn(exerciseName);

        service.create(createDto);

        verify(repository).existsExerciseNameByExerciseName(anyString());
        verify(mapper).toEntity(any(ExerciseNameCreateDto.class));
        verify(repository).save(exerciseName);
    }

    @ParameterizedTest
    @MethodSource("getExerciseNameCreateDtoStream")
    public void createExerciseNameThrow(ExerciseNameCreateDto createDto) {
        when(repository.existsExerciseNameByExerciseName(anyString())).thenReturn(true);

        assertThrows(DuplicateExerciseNameException.class, () -> service.create(createDto));

        verify(repository).existsExerciseNameByExerciseName(anyString());
    }

    private static Stream<List<ExerciseNameDto>> provideExerciseNameDtoList() {
        return Stream.of(getExerciseNameDtoStream().toList());
    }

    private static Stream<ExerciseNameDto> getExerciseNameDtoStream() {
        var dto1 = new ExerciseNameDto(1L, "exercise1");
        var dto2 = new ExerciseNameDto(2L, "exercise2");

        return Stream.of(dto1, dto2);
    }

    private static Stream<ExerciseName> getExerciseNameStream() {
        var exerciseName = new ExerciseName();
        exerciseName.setExerciseNameId(1L);
        exerciseName.setExerciseName("exerciseName");

        return Stream.of(exerciseName);
    }

    private static Stream<ExerciseNameCreateDto> getExerciseNameCreateDtoStream() {
        return Stream.of(new ExerciseNameCreateDto("exerciseName"));
    }

}