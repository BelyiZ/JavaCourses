package com.spring.crud.service;

import com.spring.crud.dto.CrayfishDTO;
import com.spring.crud.model.crayfish.Crayfish;
import com.spring.crud.model.crayfish.CrayfishType;
import com.spring.crud.repository.CrayfishRepository;
import org.springframework.stereotype.Service;

@Service
public class CrayfishTestService {

    private final CrayfishRepository crayfishRepository;

    public CrayfishTestService(CrayfishRepository crayfishRepository) {
        this.crayfishRepository = crayfishRepository;
    }

    public Crayfish createCrayfish() {
        Crayfish crayfish = new Crayfish();
        crayfish.setProductName("Дары Копатыча");
        crayfish.setWeight(500.0);
        crayfish.setCrayfishType(CrayfishType.FLORIDA);

        return crayfishRepository.save(crayfish);
    }

    public CrayfishDTO createCrayfishDTO() {
        CrayfishDTO crayfishDTO = new CrayfishDTO();
        crayfishDTO.setProductName("Дары Копатыча 2.0");
        crayfishDTO.setCrayfishType(CrayfishType.BLUE);
        crayfishDTO.setWeight(320.0);
        return crayfishDTO;
    }

    public CrayfishDTO createCrayfishDTOBadValidation() {
        CrayfishDTO crayfishDTO = new CrayfishDTO();
        crayfishDTO.setProductName("");
        crayfishDTO.setWeight(1.0);
        crayfishDTO.setCrayfishType(null);
        return crayfishDTO;
    }

    public CrayfishDTO createCrayfishDTOInvalidValues() {
        CrayfishDTO crayfishDTO = new CrayfishDTO();
        crayfishDTO.setProductName("Дары Великого Копатыча Прямо из села Ивановка Специально для Тебя!!!");
        crayfishDTO.setWeight(1.0);
        crayfishDTO.setCrayfishType(null);
        return crayfishDTO;
    }
}