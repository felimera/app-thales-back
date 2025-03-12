package com.projectthales.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class ResponseListDataDto {
    private String status;
    private List<DataDto> data = new ArrayList<>();
    private String message;
}
