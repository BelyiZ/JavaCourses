package com.spring.crud.controller.OK;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.crud.dto.CaviarDTO;
import com.spring.crud.model.caviar.Caviar;
import com.spring.crud.repository.CaviarRepository;
import com.spring.crud.service.CaviarTestService;
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
public class CaviarControllerOkTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CaviarTestService caviarTestService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CaviarRepository caviarRepository;

    @Test
    public void getCaviarOk() throws Exception {
        Caviar caviar = null;
        try {
            caviar = caviarTestService.createCaviar();
            String response = mockMvc.perform(get("/api/caviar/" + caviar.getId())
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

            Caviar caviarFromResponse = objectMapper.readValue(response, Caviar.class);

            Assertions.assertEquals(caviarFromResponse.getCaviarColor(), caviar.getCaviarColor());
            Assertions.assertEquals(caviarFromResponse.getWeight(), caviar.getWeight());
            Assertions.assertEquals(caviarFromResponse.getFish(), caviar.getFish());
        } finally {
            if (caviar != null) caviarRepository.delete(caviar);
        }
    }

    @Test
    public void createCaviarOk() throws Exception {
        CaviarDTO caviarDTO = caviarTestService.createCaviarDTO();
        Caviar caviar = null;
        try {
            String response = mockMvc.perform(post("/api/caviar")
                            .content(objectMapper.writeValueAsString(caviarDTO))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

            Long caviarId = objectMapper.readTree(response).longValue();
            caviar = caviarRepository.findById(caviarId).orElse(null);

            Assertions.assertNotNull(caviar);
            Assertions.assertEquals(caviarDTO.getWeight(), caviar.getWeight());
            Assertions.assertEquals(caviarDTO.getFish(), caviar.getFish());
        } finally {
            if (caviar != null) {
                caviarRepository.delete(caviar);
            }
        }
    }

    @Test
    public void editCaviarOk() throws Exception {
        CaviarDTO caviarDTO = caviarTestService.createCaviarDTO();
        Caviar caviar = null;
        try {
            caviar = caviarTestService.createCaviar();
            String response = mockMvc.perform(put("/api/caviar/" + caviar.getId())
                            .content(objectMapper.writeValueAsString(caviarDTO))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

            Long caviarId = objectMapper.readTree(response).longValue();
            Caviar caviarFromResponse = caviarRepository.findById(caviarId).orElse(null);

            Assertions.assertNotNull(caviarFromResponse);
            Assertions.assertEquals(caviarDTO.getWeight(), caviarFromResponse.getWeight());
            Assertions.assertEquals(caviarDTO.getWeight(), caviarFromResponse.getWeight());
            Assertions.assertNotEquals(caviar.getWeight(), caviarFromResponse.getWeight());
            Assertions.assertNotEquals(caviar.getFish(), caviarFromResponse.getFish());
        } finally {
            if (caviar != null) {
                caviarRepository.delete(caviar);
            }
        }
    }

    @Test
    public void deleteCaviarOk() throws Exception {
        Caviar caviar = null;
        try {
            caviar = caviarTestService.createCaviar();
            mockMvc.perform(delete("/api/caviar/" + caviar.getId())
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

            Caviar updateCaviar = caviarRepository.findById(caviar.getId()).orElse(null);

            Assertions.assertNotNull(updateCaviar);
            Assertions.assertTrue(updateCaviar.isDeleted());
        } finally {
            if (caviar != null) {
                caviarRepository.delete(caviar);
            }
        }
    }
}