package com.spring.crud.controller;

import com.spring.crud.dto.OctopusDTO;
import org.springframework.http.ResponseEntity;

/**
 * Контроллер для взаимодействия с сущностью "Осьминог".
 * 1. Указать данный класс bean-ом по типу REST-Controller для Spring.
 * 2. Сделать в данный класс DI классов OctopusService и OctopusRepository, для дальнейшей работы с ними.
 * 3. Реализовать методы по требованиям ниже.
 */
public class OctopusController {

    /**
     * Метод для поиска "Осьминога" по ID.
     * Метод должен быть доступен по URL: /api/octopus/{octopusId} - GET method.
     * ID "Осьминога" передается в url - {octopusId}.
     * Алгоритм работы метода:
     * 1. Если "Осьминог" по указанному ID не найдена, нужно вернуть клиенту код HTTP 404 Not Found.
     * 2. Если "Осьминог" по указанному ID была найдена, нужно вернуть DTO икры вместе с кодом HTTP 200 Ok.
     *
     * @param octopusId - ID "Осьминога".
     * @return - ResponseEntity<OctopusDTO> при удачном выполнении алгоритма №2.
     */
    public ResponseEntity<OctopusDTO> findOctopus(Long octopusId) {
        return null;
    }

    /**
     * Метод для создания "Осьминога".
     * Метод должен быть доступен по URL: /api/octopus - POST method.
     * DTO "Осьминога" передается в BODY HTTP-запроса запроса.
     * Алгоритм работы метода:
     * 1. На вход получаем DTO "Осьминога" - его необходимо принять с тела запроса.
     * 2. Необходимо сразу же отвалидировать поля DTO(см. условия валидации в требованиях реализации OctopusDTO).
     * 2.1 Если DTO не прошло валидацию, то необходимо вернуть клиенту код HTTP 422 UnProcessable Entity.
     * 3. При успешной валидации необходимо передать параметры в метод соответствующего Service-класса.
     * 4. Клиенту необходимо вернуть ID созданной "Осьминога" вместе с кодом HTTP 201 Created.
     *
     * @param octopusDTO - DTO исходя из которой мы создадим новый объект "Осьминога".
     * @return - ResponseEntity<Long> при удачном выполнении алгоритма №3.
     */
    public ResponseEntity<Long> createOctopus(OctopusDTO octopusDTO) {
        return null;
    }

    /**
     * Метод для изменения "Осьминога".
     * Метод должен быть доступен по URL: /api/octopus/{octopusId} - PUT method.
     * ID "Осьминога" передается в url - {octopusId}.
     * DTO "Осьминога" передается в BODY HTTP-запроса запроса.
     * Алгоритм работы метода:
     * 1. На вход получаем ID и DTO "Осьминога":
     * 1.1. ID получаем в URL.
     * 1.2. DTO получаем в BODY HTTP-запроса.
     * 2. Необходимо сразу же отвалидировать поля DTO(см. условия валидации в требованиях реализации OctopusDTO).
     * 2.1 Если DTO не прошло валидацию, то необходимо вернуть клиенту код HTTP 422 UnProcessable Entity.
     * 2.2. Проверить, существует ли нужная запись в БД по ID, для дальнейшего редактирования.
     * 2.2.1. Если записи нет -> прокидываем клиенту код HTTP 404 Not Found.
     * 3. При успешной валидации необходимо передать параметры в метод соответствующего Service-класса.
     * 4. Клиенту необходимо вернуть ID измененной "Осьминога" вместе с кодом HTTP 200 Ok.
     *
     * @param octopusId  - ID "Осьминога", которую необходимо изменить.
     * @param octopusDTO - DTO "Осьминога", исходя из которой нужно изменить данные.
     * @return - ResponseEntity<Long> при удачном выполнении алгоритма №3.
     */
    public ResponseEntity<Long> editOctopus(Long octopusId, OctopusDTO octopusDTO) {
        return null;
    }

    /**
     * Метод для удаления "Осьминога".
     * Метод должен быть доступен по URL: /api/octopus/{octopusId} - DELETE method.
     * ID "Осьминога" передается в url - {octopusId}.
     * Алгоритм работы метода:
     * 1. ID получаем в URL.
     * 2. Если в БД не существует записи по указанному ID для удаления
     * ИЛИ
     * запись имеется, но сущность уже помечена как "удалено" -> прокидываем клиенту код HTTP 404 Not Found.
     * 3. Если запись найдена и актуальна в БД -> передаем соответствующий параметр в метод Service-класса.
     *
     * @param octopusId - ID "Осьминога", которую необходимо удалить.
     * @return - ResponseEntity<Void> с ответом 200 HTTP Ok.
     */
    public ResponseEntity<Void> deleteOctopus(Long octopusId) {
        return null;
    }
}