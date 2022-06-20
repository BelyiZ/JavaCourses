package com.spring.crud.controller.NOT_FOUND;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.crud.dto.OctopusDTO;
import com.spring.crud.service.OctopusTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class OctopusControllerNotFoundOkTest {

    public static final Integer INVALID_ID = Integer.MAX_VALUE;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OctopusTestService octopusTestService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getOctopusNotFound() throws Exception {
        mockMvc.perform(get("/api/octopus/" + INVALID_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void editOctopusNotFound() throws Exception {
        OctopusDTO octopusDTO = octopusTestService.createOctopusDTO();
        mockMvc.perform(put("/api/octopus/" + INVALID_ID)
                        .content(objectMapper.writeValueAsString(octopusDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

    @Test
    public void deleteOctopusNotFound() throws Exception {
        mockMvc.perform(delete("/api/octopus/" + INVALID_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}