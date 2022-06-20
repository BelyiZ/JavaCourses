package com.spring.crud.controller.VALIDATION;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.crud.dto.CaviarDTO;
import com.spring.crud.service.CaviarTestService;
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
public class CaviarControllerValidationTest {

    public static final Integer INVALID_ID = Integer.MAX_VALUE;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CaviarTestService caviarTestService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void createCaviarValidationBadRequest() throws Exception {
        CaviarDTO caviarDTO = caviarTestService.createCaviarDTOBadValidation();
        mockMvc.perform(post("/api/caviar")
                        .content(objectMapper.writeValueAsString(caviarDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void editCaviarNotFound() throws Exception {
        CaviarDTO caviarDTO = caviarTestService.createCaviarDTOInvalidValues();
        mockMvc.perform(put("/api/caviar/" + INVALID_ID)
                        .content(objectMapper.writeValueAsString(caviarDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());

    }
}