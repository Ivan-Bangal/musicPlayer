package com.crytek.crysis.exceptions;


import com.crytek.crysis.model.ResponseApi;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
public class Handler {
    private final Logger logger = LoggerFactory.getLogger(Handler.class);
    private final Map<String, String> errors = new HashMap<>();



    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseApi handleValidationExceptions(HttpServletRequest request, MethodArgumentNotValidException ex) {
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseApi("Erro de Validação!",  errors);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ResponseApi handleBadRequest(HttpServletRequest request, BadRequestException ex) {
        return new ResponseApi(ex.getMessage(),  null);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ConflictException.class)
    public ResponseApi handleConflict(HttpServletRequest request, ConflictException ex) {
        return new ResponseApi(ex.getMessage(),  null);
    }


    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ForbiddenException.class)
    public ResponseApi handleForbidden(HttpServletRequest request, ForbiddenException ex) {
        return new ResponseApi(ex.getMessage(),  null);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseApi handleInternalServerError(HttpServletRequest request, InternalServerErrorException ex) {
        return new ResponseApi(ex.getMessage(),  null);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseApi handleNotFound(HttpServletRequest request, NotFoundException ex) {
        return new ResponseApi(ex.getMessage(),  null);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseApi handleUnauthorized(HttpServletRequest request, UnauthorizedException ex) {
        return new ResponseApi(ex.getMessage(),  null);
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseApi handleUE(HttpServletRequest request, UnprocessableEntityException ex) {
        return new ResponseApi(ex.getMessage(),  null);
    }




}
