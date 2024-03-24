package by.heretic.coach.controller;

import by.heretic.coach.domain.dto.strength_exercise.StrengthExerciseCreateDto;
import by.heretic.coach.domain.entity.StrengthExercise;
import by.heretic.coach.service.StrengthExerciseService;
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
import static by.heretic.coach.util.Constants.STRENGTH_EXERCISES_BASE_URL;
import static by.heretic.coach.util.Constants.STRENGTH_EXERCISES_PATH;
import static by.heretic.coach.util.Constants.PAGE_SIZE;
import static by.heretic.coach.util.Constants.REDIRECT;
import static by.heretic.coach.util.Constants.SAVE;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Controller
@AllArgsConstructor
@RequestMapping(STRENGTH_EXERCISES_BASE_URL)
public class StrengthExerciseController {

    private final StrengthExerciseService strengthExerciseService;

    @GetMapping
    public String getAll(Model model,
                         @PageableDefault(size = PAGE_SIZE, sort = StrengthExercise.Fields.strengthExerciseDate, direction = DESC)
                         Pageable pageable) {
        var strengthExercisePage = strengthExerciseService.getAll(pageable);
        model.addAttribute("strengthExercises", strengthExercisePage.getContent());
        model.addAttribute("currentPage", pageable.getPageNumber());
        model.addAttribute("totalPages", strengthExercisePage.getTotalPages());
        model.addAttribute("baseUrl", STRENGTH_EXERCISES_BASE_URL);
        model.addAttribute("saveExerciseUrl", STRENGTH_EXERCISES_BASE_URL + SAVE);
        model.addAttribute("deleteUrl", STRENGTH_EXERCISES_BASE_URL + DELETE);
        return STRENGTH_EXERCISES_PATH;
    }

    @PostMapping(SAVE)
    public String saveExercise(@ModelAttribute StrengthExerciseCreateDto createDto) {
        strengthExerciseService.create(createDto);
        return REDIRECT + STRENGTH_EXERCISES_BASE_URL;
    }

    @PostMapping(DELETE)
    public String deleteExercise(@PathVariable("id") Long id) {
        strengthExerciseService.delete(id);
        return REDIRECT + STRENGTH_EXERCISES_BASE_URL;
    }

}