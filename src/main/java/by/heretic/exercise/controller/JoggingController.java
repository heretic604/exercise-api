package by.heretic.exercise.controller;

import by.heretic.exercise.domain.dto.exercise.ExerciseDto;
import by.heretic.exercise.domain.dto.jogging.JoggingCreateDto;
import by.heretic.exercise.domain.dto.jogging.JoggingDto;
import by.heretic.exercise.service.JoggingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

import static by.heretic.exercise.util.Constants.DELETE;
import static by.heretic.exercise.util.Constants.DELETE_JOGGING_DESCRIPTION;
import static by.heretic.exercise.util.Constants.EXERCISES_BASE_URL;
import static by.heretic.exercise.util.Constants.GET_ALL_JOGGING_DESCRIPTION;
import static by.heretic.exercise.util.Constants.JOGGING_API_DESCRIPTION;
import static by.heretic.exercise.util.Constants.JOGGING_API_NAME;
import static by.heretic.exercise.util.Constants.JOGGING_BASE_URL;
import static by.heretic.exercise.util.Constants.JOGGING_PAGE_PATH;
import static by.heretic.exercise.util.Constants.PAGE_SIZE;
import static by.heretic.exercise.util.Constants.REDIRECT;
import static by.heretic.exercise.util.Constants.SAVE;
import static by.heretic.exercise.util.Constants.SAVE_JOGGING_DESCRIPTION;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Controller
@AllArgsConstructor
@RequestMapping(JOGGING_BASE_URL)
@Tag(name = JOGGING_API_NAME, description = JOGGING_API_DESCRIPTION)
public class JoggingController {

    private final JoggingService joggingService;

    @GetMapping
    @Operation(summary = GET_ALL_JOGGING_DESCRIPTION)
    public String getAll(Model model,
                         @PageableDefault(size = PAGE_SIZE, sort = JoggingDto.Fields.joggingDate, direction = DESC)
                         Pageable pageable) {
        var joggingPage = joggingService.getAll(pageable);

        model.addAttribute("joggingList", joggingPage.getContent());
        model.addAttribute("currentPage", pageable.getPageNumber());
        model.addAttribute("totalPages", joggingPage.getTotalPages());
        model.addAttribute("joggingBaseUrl", JOGGING_BASE_URL);
        model.addAttribute("exerciseBaseUrl", EXERCISES_BASE_URL);
        model.addAttribute("saveJoggingUrl", JOGGING_BASE_URL + SAVE);
        model.addAttribute("deleteUrl", JOGGING_BASE_URL + DELETE);

        return JOGGING_PAGE_PATH;
    }

    @PostMapping(SAVE)
    @Operation(summary = SAVE_JOGGING_DESCRIPTION)
    public String save(@ModelAttribute JoggingCreateDto createDto) {
        joggingService.create(createDto);
        return REDIRECT + JOGGING_BASE_URL;
    }

    @PostMapping(DELETE)
    @Operation(summary = DELETE_JOGGING_DESCRIPTION)
    public String delete(@PathVariable("id") Long id) {
        joggingService.delete(id);
        return REDIRECT + JOGGING_BASE_URL;
    }

}