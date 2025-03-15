package com.projectthales.service.implementation;

import com.projectthales.model.builder.EmployeeDtoBuilder;
import com.projectthales.model.dto.EmployeeDto;
import com.projectthales.repository.IEmployeeRepository;
import com.projectthales.repository.implementation.EmployeeRepositoryImpl;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
////@ActiveProfiles("test-integration")
//@ExtendWith(MockitoExtension.class)

class EmployeeServiceImplTest {
    @Value("${service.url.externo:https://dummy.restapiexample.com/api/v1/employees}")
    private String url;
    @Mock
    private IEmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    EmployeeDto employeeDto;

    @BeforeEach
    void setUp() {
        employeeDto = EmployeeDtoBuilder.builder().build().toEmployeeEntity();
        url = "https://dummy.restapiexample.com/api/v1/employees";
    }

    @Test
    void whenEmployeeListReturnsData() {
//        EmployeeDto dto = EmployeeDtoBuilder.builder().build().toEditId(2);

//        Mockito.when(environment.getProperty("service.url.externo")).thenReturn("https://dummy.restapiexample.com/api/v1/employees");
//        String url = servicio.getUrlExterno(); // Supongamos que tienes un método getUrlExterno() en tu servicio
//        assertEquals("http://mocked-url.com", url);

        given(employeeRepository.getEmployeeJsonResponse(anyString())).willReturn("anyString()");
        List<EmployeeDto> list = employeeServiceImpl.getEmployeeList();
        assertTrue(list.isEmpty());

//        EmployeeEntity entity = EmployeeBuilder.builder().build().toEditId(2);
//        try (MockedStatic<WebDriverManager> mockedStatic = Mockito.mockStatic(WebDriverManager.class)) {
//            WebDriverManager mockWebDriverManager = Mockito.mock(WebDriverManager.class);
//            Mockito.when(WebDriverManager.chromedriver()).thenReturn(mockWebDriverManager);
//            Mockito.doNothing().when(mockWebDriverManager).setup();
//            WebDriverManager.chromedriver().setup();
//
//            given(employeeRepositoryImpl.getEmployeeJsonResponse(url)).willReturn(anyString());
////        given(WebDriverManager.chromedriver().setup())
//            List<EmployeeDto> list = employeeServiceImpl.getEmployeeList();
//            assertTrue(list.isEmpty());
//        }
    }
}