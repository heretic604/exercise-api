package by.heretic.strength_exercise_api.controller;

import by.heretic.strength_exercise_api.api.ExerciseApi;
import by.heretic.strength_exercise_api.domain.dto.exercise.ExerciseCreateDto;
import by.heretic.strength_exercise_api.domain.dto.exercise.name.ExerciseNameCreateDto;
import by.heretic.strength_exercise_api.domain.entity.Exercise;
import by.heretic.strength_exercise_api.service.impl.ExerciseNameServiceImpl;
import by.heretic.strength_exercise_api.service.impl.ExerciseServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static by.heretic.strength_exercise_api.util.Constants.DELETE;
import static by.heretic.strength_exercise_api.util.Constants.NAME;
import static by.heretic.strength_exercise_api.util.Constants.EXERCISES_BASE_URL;
import static by.heretic.strength_exercise_api.util.Constants.EXERCISES_PATH;
import static by.heretic.strength_exercise_api.util.Constants.PAGE_SIZE;
import static by.heretic.strength_exercise_api.util.Constants.REDIRECT;
import static by.heretic.strength_exercise_api.util.Constants.SAVE;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Controller
@AllArgsConstructor
@RequestMapping(EXERCISES_BASE_URL)
public class ExerciseController implements ExerciseApi {

    private final ExerciseServiceImpl exerciseServiceImpl;
    private final ExerciseNameServiceImpl exerciseNameServiceImpl;

    @GetMapping
    public String getAll(Model model,
                         @PageableDefault(size = PAGE_SIZE, sort = Exercise.Fields.exerciseDate, direction = DESC)
                         Pageable pageable) {
        var strengthExercisePage = exerciseServiceImpl.getAll(pageable);
        model.addAttribute("exercises", strengthExercisePage.getContent());
        model.addAttribute("exercisesNames", exerciseNameServiceImpl.getAll());
        model.addAttribute("currentPage", pageable.getPageNumber());
        model.addAttribute("totalPages", strengthExercisePage.getTotalPages());
        model.addAttribute("baseUrl", EXERCISES_BASE_URL);
        model.addAttribute("saveExerciseUrl", EXERCISES_BASE_URL + SAVE);
        model.addAttribute("deleteUrl", EXERCISES_BASE_URL + DELETE);
        model.addAttribute("saveExerciseNameUrl", EXERCISES_BASE_URL + NAME + SAVE);
        return EXERCISES_PATH;
    }

    @PostMapping(SAVE)
    public String saveExercise(@ModelAttribute ExerciseCreateDto createDto) {
        exerciseServiceImpl.create(createDto);
        return REDIRECT + EXERCISES_BASE_URL;
    }

    @PostMapping(NAME + SAVE)
    public String saveExerciseName(@ModelAttribute ExerciseNameCreateDto createDto) {
        exerciseNameServiceImpl.create(createDto);
        return REDIRECT + EXERCISES_BASE_URL;
    }

    @PostMapping(DELETE)
    @Operation(summary = "Delete an exercise by ID")
    @ApiResponse(responseCode = "204", description = "Exercise deleted")
    public String deleteExercise(@PathVariable("id") Long id) {
        exerciseServiceImpl.delete(id);
        return REDIRECT + EXERCISES_BASE_URL;
    }

}