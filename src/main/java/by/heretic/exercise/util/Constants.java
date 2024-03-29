package by.heretic.exercise.util;

public final class Constants {

    private Constants() {
    }

    // Common
    public static final String SAVE = "/save";
    public static final String REDIRECT = "redirect:";
    public static final String DELETE = "/{id}/delete";
    public static final String ERROR_PATH = "error";

    // Exercises
    public static final String EXERCISES_BASE_URL = "/v1/exercises";
    public static final String EXERCISES_PATH = "exercises";
    public static final String NAME = "/name";

    // Jogging
    public static final String JOGGING_BASE_URL = "/v1/jogging";
    public static final String JOGGING_PATH = "jogging";

    // Pagination
    public static final int PAGE_SIZE = 12;

    // Exceptions
    public static final String DUPLICATE_MESSAGE = " already exists";

    // Swagger
    public static final String SWAGGER_TITLE = "Exercise Management API Documentation";
    public static final String SWAGGER_DESCRIPTION = "Service for accounting and managing exercises";
    public static final String SWAGGER_SERVER_URL = "http://localhost:9090";
    public static final String SWAGGER_VERSION = "1.0";

    // API description
    public static final String EXERCISE_API_NAME = "Exercise API";
    public static final String EXERCISE_API_DESCRIPTION = "Exercise management API";
    public static final String GET_ALL_EXERCISES_DESCRIPTION = "Return a list of exercises according pagination";
    public static final String SAVE_EXERCISE_DESCRIPTION = "Save an exercise";
    public static final String SAVE_EXERCISE_NAME_DESCRIPTION = "Save an exercise name";
    public static final String DELETE_EXERCISE_DESCRIPTION = "Delete an exercise by ID";
    public static final String JOGGING_API_NAME = "Jogging API";
    public static final String JOGGING_API_DESCRIPTION = "Jogging management API";
    public static final String GET_ALL_JOGGING_DESCRIPTION = "Return a list of jogging according pagination";
    public static final String SAVE_JOGGING_DESCRIPTION = "Save jogging";
    public static final String DELETE_JOGGING_DESCRIPTION = "Delete jogging by ID";

    // Logging
    public static final String REQUEST = ">> Request URI: ";
    public static final String RESPONSE = "<< Response Status: ";

}