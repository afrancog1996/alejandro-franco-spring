package com.examen.alejandro.franco.utils;

import java.util.Date;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@ResponseBody
public class CustomizedResponseEntityExceptionHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorDetails handleValidateException(MethodArgumentNotValidException ex) {
		ErrorDetails error = new ErrorDetails();
		error.setTimestamp(new Date());
		error.setMessage("No es posible procesar su solicitud con los datos proporcionados.");
		error.setDetails(ex.getMessage().toString());
		return error;
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(InternalServerError.class)
	public ErrorDetails handleValidateException(InternalServerError ex) {
		ErrorDetails error = new ErrorDetails();
		error.setTimestamp(new Date());
		error.setMessage("No es posible procesar su solicitud con los datos proporcionados.");
		error.setDetails(ex.getMessage().toString());
		return error;
	}

}
