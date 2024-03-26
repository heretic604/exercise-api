package by.heretic.strength_exercise_api.exeption;

public class DuplicateExerciseNameException extends RuntimeException {

    public DuplicateExerciseNameException(String message) {
        super(message);
    }

}