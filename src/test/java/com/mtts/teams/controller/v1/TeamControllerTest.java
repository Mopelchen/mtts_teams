package com.mtts.teams.controller.v1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TeamController.class)
class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_getTeam() throws Exception {
        mockMvc
                .perform(get("/42"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()", Matchers.is(2)))
                .andExpect(jsonPath("$.id", Matchers.is(42)))
                .andExpect(jsonPath("$.name", Matchers.is("SuperTeam")));
    }@Test
    public void test_getTeam_noId() throws Exception {
        mockMvc
                .perform(get("/"))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void test_postTeam() throws Exception {

        mockMvc
                .perform(post("/")
                        .content("{\"name\": \"AnotherSuperTeam\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()", Matchers.is(2)))
                .andExpect(jsonPath("$.id", Matchers.is(43)))
                .andExpect(jsonPath("$.name", Matchers.is("AnotherSuperTeam")));
    }

    @Test
    public void test_postTeam_noBody() throws Exception {

        mockMvc
                .perform(post("/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void test_putTeam() throws Exception {

        mockMvc
                .perform(put("/44")
                        .content("{\"id\":\"44\", \"name\": \"AnotherSuperTeam\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()", Matchers.is(2)))
                .andExpect(jsonPath("$.id", Matchers.is(44)))
                .andExpect(jsonPath("$.name", Matchers.is("Yay!-Team")));
    }

    @Test
    public void test_putTeam_noId() throws Exception {

        mockMvc
                .perform(put("/")
                        .content("{\"id\":\"44\", \"name\": \"AnotherSuperTeam\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void test_putTeam_noRequestBody() throws Exception {

        mockMvc
                .perform(put("/44")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void test_deleteTeam() throws Exception {

        mockMvc
                .perform(delete("/45"))
                .andExpect(status().isOk());
    }

    @Test
    public void test_deleteTeam_noId() throws Exception {

        mockMvc
                .perform(delete("/"))
                .andExpect(status().isMethodNotAllowed());
    }

}