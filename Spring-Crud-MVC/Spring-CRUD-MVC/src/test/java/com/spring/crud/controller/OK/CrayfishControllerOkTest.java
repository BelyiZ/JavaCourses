package com.spring.crud.controller.OK;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.crud.dto.CrayfishDTO;
import com.spring.crud.model.crayfish.Crayfish;
import com.spring.crud.repository.CrayfishRepository;
import com.spring.crud.service.CrayfishTestService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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
public class CrayfishControllerOkTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CrayfishTestService crayfishTestService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CrayfishRepository crayfishRepository;

    @Test
    public void getCrayfishOk() throws Exception {
        Crayfish crayfish = null;
        try {
            crayfish = crayfishTestService.createCrayfish();
            String response = mockMvc.perform(get("/api/crayfish/" + crayfish.getId())
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

            Crayfish crayfishFromResponse = objectMapper.readValue(response, Crayfish.class);

            Assertions.assertEquals(crayfishFromResponse.getCrayfishType(), crayfish.getCrayfishType());
            Assertions.assertEquals(crayfishFromResponse.getWeight(), crayfish.getWeight());
        } finally {
            if (crayfish != null) crayfishRepository.delete(crayfish);
        }
    }

    @Test
    public void createCrayfishOk() throws Exception {
        CrayfishDTO crayfishDTO = crayfishTestService.createCrayfishDTO();
        Crayfish crayfish = null;
        try {
            String response = mockMvc.perform(post("/api/crayfish")
                            .content(objectMapper.writeValueAsString(crayfishDTO))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

            Long crayfishId = objectMapper.readTree(response).longValue();
            crayfish = crayfishRepository.findById(crayfishId).orElse(null);

            Assertions.assertNotNull(crayfish);
            Assertions.assertEquals(crayfishDTO.getWeight(), crayfish.getWeight());
            Assertions.assertEquals(crayfishDTO.getCrayfishType(), crayfish.getCrayfishType());
        } finally {
            if (crayfish != null) {
                crayfishRepository.delete(crayfish);
            }
        }
    }

    @Test
    public void editCrayfishOk() throws Exception {
        CrayfishDTO crayfishDTO = crayfishTestService.createCrayfishDTO();
        Crayfish crayfish = null;
        try {
            crayfish = crayfishTestService.createCrayfish();
            String response = mockMvc.perform(put("/api/crayfish/" + crayfish.getId())
                            .content(objectMapper.writeValueAsString(crayfishDTO))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

            Long crayfishId = objectMapper.readTree(response).longValue();
            Crayfish crayfishFromResponse = crayfishRepository.findById(crayfishId).orElse(null);

            Assertions.assertNotNull(crayfishFromResponse);
            Assertions.assertEquals(crayfishDTO.getWeight(), crayfishFromResponse.getWeight());
            Assertions.assertNotEquals(crayfish.getWeight(), crayfishFromResponse.getWeight());
            Assertions.assertNotEquals(crayfish.getCrayfishType(), crayfishFromResponse.getCrayfishType());
        } finally {
            if (crayfish != null) {
                crayfishRepository.delete(crayfish);
            }
        }
    }

    @Test
    public void deleteCrayfishOk() throws Exception {
        Crayfish crayfish = null;
        try {
            crayfish = crayfishTestService.createCrayfish();
            mockMvc.perform(delete("/api/crayfish/" + crayfish.getId())
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

            Crayfish updateCrayfish = crayfishRepository.findById(crayfish.getId()).orElse(null);

            Assertions.assertNotNull(updateCrayfish);
            Assertions.assertTrue(updateCrayfish.isDeleted());
        } finally {
            if (crayfish != null) {
                crayfishRepository.delete(crayfish);
            }
        }
    }
}