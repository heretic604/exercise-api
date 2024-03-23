package by.heretic.coach.controller;

import by.heretic.coach.domain.dto.exercise.ExerciseCreateDto;
import by.heretic.coach.service.ExerciseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static by.heretic.coach.util.Constants.ADD;
import static by.heretic.coach.util.Constants.ADD_EXERCISES_PATH;
import static by.heretic.coach.util.Constants.EXERCISES_BASE_URL;
import static by.heretic.coach.util.Constants.EXERCISES_PATH;
import static by.heretic.coach.util.Constants.REDIRECT;
import static by.heretic.coach.util.Constants.SAVE;

@Controller
@AllArgsConstructor
@RequestMapping(EXERCISES_BASE_URL)
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("exercises", exerciseService.getAll());
        model.addAttribute("addExerciseUrl", EXERCISES_BASE_URL + ADD);
        return EXERCISES_PATH;
    }

    @GetMapping(ADD)
    public String showAddExerciseForm(Model model) {
        model.addAttribute("saveExerciseUrl", EXERCISES_BASE_URL + SAVE);
        return ADD_EXERCISES_PATH;
    }

    @PostMapping(SAVE)
    public String saveExercise(@ModelAttribute ExerciseCreateDto createDto) {
        exerciseService.create(createDto);
        return REDIRECT + EXERCISES_BASE_URL;
    }

}