package by.heretic.exercise.exeption;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static by.heretic.exercise.util.Constants.ERROR_PATH;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateExerciseNameException.class)
    public String handleDuplicateKeyException(DuplicateExerciseNameException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return ERROR_PATH;
    }

}