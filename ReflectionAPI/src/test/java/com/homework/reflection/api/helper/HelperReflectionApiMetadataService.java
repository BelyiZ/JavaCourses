package com.homework.reflection.api.helper;

import com.homework.reflection.api.dto.UserTableMetadata;
import com.homework.reflection.api.model.User;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;

@Service
public class HelperReflectionApiMetadataService {

    public UserTableMetadata getUserTableMetadata (){

        String tableName = camelCaseToSnakeCase(User.class.getSimpleName());

        Map<String, String> fieldWithType = new HashMap<>();
        for (Field field : User.class.getDeclaredFields()){
            fieldWithType.put(camelCaseToSnakeCase(field.getName()), field.getType().getSimpleName());
        }

        return new UserTableMetadata(tableName, fieldWithType);


    }

    public String camelCaseToSnakeCase (String camelCaseString){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < camelCaseString.length(); i++) {

            char ch = camelCaseString.charAt(i);
            if (Character.isUpperCase(ch)) {
                if (result.length()>0) {
                    result.append('_');
                }
                result.append(Character.toLowerCase(ch));
            }
            else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
