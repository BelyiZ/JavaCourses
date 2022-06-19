package com.spring.crud.service;

import com.spring.crud.dto.OctopusDTO;
import com.spring.crud.model.octopus.Octopus;
import com.spring.crud.repository.OctopusRepository;
import org.springframework.stereotype.Service;

@Service
public class OctopusTestService {

    private final OctopusRepository octopusRepository;

    public OctopusTestService(OctopusRepository octopusRepository) {
        this.octopusRepository = octopusRepository;
    }

    public Octopus createOctopus() {
        Octopus octopus = new Octopus();
        octopus.setProductName("Дары Копатыча");
        octopus.setWeight(500.0);
        octopus.setPeeled(false);

        return octopusRepository.save(octopus);
    }

    public OctopusDTO createOctopusDTO() {
        OctopusDTO octopusDTO = new OctopusDTO();
        octopusDTO.setProductName("Дары Копатыча 2.0");
        octopusDTO.setWeight(320.0);
        octopusDTO.setPeeled(true);
        return octopusDTO;
    }

    public OctopusDTO createOctopusDTOBadValidation() {
        OctopusDTO octopusDTO = new OctopusDTO();
        octopusDTO.setProductName("");
        octopusDTO.setPeeled(false);
        octopusDTO.setWeight(1.0);
        return octopusDTO;
    }

    public OctopusDTO createOctopusDTOInvalidValues() {
        OctopusDTO octopusDTO = new OctopusDTO();
        octopusDTO.setProductName("Дары Великого Копатыча Прямо из села Ивановка Специально для Тебя!!!");
        octopusDTO.setWeight(2.0);
        octopusDTO.setPeeled(true);
        return octopusDTO;
    }
}