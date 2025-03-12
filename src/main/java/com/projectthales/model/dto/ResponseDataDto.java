package com.projectthales.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ResponseDataDto {
    private String status;
    private DataDto data;
    private String message;
}
