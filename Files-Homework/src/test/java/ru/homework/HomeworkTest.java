package ru.homework;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.homework.service.PhoneNumberService;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration
@AutoConfigureMockMvc
public class HomeworkTest {

    @Test
    public void testHomeworkRealisation() throws IOException, Exception {

        List<String> actualPhoneNumbers = PhoneNumberService.findAllActualPhoneNumbers();
        Assert.assertNotNull(actualPhoneNumbers);
        Assert.assertFalse(actualPhoneNumbers.contains("Маша Иванова"));
        Assert.assertFalse(actualPhoneNumbers.contains("Телефон номер7-812-1234562"));
        Assert.assertFalse(actualPhoneNumbers.contains("(812) 1234563"));
        Assert.assertFalse(actualPhoneNumbers.contains("8234512164"));
        Assert.assertFalse(actualPhoneNumbers.contains("Номер 123 неверный"));
        Assert.assertFalse(actualPhoneNumbers.contains("+7 812 1234500"));
        Assert.assertFalse(actualPhoneNumbers.contains("8345556"));
        Assert.assertFalse(actualPhoneNumbers.contains("123-45-60"));
        Assert.assertFalse(actualPhoneNumbers.contains("+7 (495) 1234544"));
        Assert.assertFalse(actualPhoneNumbers.contains("1234555"));

        Assert.assertTrue(actualPhoneNumbers.contains("+7 (812) 123-4500"));
        Assert.assertTrue(actualPhoneNumbers.contains("+7 (495) 123-4567"));
        Assert.assertTrue(actualPhoneNumbers.contains("+7 (812) 123-4556"));
        Assert.assertTrue(actualPhoneNumbers.contains("+7 (812) 123-4563"));
        Assert.assertTrue(actualPhoneNumbers.contains("+7 (812) 123-4561"));
        Assert.assertTrue(actualPhoneNumbers.contains("+7 (812) 123-4567"));
        Assert.assertTrue(actualPhoneNumbers.contains("+7 (812) 834-5556"));

        Assert.assertEquals(actualPhoneNumbers.size(), 24);
        Assert.assertEquals(actualPhoneNumbers.get(0), "+7 (095) 123-4569");
        Assert.assertEquals(actualPhoneNumbers.get(23), "+7 (821) 123-4500");
    }
}