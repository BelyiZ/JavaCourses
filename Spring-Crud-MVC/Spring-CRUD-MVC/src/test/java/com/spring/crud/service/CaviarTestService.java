package com.spring.crud.service;

import com.spring.crud.dto.CaviarDTO;
import com.spring.crud.model.caviar.Caviar;
import com.spring.crud.model.caviar.CaviarColor;
import com.spring.crud.model.caviar.Fish;
import com.spring.crud.repository.CaviarRepository;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class CaviarTestService {

    private final CaviarRepository caviarRepository;

    public CaviarTestService(CaviarRepository caviarRepository) {
        this.caviarRepository = caviarRepository;
    }

    public Caviar createCaviar() {
        Caviar caviar = new Caviar();
        caviar.setProductName("Дары Копатыча");
        caviar.setWeight(500.0);
        caviar.setCaviarColor(CaviarColor.RED);
        caviar.setArtificial(false);
        caviar.setFish(Fish.CARP);

        return caviarRepository.save(caviar);
    }

    public CaviarDTO createCaviarDTO() {
        CaviarDTO caviarDTO = new CaviarDTO();
        caviarDTO.setProductName("Дары Копатыча 2.0");
        caviarDTO.setCaviarColor(CaviarColor.BLACK);
        caviarDTO.setFish(Fish.SALMON);
        caviarDTO.setWeight(320.0);
        caviarDTO.setArtificial(true);
        return caviarDTO;
    }

    public CaviarDTO createCaviarDTOBadValidation() {
        CaviarDTO caviarDTO = new CaviarDTO();
        caviarDTO.setProductName("");
        caviarDTO.setCaviarColor(null);
        caviarDTO.setFish(null);
        caviarDTO.setWeight(1.0);
        caviarDTO.setArtificial(true);
        return caviarDTO;
    }

    public CaviarDTO createCaviarDTOInvalidValues() {
        CaviarDTO caviarDTO = new CaviarDTO();
        caviarDTO.setProductName("Дары Великого Копатыча Прямо из села Ивановка Специально для Тебя!!!");
        caviarDTO.setCaviarColor(CaviarColor.BLACK);
        caviarDTO.setFish(null);
        caviarDTO.setWeight(5.0);
        caviarDTO.setArtificial(null);
        return caviarDTO;
    }
}