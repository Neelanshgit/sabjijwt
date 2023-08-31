package com.sabji.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import com.sabji.model.Response2;



@ControllerAdvice
public class ExceptionController{

	
	
	
	@ExceptionHandler(value = IOException.class)

	public ResponseEntity<Object>  handleGlobalException(Exception e,WebRequest request) {


		 return Response2.generateResponse("wrong request",HttpStatus.INTERNAL_SERVER_ERROR, "006");

	}

	@ExceptionHandler(MultipartException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {

		 return Response2.generateResponse("missing parameter",HttpStatus.INTERNAL_SERVER_ERROR, "007");

    }
	
	@ExceptionHandler(MissingServletRequestPartException.class)
    @ResponseBody
    ResponseEntity<?> handleMissingServletRequestPartException(HttpServletRequest request, Throwable ex) {

		 return Response2.generateResponse("Should select atleast file for submit",HttpStatus.INTERNAL_SERVER_ERROR, "009");

    }
	
	@ExceptionHandler(UnauthorisedException.class)
    @ResponseBody
    ResponseEntity<?> handleUnauthorisedException(HttpServletRequest request, Throwable ex) {

		 return Response2.generateResponse("Request is un authorised",HttpStatus.BAD_REQUEST, "013");

    }
	@ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    ResponseEntity<?> handleIllegalArgumentException(HttpServletRequest request, Throwable ex) {

		 return Response2.generateResponse("Illegal arugement",HttpStatus.BAD_REQUEST, "014");

    }
	
	
	@ExceptionHandler(UsernameNotFoundException.class)
    @ResponseBody
    ResponseEntity<?> handleUsernameNotFoundException(HttpServletRequest request, Throwable ex) {

		 return Response2.generateResponse("INVALID_CREDENTIALS ",HttpStatus.UNAUTHORIZED, "000");

    }
	
	@ExceptionHandler(RequestRejectedException.class)
    @ResponseBody
    ResponseEntity<?> handleRequestRejectedException(HttpServletRequest request, Throwable ex) {

		 return Response2.generateResponse("INVALID_CREDENTIALS ",HttpStatus.UNAUTHORIZED, "000");

    }
}
