package com.spring.crud.controller.OK;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.crud.dto.OctopusDTO;
import com.spring.crud.model.octopus.Octopus;
import com.spring.crud.repository.OctopusRepository;
import com.spring.crud.service.OctopusTestService;
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

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class OctopusControllerOkTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OctopusTestService octopusTestService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OctopusRepository octopusRepository;

    @Test
    public void getOctopusOk() throws Exception {
        Octopus octopus = null;
        try {
            octopus = octopusTestService.createOctopus();
            String response = mockMvc.perform(get("/api/octopus/" + octopus.getId())
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

            Octopus octopusFromResponse = objectMapper.readValue(response, Octopus.class);

            Assertions.assertEquals(octopusFromResponse.getProductName(), octopus.getProductName());
            Assertions.assertEquals(octopusFromResponse.getWeight(), octopus.getWeight());
            Assertions.assertEquals(octopusFromResponse.isPeeled(), octopus.isPeeled());
        } finally {
            if (octopus != null) octopusRepository.delete(octopus);
        }
    }

    @Test
    public void createOctopusOk() throws Exception {
        OctopusDTO octopusDTO = octopusTestService.createOctopusDTO();
        Octopus octopus = null;
        try {
            String response = mockMvc.perform(post("/api/octopus")
                            .content(objectMapper.writeValueAsString(octopusDTO))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

            Long octopusId = objectMapper.readTree(response).longValue();
            octopus = octopusRepository.findById(octopusId).orElse(null);

            Assertions.assertNotNull(octopus);
            Assertions.assertEquals(octopusDTO.getWeight(), octopus.getWeight());
            Assertions.assertEquals(octopusDTO.isPeeled(), octopus.isPeeled());
        } finally {
            if (octopus != null) {
                octopusRepository.delete(octopus);
            }
        }
    }

    @Test
    public void editOctopusOk() throws Exception {
        OctopusDTO octopusDTO = octopusTestService.createOctopusDTO();
        Octopus octopus = null;
        try {
            octopus = octopusTestService.createOctopus();
            String response = mockMvc.perform(put("/api/octopus/" + octopus.getId())
                            .content(objectMapper.writeValueAsString(octopusDTO))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

            Long octopusId = objectMapper.readTree(response).longValue();
            Octopus octopusFromResponse = octopusRepository.findById(octopusId).orElse(null);

            Assertions.assertNotNull(octopusFromResponse);
            Assertions.assertEquals(octopusDTO.getWeight(), octopusFromResponse.getWeight());
            Assertions.assertNotEquals(octopus.getWeight(), octopusFromResponse.getWeight());
            Assertions.assertNotEquals(octopus.getProductName(), octopusFromResponse.getProductName());
        } finally {
            if (octopus != null) {
                octopusRepository.delete(octopus);
            }
        }
    }

    @Test
    public void deleteOctopusOk() throws Exception {
        Octopus octopus = null;
        try {
            octopus = octopusTestService.createOctopus();
            mockMvc.perform(delete("/api/octopus/" + octopus.getId())
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

            Octopus updateOctopus = octopusRepository.findById(octopus.getId()).orElse(null);

            Assertions.assertNotNull(updateOctopus);
            Assertions.assertTrue(updateOctopus.isDeleted());
        } finally {
            if (octopus != null) {
                octopusRepository.delete(octopus);
            }
        }
    }
}