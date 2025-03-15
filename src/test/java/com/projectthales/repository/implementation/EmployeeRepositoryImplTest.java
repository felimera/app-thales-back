package com.projectthales.repository.implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class EmployeeRepositoryImplTest {
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
}