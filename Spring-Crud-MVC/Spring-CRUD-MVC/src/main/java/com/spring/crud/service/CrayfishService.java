package com.spring.crud.service;

import com.spring.crud.dto.CrayfishDTO;

/**
 * Пометить класс как сервисный bean для Spring.
 * Сделать DI класса CrayfishRepository в данный класс(CrayfishService).
 * Реализовать методы, описанные ниже.
 */
public class CrayfishService {

    /**
     * Метод получает на вход DTO сущности РАК.
     * Исходя из данных в DTO необходимо создать и сохранить в БД новую запись рака.
     * Вернуть необходимо ID сохраненной в БД новой записи рака.
     *
     * @param crayfishDTO - DTO сущности ИКРА.
     * @return - ID сохраненной в БД новой записи рака.
     */
    public Long createCrayfish(CrayfishDTO crayfishDTO) {
        return null;
    }

    /**
     * Метод получает на вход ID рака.
     * Необходимо найти запись рака по ID и пометить его как удаленный(неактуальный).
     * Возвращать ничего не нужно. Тип метода void.
     *
     * @param id - ID рака.
     */
    public void deleteCrayfish(Long id) {

    }

    /**
     * Метод получает на вход ID рака.
     * Необходимо вернуть клиенту DTO рака исходя из найденной записи в БД.
     *
     * @param id - ID рака.
     * @return - DTO рака.
     */
    public CrayfishDTO findCrayfish(Long id) {
        return null;
    }

    /**
     * Метод получает на вход два параметра:
     * 1. ID рака, который будет редактироваться.
     * 2. DTO рака, исходя из данных которого нужно редактировать уже существующую запись в БД.
     * Важно: если те или иные поля в DTO пришли со значением null,
     * то редактировать аналогичные поля в сущности не нужно!
     * Вернуть нужно ID отредактированного рака.
     *
     * @param crayfishId  - ID рака, которая будет редактироваться.
     * @param crayfishDTO - DTO рака, исходя из данных которого нужно редактировать уже существующую запись в БД.
     * @return - ID отредактированной икры.
     */
    public Long editCrayfish(Long crayfishId, CrayfishDTO crayfishDTO) {
        return null;
    }
}