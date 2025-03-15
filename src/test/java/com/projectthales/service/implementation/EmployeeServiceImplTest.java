package com.projectthales.service.implementation;

import com.projectthales.exception.ExternalServiceError;
import com.projectthales.exception.NotFoundException;
import com.projectthales.model.builder.EmployeeDtoBuilder;
import com.projectthales.model.dto.EmployeeDto;
import com.projectthales.repository.IEmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@SpringBootTest
class EmployeeServiceImplTest {
    private String url;
    private String jsonResponseError;
    private String jsonResponseList;
    private String jsonResponseOne;
    private String jsonResponseOneNull;
    private String jsonResponseListNull;
    @Mock
    private IEmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    EmployeeDto employeeDto;

    @BeforeEach
    void setUp() {
        employeeDto = EmployeeDtoBuilder.builder().build().toEmployeeEntity();
        url = "https://dummy.restapiexample.com/api/v1/employees";
        jsonResponseError = "{\"status\":\"error\",\"data\":null,\"message\":\"An error occurred! Please try again later.\"}";
        jsonResponseList = "{\"status\":\"success\",\"data\":[{\"id\":1,\"employee_name\":\"Tiger Nixon\",\"employee_salary\":320800,\"employee_age\":61,\"profile_image\":\"\"},{\"id\":2,\"employee_name\":\"Garrett Winters\",\"employee_salary\":170750,\"employee_age\":63,\"profile_image\":\"\"},{\"id\":3,\"employee_name\":\"Ashton Cox\",\"employee_salary\":86000,\"employee_age\":66,\"profile_image\":\"\"},{\"id\":4,\"employee_name\":\"Cedric Kelly\",\"employee_salary\":433060,\"employee_age\":22,\"profile_image\":\"\"},{\"id\":5,\"employee_name\":\"Airi Satou\",\"employee_salary\":162700,\"employee_age\":33,\"profile_image\":\"\"},{\"id\":6,\"employee_name\":\"Brielle Williamson\",\"employee_salary\":372000,\"employee_age\":61,\"profile_image\":\"\"},{\"id\":7,\"employee_name\":\"Herrod Chandler\",\"employee_salary\":137500,\"employee_age\":59,\"profile_image\":\"\"},{\"id\":8,\"employee_name\":\"Rhona Davidson\",\"employee_salary\":327900,\"employee_age\":55,\"profile_image\":\"\"},{\"id\":9,\"employee_name\":\"Colleen Hurst\",\"employee_salary\":205500,\"employee_age\":39,\"profile_image\":\"\"},{\"id\":10,\"employee_name\":\"Sonya Frost\",\"employee_salary\":103600,\"employee_age\":23,\"profile_image\":\"\"},{\"id\":11,\"employee_name\":\"Jena Gaines\",\"employee_salary\":90560,\"employee_age\":30,\"profile_image\":\"\"},{\"id\":12,\"employee_name\":\"Quinn Flynn\",\"employee_salary\":342000,\"employee_age\":22,\"profile_image\":\"\"},{\"id\":13,\"employee_name\":\"Charde Marshall\",\"employee_salary\":470600,\"employee_age\":36,\"profile_image\":\"\"},{\"id\":14,\"employee_name\":\"Haley Kennedy\",\"employee_salary\":313500,\"employee_age\":43,\"profile_image\":\"\"},{\"id\":15,\"employee_name\":\"Tatyana Fitzpatrick\",\"employee_salary\":385750,\"employee_age\":19,\"profile_image\":\"\"},{\"id\":16,\"employee_name\":\"Michael Silva\",\"employee_salary\":198500,\"employee_age\":66,\"profile_image\":\"\"},{\"id\":17,\"employee_name\":\"Paul Byrd\",\"employee_salary\":725000,\"employee_age\":64,\"profile_image\":\"\"},{\"id\":18,\"employee_name\":\"Gloria Little\",\"employee_salary\":237500,\"employee_age\":59,\"profile_image\":\"\"},{\"id\":19,\"employee_name\":\"Bradley Greer\",\"employee_salary\":132000,\"employee_age\":41,\"profile_image\":\"\"},{\"id\":20,\"employee_name\":\"Dai Rios\",\"employee_salary\":217500,\"employee_age\":35,\"profile_image\":\"\"},{\"id\":21,\"employee_name\":\"Jenette Caldwell\",\"employee_salary\":345000,\"employee_age\":30,\"profile_image\":\"\"},{\"id\":22,\"employee_name\":\"Yuri Berry\",\"employee_salary\":675000,\"employee_age\":40,\"profile_image\":\"\"},{\"id\":23,\"employee_name\":\"Caesar Vance\",\"employee_salary\":106450,\"employee_age\":21,\"profile_image\":\"\"},{\"id\":24,\"employee_name\":\"Doris Wilder\",\"employee_salary\":85600,\"employee_age\":23,\"profile_image\":\"\"}],\"message\":\"Successfully! All records has been fetched.\"}";
        jsonResponseOne = "{\"status\":\"success\",\"data\":{\"id\":1,\"employee_name\":\"Tiger Nixon\",\"employee_salary\":320800,\"employee_age\":61,\"profile_image\":\"\"},\"message\":\"Successfully! All records has been fetched.\"}";
        jsonResponseOneNull = "{\"status\":\"success\",\"data\":null,\"message\":\"Successfully! All records has been fetched.\"}";
        jsonResponseListNull = "{\"status\":\"success\",\"data\":null,\"message\":\"Successfully! All records has been fetched.\"}";
    }

    @DisplayName("JUnit test for the <<whenEmployeeListReturnsData>> method of employees.")
    @Test
    void whenEmployeeListReturnsData() {
        given(employeeRepository.getEmployeeJsonResponse(url)).willReturn(jsonResponseList);
        List<EmployeeDto> list = employeeServiceImpl.getEmployeeList();
        assertFalse(list.isEmpty());
    }

    @DisplayName("JUnit test for the <<whenEmployeeListNotReturnData>> method of employees.")
    @Test
    void whenEmployeeListNotReturnData() {
        given(employeeRepository.getEmployeeJsonResponse(url)).willReturn(jsonResponseListNull);
        List<EmployeeDto> list = employeeServiceImpl.getEmployeeList();
        assertTrue(list.isEmpty());
    }

    @DisplayName("JUnit test for the <<whenResponseByIdReturnsResults>> method of employees.")
    @Test
    void whenResponseByIdReturnsResults() {
        given(employeeRepository.getEmployeeJsonResponse(anyString())).willReturn(jsonResponseOne);
        EmployeeDto entityEmployee = employeeServiceImpl.getById(1);
        assertNotNull(entityEmployee);

    }

    @DisplayName("JUnit test for the <<whenResponseByIdReturnsNoResults>> method of employees.")
    @Test
    void whenResponseByIdReturnsNoResults() {
        given(employeeRepository.getEmployeeJsonResponse(anyString())).willReturn(jsonResponseOneNull);
        assertThrows(NotFoundException.class, () -> employeeServiceImpl.getById(anyInt()));
        verify(employeeRepository, never()).getEmployeeJsonResponse(jsonResponseOneNull);
    }

    @DisplayName("JUnit test for the <<whenResponseByIdReturnsErrorFromExternalService>> method of employees.")
    @Test
    void whenResponseByIdReturnsErrorFromExternalService() {
        given(employeeRepository.getEmployeeJsonResponse(anyString())).willReturn(jsonResponseError);
        assertThrows(ExternalServiceError.class, () -> employeeServiceImpl.getById(anyInt()));
        verify(employeeRepository, never()).getEmployeeJsonResponse(jsonResponseError);
    }
}