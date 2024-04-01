package by.heretic.exercise.controller;

import by.heretic.exercise.domain.dto.exercise.ExerciseCreateDto;
import by.heretic.exercise.domain.dto.exercise.ExerciseDto;
import by.heretic.exercise.domain.dto.exercise.name.ExerciseNameCreateDto;
import by.heretic.exercise.service.ExerciseNameService;
import by.heretic.exercise.service.ExerciseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static by.heretic.exercise.util.Constants.DELETE;
import static by.heretic.exercise.util.Constants.DELETE_EXERCISE_DESCRIPTION;
import static by.heretic.exercise.util.Constants.EXERCISES_BASE_URL;
import static by.heretic.exercise.util.Constants.EXERCISE_API_DESCRIPTION;
import static by.heretic.exercise.util.Constants.EXERCISE_API_NAME;
import static by.heretic.exercise.util.Constants.EXERCISE_PAGE_PATH;
import static by.heretic.exercise.util.Constants.GET_ALL_EXERCISES_DESCRIPTION;
import static by.heretic.exercise.util.Constants.JOGGING_BASE_URL;
import static by.heretic.exercise.util.Constants.NAME;
import static by.heretic.exercise.util.Constants.PAGE_SIZE;
import static by.heretic.exercise.util.Constants.REDIRECT;
import static by.heretic.exercise.util.Constants.SAVE;
import static by.heretic.exercise.util.Constants.SAVE_EXERCISE_DESCRIPTION;
import static by.heretic.exercise.util.Constants.SAVE_EXERCISE_NAME_DESCRIPTION;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Controller
@RequiredArgsConstructor
@RequestMapping(EXERCISES_BASE_URL)
@Tag(name = EXERCISE_API_NAME, description = EXERCISE_API_DESCRIPTION)
public class ExerciseController {

    private final ExerciseService exerciseService;
    private final ExerciseNameService exerciseNameService;

    @GetMapping
    @Operation(summary = GET_ALL_EXERCISES_DESCRIPTION)
    public String getAll(Model model,
                         @PageableDefault(size = PAGE_SIZE, sort = ExerciseDto.Fields.exerciseDate, direction = DESC)
                         Pageable pageable) {
        var exercisePage = exerciseService.getAll(pageable);

        model.addAttribute("exercises", exercisePage.getContent());
        model.addAttribute("exercisesNames", exerciseNameService.getAll());
        model.addAttribute("currentPage", pageable.getPageNumber());
        model.addAttribute("totalPages", exercisePage.getTotalPages());
        model.addAttribute("exerciseBaseUrl", EXERCISES_BASE_URL);
        model.addAttribute("joggingBaseUrl", JOGGING_BASE_URL);
        model.addAttribute("saveExerciseUrl", EXERCISES_BASE_URL + SAVE);
        model.addAttribute("deleteUrl", EXERCISES_BASE_URL + DELETE);
        model.addAttribute("saveExerciseNameUrl", EXERCISES_BASE_URL + NAME + SAVE);

        return EXERCISE_PAGE_PATH;
    }

    @PostMapping(SAVE)
    @Operation(summary = SAVE_EXERCISE_DESCRIPTION)
    public String saveExercise(@ModelAttribute ExerciseCreateDto createDto) {
        exerciseService.create(createDto);
        return REDIRECT + EXERCISES_BASE_URL;
    }

    @PostMapping(NAME + SAVE)
    @Operation(summary = SAVE_EXERCISE_NAME_DESCRIPTION)
    public String saveExerciseName(@ModelAttribute ExerciseNameCreateDto createDto) {
        exerciseNameService.create(createDto);
        return REDIRECT + EXERCISES_BASE_URL;
    }

    @PostMapping(DELETE)
    @Operation(summary = DELETE_EXERCISE_DESCRIPTION)
    public String deleteExercise(@PathVariable("id") Long id) {
        exerciseService.delete(id);
        return REDIRECT + EXERCISES_BASE_URL;
    }

}