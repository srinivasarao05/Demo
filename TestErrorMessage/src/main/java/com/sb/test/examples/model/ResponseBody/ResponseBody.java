package com.sb.test.examples.model.ResponseBody;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResponseBody {

	private HttpStatus errorCode;

	private String errorMessage;

	private List<Object> User;

}
