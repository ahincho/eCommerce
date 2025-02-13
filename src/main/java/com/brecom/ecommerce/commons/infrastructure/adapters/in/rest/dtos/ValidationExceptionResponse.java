package com.brecom.ecommerce.commons.infrastructure.adapters.in.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationExceptionResponse {
    private String path;
    private String method;
    private Integer statusCode;
    private String statusDescription;
    private List<String> messages;
}
