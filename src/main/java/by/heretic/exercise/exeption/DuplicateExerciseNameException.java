package by.heretic.exercise.exeption;

public class DuplicateExerciseNameException extends RuntimeException {

    public DuplicateExerciseNameException(String message) {
        super(message);
    }

}