package com.projectthales.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class UtilBusiness {
    private UtilBusiness() {
        throw new IllegalStateException(UtilBusiness.class.toString());
    }

    public static Double getAnnualSalaryEmployee(Double salary) {
        if (Objects.nonNull(salary))
            return salary * 12;
        return 0.0;
    }
}
