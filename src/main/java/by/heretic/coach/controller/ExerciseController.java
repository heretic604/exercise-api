package by.heretic.coach.controller;

import by.heretic.coach.domain.dto.exercise.ExerciseCreateDto;
import by.heretic.coach.domain.dto.exercise.name.ExerciseNameCreateDto;
import by.heretic.coach.domain.entity.Exercise;
import by.heretic.coach.service.ExerciseNameService;
import by.heretic.coach.service.ExerciseService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static by.heretic.coach.util.Constants.DELETE;
import static by.heretic.coach.util.Constants.NAME;
import static by.heretic.coach.util.Constants.EXERCISES_BASE_URL;
import static by.heretic.coach.util.Constants.EXERCISES_PATH;
import static by.heretic.coach.util.Constants.PAGE_SIZE;
import static by.heretic.coach.util.Constants.REDIRECT;
import static by.heretic.coach.util.Constants.SAVE;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Controller
@AllArgsConstructor
@RequestMapping(EXERCISES_BASE_URL)
public class ExerciseController {

    private final ExerciseService exerciseService;
    private final ExerciseNameService exerciseNameService;

    @GetMapping
    public String getAll(Model model,
                         @PageableDefault(size = PAGE_SIZE, sort = Exercise.Fields.exerciseDate, direction = DESC)
                         Pageable pageable) {
        var strengthExercisePage = exerciseService.getAll(pageable);
        model.addAttribute("exercises", strengthExercisePage.getContent());
        model.addAttribute("exercisesNames", exerciseNameService.getAll());
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
        exerciseService.create(createDto);
        return REDIRECT + EXERCISES_BASE_URL;
    }

    @PostMapping(NAME + SAVE)
    public String saveExerciseName(@ModelAttribute ExerciseNameCreateDto createDto) {
        exerciseNameService.create(createDto);
        return REDIRECT + EXERCISES_BASE_URL;
    }

    @PostMapping(DELETE)
    public String deleteExercise(@PathVariable("id") Long id) {
        exerciseService.delete(id);
        return REDIRECT + EXERCISES_BASE_URL;
    }

}