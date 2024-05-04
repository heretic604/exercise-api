package by.heretic.exercise.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static by.heretic.exercise.util.Constants.DELETE;
import static by.heretic.exercise.util.Constants.EXERCISES_BASE_URL;
import static by.heretic.exercise.util.Constants.NAME;
import static by.heretic.exercise.util.Constants.SAVE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@Sql(value = "classpath:exercise.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class ExerciseControllerTest extends AbstractContainer {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    public void getAllTest() {
        var result = mockMvc.perform(get(EXERCISES_BASE_URL))
                .andExpect(status().isOk())
                .andExpect(view().name("page/exercises"))
                .andExpect(model().attributeExists("exercises"))
                .andExpect(model().attributeExists("exercisesNames"))
                .andExpect(model().attributeExists("currentPage"))
                .andExpect(model().attributeExists("totalPages"))
                .andExpect(model().attributeExists("exerciseBaseUrl"))
                .andExpect(model().attributeExists("joggingBaseUrl"))
                .andExpect(model().attributeExists("saveExerciseUrl"))
                .andExpect(model().attributeExists("deleteUrl"))
                .andExpect(model().attributeExists("saveExerciseNameUrl"))
                .andReturn().getResponse().getContentAsString();

        assertTrue(result.contains("exercise_name_10"));
        assertTrue(result.contains("exercise_name_20"));
        assertTrue(result.contains("exercise_name_30"));

        assertFalse(result.contains("exercise_name_40"));
    }

    @Test
    @SneakyThrows
    public void saveExerciseTest() {
        mockMvc.perform(post(EXERCISES_BASE_URL + SAVE)
                        .param("exerciseNameId", "10")
                        .param("setCount", "1")
                        .param("repetition", "1")
                        .param("exerciseDate", "2000-01-04"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(EXERCISES_BASE_URL));

        var result = mockMvc.perform(get(EXERCISES_BASE_URL))
                .andReturn().getResponse().getContentAsString();

        assertTrue(result.contains("2000-01-04"));
    }

    @Test
    @SneakyThrows
    public void saveExerciseNameTest() {
        mockMvc.perform(post(EXERCISES_BASE_URL + NAME + SAVE)
                        .param("exerciseName", "exercise_name_40"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(EXERCISES_BASE_URL));

        var result = mockMvc.perform(get(EXERCISES_BASE_URL))
                .andReturn().getResponse().getContentAsString();

        assertTrue(result.contains("exercise_name_40"));
    }

    @Test
    @SneakyThrows
    public void deleteExerciseTest() {
        mockMvc.perform(post(EXERCISES_BASE_URL + DELETE, 10L))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(EXERCISES_BASE_URL));

        var result = mockMvc.perform(get(EXERCISES_BASE_URL))
                .andReturn().getResponse().getContentAsString();

        assertFalse(result.contains("2000-01-10"));
    }

}