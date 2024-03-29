package by.heretic.strength_exercise_api.api;

import by.heretic.strength_exercise_api.domain.dto.exercise.ExerciseCreateDto;
import by.heretic.strength_exercise_api.domain.dto.exercise.name.ExerciseNameCreateDto;
import by.heretic.strength_exercise_api.domain.entity.Exercise;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import static by.heretic.strength_exercise_api.util.Constants.DELETE_EXERCISE_DESCRIPTION;
import static by.heretic.strength_exercise_api.util.Constants.EXERCISE_API_DESCRIPTION;
import static by.heretic.strength_exercise_api.util.Constants.EXERCISE_API_NAME;
import static by.heretic.strength_exercise_api.util.Constants.GET_ALL_EXERCISES_DESCRIPTION;
import static by.heretic.strength_exercise_api.util.Constants.PAGE_SIZE;
import static by.heretic.strength_exercise_api.util.Constants.SAVE_EXERCISE_DESCRIPTION;
import static by.heretic.strength_exercise_api.util.Constants.SAVE_EXERCISE_NAME_DESCRIPTION;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Tag(name = EXERCISE_API_NAME, description = EXERCISE_API_DESCRIPTION)
public interface ExerciseApi {

    @Operation(summary = GET_ALL_EXERCISES_DESCRIPTION)
    String getAll(Model model,
                  @PageableDefault(size = PAGE_SIZE, sort = Exercise.Fields.exerciseDate, direction = DESC)
                  Pageable pageable);

    @Operation(summary = SAVE_EXERCISE_DESCRIPTION)
    String saveExercise(@ModelAttribute ExerciseCreateDto createDto);

    @Operation(summary = SAVE_EXERCISE_NAME_DESCRIPTION)
    String saveExerciseName(@ModelAttribute ExerciseNameCreateDto createDto);

    @Operation(summary = DELETE_EXERCISE_DESCRIPTION)
    String deleteExercise(@PathVariable("id") Long id);

}