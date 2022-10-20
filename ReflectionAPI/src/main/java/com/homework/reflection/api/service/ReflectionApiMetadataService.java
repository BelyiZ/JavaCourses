package com.homework.reflection.api.service;

import com.homework.reflection.api.dto.UserTableMetadata;
import org.springframework.stereotype.Service;

@Service
public class ReflectionApiMetadataService {

    /*
    Задача: получить из класса User в режиме Runtime в обход инкапсуляции название класса,
    а так же названия полей и соответствующий им тип данных.
	Используя полученную информацию, собрать объект userTableMetadata и вернуть его в методе.

	1) Получить название класса, переформатировать его с camelCase на snake_case(User -> user) - он будет выступать в роли tableName.
	2) Получить названия всех полей, переформатировать их с camelCase на snake_case(userName -> user_name).
	3) Получить тип данных раннее полученных полей и составить Map<String, String>, где ключ = название поля, value = тип данных - данная мапа будет выступать в роли fieldWithType.
	4) Инициализированный объект класса UserTableMetadata нужно вернуть в методе getUserTableMetadata класса ReflectionApiMetadataService .

    */
    public UserTableMetadata getUserTableMetadata (){

        return null;
    }

}
