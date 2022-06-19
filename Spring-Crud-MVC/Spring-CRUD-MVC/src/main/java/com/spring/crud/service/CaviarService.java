package com.spring.crud.service;

import com.spring.crud.dto.CaviarDTO;

/**
 * Пометить класс как сервисный bean для Spring.
 * Сделать DI класса CaviarRepository в данный класс(CaviarService).
 * Реализовать методы, описанные ниже.
 */
public class CaviarService {

    /**
     * Метод получает на вход DTO сущности ИКРА.
     * Исходя из данных в DTO необходимо создать и сохранить в БД новую запись икры.
     * Вернуть необходимо ID сохраненной в БД новой записи икры.
     *
     * @param caviarDTO - DTO сущности ИКРА.
     * @return - ID сохраненной в БД новой записи икры.
     */
    public Long createCaviar(CaviarDTO caviarDTO) {
        return null;
    }

    /**
     * Метод получает на вход ID икры.
     * Необходимо найти запись икры по ID и пометить его как удаленный(неактуальный).
     * Возвращать ничего не нужно. Тип метода void.
     *
     * @param id - ID икры.
     */
    public void deleteCaviar(Long id) {
    }

    /**
     * Метод получает на вход ID икры.
     * Необходимо вернуть клиенту DTO икры исходя из найденной записи в БД.
     *
     * @param id - ID икры.
     * @return - DTO икры.
     */
    public CaviarDTO findCaviar(Long id) {
        return null;
    }

    /**
     * Метод получает на вход два параметра:
     * 1. ID икры, которая будет редактироваться.
     * 2. DTO икры, исходя из данных которого нужно редактировать уже существующую запись в БД.
     * Важно: если те или иные поля в DTO пришли со значением null,
     * то редактировать аналогичные поля в сущности не нужно!
     * Вернуть нужно ID отредактированной икры.
     *
     * @param caviarId  - ID икры, которая будет редактироваться.
     * @param caviarDTO - DTO икры, исходя из данных которого нужно редактировать уже существующую запись в БД.
     * @return - ID отредактированной икры.
     */
    public Long editCaviar(Long caviarId, CaviarDTO caviarDTO) {
        return null;
    }
}