package com.spring.crud.controller.VALIDATION;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class OctopusControllerValidationTest {

    public static final Integer INVALID_ID = Integer.MAX_VALUE;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OctopusTestService octopusTestService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void createOctopusValidationBadRequest() throws Exception {
        OctopusDTO octopusDTO = octopusTestService.createOctopusDTOBadValidation();
        mockMvc.perform(post("/api/octopus")
                        .content(objectMapper.writeValueAsString(octopusDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void editOctopusNotFound() throws Exception {
        OctopusDTO octopusDTO = octopusTestService.createOctopusDTOInvalidValues();
        mockMvc.perform(put("/api/octopus/" + INVALID_ID)
                        .content(objectMapper.writeValueAsString(octopusDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());

    }
}