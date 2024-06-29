package com.workintech.spring17challenge.exception;
//2.
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@Data
public class ApiErrorResponse {
    private Integer status;
    private String message;
    private Long timestamp;
}
