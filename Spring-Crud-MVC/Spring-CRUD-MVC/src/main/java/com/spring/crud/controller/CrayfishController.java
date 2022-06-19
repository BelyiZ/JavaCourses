package com.spring.crud.controller;

import com.spring.crud.dto.CrayfishDTO;
import org.springframework.http.ResponseEntity;

/**
 * Контроллер для взаимодействия с сущностью "Рак".
 * 1. Указать данный класс bean-ом по типу REST-Controller для Spring.
 * 2. Сделать в данный класс DI классов CrayfishService и CrayfishRepository, для дальнейшей работы с ними.
 * 3. Реализовать методы по требованиям ниже.
 */
public class CrayfishController {

    /**
     * Метод для поиска "Рака" по ID.
     * Метод должен быть доступен по URL: /api/crayfish/{crayfishId} - GET method.
     * ID "Рака" передается в url - {crayfishId}.
     * Алгоритм работы метода:
     * 1. Если "Рак" по указанному ID не найдена, нужно вернуть клиенту код HTTP 404 Not Found.
     * 2. Если "Рак" по указанному ID была найдена, нужно вернуть DTO икры вместе с кодом HTTP 200 Ok.
     *
     * @param crayfishId - ID "Рака".
     * @return - ResponseEntity<CrayfishDTO> при удачном выполнении алгоритма №2.
     */
    public ResponseEntity<CrayfishDTO> findCrayfish(Long crayfishId) {
        return null;
    }

    /**
     * Метод для создания "Рака".
     * Метод должен быть доступен по URL: /api/crayfish - POST method.
     * DTO "Рака" передается в BODY HTTP-запроса запроса.
     * Алгоритм работы метода:
     * 1. На вход получаем DTO "Рака" - его необходимо принять с тела запроса.
     * 2. Необходимо сразу же отвалидировать поля DTO(см. условия валидации в требованиях реализации CrayfishDTO).
     * 2.1 Если DTO не прошло валидацию, то необходимо вернуть клиенту код HTTP 422 UnProcessable Entity.
     * 3. При успешной валидации необходимо передать параметры в метод соответствующего Service-класса.
     * 4. Клиенту необходимо вернуть ID созданной "Рака" вместе с кодом HTTP 201 Created.
     *
     * @param crayfishDTO - DTO исходя из которой мы создадим новый объект "Рака".
     * @return - ResponseEntity<Long> при удачном выполнении алгоритма №3.
     */
    public ResponseEntity<Long> createCrayfish(CrayfishDTO crayfishDTO) {
        return null;
    }

    /**
     * Метод для изменения "Рака".
     * Метод должен быть доступен по URL: /api/crayfish/{crayfishId} - PUT method.
     * ID "Рака" передается в url - {crayfishId}.
     * DTO "Рака" передается в BODY HTTP-запроса запроса.
     * Алгоритм работы метода:
     * 1. На вход получаем ID и DTO "Рака":
     * 1.1. ID получаем в URL.
     * 1.2. DTO получаем в BODY HTTP-запроса.
     * 2. Необходимо сразу же отвалидировать поля DTO(см. условия валидации в требованиях реализации CrayfishDTO).
     * 2.1 Если DTO не прошло валидацию, то необходимо вернуть клиенту код HTTP 422 UnProcessable Entity.
     * 2.2. Проверить, существует ли нужная запись в БД по ID, для дальнейшего редактирования.
     * 2.2.1. Если записи нет -> прокидываем клиенту код HTTP 404 Not Found.
     * 3. При успешной валидации необходимо передать параметры в метод соответствующего Service-класса.
     * 4. Клиенту необходимо вернуть ID измененной "Рака" вместе с кодом HTTP 200 Ok.
     *
     * @param crayfishId  - ID "Рака", которую необходимо изменить.
     * @param crayfishDTO - DTO "Рака", исходя из которой нужно изменить данные.
     * @return - ResponseEntity<Long> при удачном выполнении алгоритма №3.
     */

    public ResponseEntity<Long> editCrayfish(Long crayfishId, CrayfishDTO crayfishDTO) {
        return null;
    }

    /**
     * Метод для удаления "Рака".
     * Метод должен быть доступен по URL: /api/crayfish/{crayfishId} - DELETE method.
     * ID "Рака" передается в url - {crayfishId}.
     * Алгоритм работы метода:
     * 1. ID получаем в URL.
     * 2. Если в БД не существует записи по указанному ID для удаления
     * ИЛИ
     * запись имеется, но сущность уже помечена как "удалено" -> прокидываем клиенту код HTTP 404 Not Found.
     * 3. Если запись найдена и актуальна в БД -> передаем соответствующий параметр в метод Service-класса.
     *
     * @param crayfishId - ID "Рака", которую необходимо удалить.
     * @return - ResponseEntity<Void> с ответом 200 HTTP Ok.
     */
    public ResponseEntity<Void> deleteCrayfish(Long crayfishId) {
        return null;
    }
}
