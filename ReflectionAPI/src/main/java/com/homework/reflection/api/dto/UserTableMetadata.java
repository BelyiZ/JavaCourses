package com.homework.reflection.api.dto;

import java.util.Map;

public class UserTableMetadata {

    private String tableName;
    private Map<String, String> fieldWithType;

    public UserTableMetadata() {
    }

    public UserTableMetadata(String tableName, Map<String, String> fieldWithType) {
        this.tableName = tableName;
        this.fieldWithType = fieldWithType;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Map<String, String> getFieldWithType() {
        return fieldWithType;
    }

    public void setFieldWithType(Map<String, String> fieldWithType) {
        this.fieldWithType = fieldWithType;
    }
}
