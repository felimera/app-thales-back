package com.projectthales.repository.implementation;

import com.projectthales.exception.UnexpectedError;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class EmployeeRepositoryImplTest {
    @InjectMocks
    private EmployeeRepositoryImpl employeeRepository;

    @DisplayName("JUnit test for the <<testMockWebDriverManagerSetup>> method of employees.")
    @Test
    public void testMockWebDriverManagerSetup() {
        try (MockedStatic<WebDriverManager> mockedStatic = Mockito.mockStatic(WebDriverManager.class)) {
            WebDriverManager mockWebDriverManager = Mockito.mock(WebDriverManager.class);
            Mockito.when(WebDriverManager.chromedriver()).thenReturn(mockWebDriverManager);
            Mockito.doNothing().when(mockWebDriverManager).setup();

            WebDriverManager.chromedriver().setup();

            assertNotNull(mockWebDriverManager);
            Mockito.verify(mockWebDriverManager).setup();
        }
    }

    @DisplayName("JUnit test for the <<whenErrorGeneratedByChromeDriver>> method of employees.")
    @Test
    void whenErrorGeneratedByChromeDriver() {
        assertThrows(UnexpectedError.class, () -> employeeRepository.getEmployeeJsonResponse(null));
    }
}