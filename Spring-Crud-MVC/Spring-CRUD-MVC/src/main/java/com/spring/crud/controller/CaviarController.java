package com.spring.crud.controller;

import com.spring.crud.dto.CaviarDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Контроллер для взаимодействия с сущностью "Икра".
 * 1. Указать данный класс bean-ом по типу REST-Controller для Spring.
 * 2. Сделать в данный класс DI классов CaviarService и CaviarRepository, для дальнейшей работы с ними.
 * 3. Реализовать методы по требованиям ниже.
 */
public class CaviarController {

    /**
     * Метод для поиска "Икры" по ID.
     * Метод должен быть доступен по URL: /api/caviar/{caviarId} - GET method.
     * ID "Икры" передается в url - {caviarId}.
     * Алгоритм работы метода:
     * 1. Если "Икра" по указанному ID не найдена, нужно вернуть клиенту код HTTP 404 Not Found.
     * 2. Если "Икра" по указанному ID была найдена, нужно вернуть DTO икры вместе с кодом HTTP 200 Ok.
     *
     * @param caviarId - ID "Икры".
     * @return - ResponseEntity<CaviarDTO> при удачном выполнении алгоритма №2.
     */
    public ResponseEntity<CaviarDTO> findCaviar(Long caviarId) {
        return null;
    }

    /**
     * Метод для создания "Икры".
     * Метод должен быть доступен по URL: /api/caviar - POST method.
     * DTO "Икры" передается в BODY HTTP-запроса запроса.
     * Алгоритм работы метода:
     * 1. На вход получаем DTO "Икры" - его необходимо принять с тела запроса.
     * 2. Необходимо сразу же отвалидировать поля DTO(см. условия валидации в требованиях реализации CaviarDTO).
     * 2.1 Если DTO не прошло валидацию, то необходимо вернуть клиенту код HTTP 422 UnProcessable Entity.
     * 3. При успешной валидации необходимо передать параметры в метод соответствующего Service-класса.
     * 4. Клиенту необходимо вернуть ID созданной "Икры" вместе с кодом HTTP 201 Created.
     *
     * @param caviarDTO - DTO исходя из которой мы создадим новый объект "Икры".
     * @return - ResponseEntity<Long> при удачном выполнении алгоритма №3.
     */
    public ResponseEntity<Long> createCaviar(@Validated @RequestBody CaviarDTO caviarDTO) {
        return null;
    }

    /**
     * Метод для изменения "Икры".
     * Метод должен быть доступен по URL: /api/caviar/{caviarId} - PUT method.
     * ID "Икры" передается в url - {caviarId}.
     * DTO "Икры" передается в BODY HTTP-запроса запроса.
     * Алгоритм работы метода:
     * 1. На вход получаем ID и DTO "Икры":
     * 1.1. ID получаем в URL.
     * 1.2. DTO получаем в BODY HTTP-запроса.
     * 2. Необходимо сразу же отвалидировать поля DTO(см. условия валидации в требованиях реализации CaviarDTO).
     * 2.1 Если DTO не прошло валидацию, то необходимо вернуть клиенту код HTTP 422 UnProcessable Entity.
     * 2.2. Проверить, существует ли нужная запись в БД по ID, для дальнейшего редактирования.
     * 2.2.1. Если записи нет -> прокидываем клиенту код HTTP 404 Not Found.
     * 3. При успешной валидации необходимо передать параметры в метод соответствующего Service-класса.
     * 4. Клиенту необходимо вернуть ID измененной "Икры" вместе с кодом HTTP 200 Ok.
     *
     * @param caviarId  - ID "Икры", которую необходимо изменить.
     * @param caviarDTO - DTO "Икры", исходя из которой нужно изменить данные.
     * @return - ResponseEntity<Long> при удачном выполнении алгоритма №3.
     */
    public ResponseEntity<Long> editCaviar(Long caviarId, CaviarDTO caviarDTO) {
        return null;
    }

    /**
     * Метод для удаления "Икры".
     * Метод должен быть доступен по URL: /api/caviar/{caviarId} - DELETE method.
     * ID "Икры" передается в url - {caviarId}.
     * Алгоритм работы метода:
     * 1. ID получаем в URL.
     * 2. Если в БД не существует записи по указанному ID для удаления
     * ИЛИ
     * запись имеется, но сущность уже помечена как "удалено" -> прокидываем клиенту код HTTP 404 Not Found.
     * 3. Если запись найдена и актуальна в БД -> передаем соответствующий параметр в метод Service-класса.
     *
     * @param caviarId - ID "Икры", которую необходимо удалить.
     * @return - ResponseEntity<Void> с ответом 200 HTTP Ok.
     */
    public ResponseEntity<Void> deleteCaviar(@PathVariable Long caviarId) {
        return null;
    }
}