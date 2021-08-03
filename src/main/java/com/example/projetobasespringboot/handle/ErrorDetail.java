package com.example.projetobasespringboot.handle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.bind.validation.ValidationErrors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetail {
	private String title;
    private int status;
    private String detail;
    private long timeStamp;
    private String developerMessage;
    private Map<String, List<ValidationErrors>> errors = new HashMap<>();
}
