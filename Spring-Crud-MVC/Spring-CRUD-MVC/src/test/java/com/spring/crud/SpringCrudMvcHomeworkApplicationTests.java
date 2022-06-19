package com.spring.crud;

import com.spring.crud.controller.NOT_FOUND.CaviarControllerNotFoundTest;
import com.spring.crud.controller.NOT_FOUND.CrayfishControllerNotFoundTest;
import com.spring.crud.controller.NOT_FOUND.OctopusControllerNotFoundOkTest;
import com.spring.crud.controller.OK.CaviarControllerOkTest;
import com.spring.crud.controller.OK.CrayfishControllerOkTest;
import com.spring.crud.controller.OK.OctopusControllerOkTest;
import com.spring.crud.controller.VALIDATION.CaviarControllerValidationTest;
import com.spring.crud.controller.VALIDATION.CrayfishControllerValidationTest;
import com.spring.crud.controller.VALIDATION.OctopusControllerValidationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CaviarControllerOkTest.class,
        OctopusControllerOkTest.class,
        CrayfishControllerOkTest.class,
        CaviarControllerNotFoundTest.class,
        CrayfishControllerNotFoundTest.class,
        OctopusControllerNotFoundOkTest.class,
        CaviarControllerValidationTest.class,
        OctopusControllerValidationTest.class,
        CrayfishControllerValidationTest.class
})
public class SpringCrudMvcHomeworkApplicationTests {
}