package by.heretic.exercise.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static by.heretic.exercise.util.Constants.DELETE;
import static by.heretic.exercise.util.Constants.JOGGING_BASE_URL;
import static by.heretic.exercise.util.Constants.SAVE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@Sql(value = "classpath:jogging.sql")
class JoggingControllerTest extends AbstractContainer {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    void getAllTest() {
        var result = mockMvc.perform(MockMvcRequestBuilders.get(JOGGING_BASE_URL))
                .andExpect(status().isOk())
                .andExpect(view().name("page/jogging"))
                .andExpect(model().attributeExists("joggingList"))
                .andExpect(model().attributeExists("currentPage"))
                .andExpect(model().attributeExists("totalPages"))
                .andExpect(model().attributeExists("joggingBaseUrl"))
                .andExpect(model().attributeExists("exerciseBaseUrl"))
                .andExpect(model().attributeExists("saveJoggingUrl"))
                .andExpect(model().attributeExists("deleteUrl"))
                .andReturn().getResponse().getContentAsString();

        assertTrue(result.contains("2000-01-01"));
        assertTrue(result.contains("2000-01-02"));
        assertTrue(result.contains("2000-01-03"));

        assertFalse(result.contains("2000-01-04"));
    }

    @Test
    @SneakyThrows
    void saveTest() {
        mockMvc.perform(MockMvcRequestBuilders.post(JOGGING_BASE_URL + SAVE)
                        .param("joggingDate", "2000-01-04")
                        .param("meters", "400")
                        .param("minutes", "40"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(JOGGING_BASE_URL));

        var result = mockMvc.perform(get(JOGGING_BASE_URL))
                .andReturn().getResponse().getContentAsString();

        assertTrue(result.contains("2000-01-04"));
    }

    @Test
    @SneakyThrows
    void deleteTest() {
        mockMvc.perform(post(JOGGING_BASE_URL + DELETE, 10L))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(JOGGING_BASE_URL));

        var result = mockMvc.perform(get(JOGGING_BASE_URL))
                .andReturn().getResponse().getContentAsString();

        assertFalse(result.contains("2000-01-01"));
    }

}