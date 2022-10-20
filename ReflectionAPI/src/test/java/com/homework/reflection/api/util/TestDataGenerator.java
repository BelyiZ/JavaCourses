package com.homework.reflection.api.util;

import com.homework.reflection.api.dto.UserTableMetadata;

import java.util.HashMap;
import java.util.Map;

public class TestDataGenerator {

    private TestDataGenerator() {
    }

    public static UserTableMetadata getTestUserTableMetadata(){
        UserTableMetadata result = new UserTableMetadata();

        result.setTableName("user");

        Map<String, String> fieldWithType = new HashMap<>();
        fieldWithType.put("id", "Long");
        fieldWithType.put("name", "String");
        fieldWithType.put("email", "String");
        fieldWithType.put("phone_number", "String");
        fieldWithType.put("password", "String");
        fieldWithType.put("birth_date", "LocalDate");
        fieldWithType.put("test_field_with_many_many_words", "String");

        result.setFieldWithType(fieldWithType);

        return result;
    }
}
