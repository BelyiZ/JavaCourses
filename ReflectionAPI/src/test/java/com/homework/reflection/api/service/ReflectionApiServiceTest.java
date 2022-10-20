package com.homework.reflection.api.service;

import com.homework.reflection.api.dto.UserTableMetadata;
import com.homework.reflection.api.util.TestDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ReflectionApiMetadataService.class})
@EnableConfigurationProperties
public class ReflectionApiServiceTest {

    @Autowired
    private ReflectionApiMetadataService reflectionApiMetadataService;

    @Test
    public void testGetUserTableMetadata() throws Exception {
        UserTableMetadata rightMetadata = TestDataGenerator.getTestUserTableMetadata();
        UserTableMetadata resultMetadata = reflectionApiMetadataService.getUserTableMetadata();
        Assertions.assertEquals(rightMetadata.getTableName(), resultMetadata.getTableName());
        Assertions.assertEquals(rightMetadata.getFieldWithType(), resultMetadata.getFieldWithType());

    }
}
