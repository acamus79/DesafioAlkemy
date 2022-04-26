package com.acamus.disney.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Data
@AllArgsConstructor
public class ApiErrorDTO {

    private HttpStatus status;

    private String message;

    private List<String> errors;
}
