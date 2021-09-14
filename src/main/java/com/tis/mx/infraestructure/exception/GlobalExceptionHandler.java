/* 
* This program is free software: you can redistribute it and/or modify  
* it under the terms of the GNU General Public License as published by  
* the Free Software Foundation, version 3.
*
* This program is distributed in the hope that it will be useful, but 
* WITHOUT ANY WARRANTY; without even the implied warranty of 
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
* General Public License for more details.
*
* Nombre de archivo: GlobalExceptionHandler.java
* Autor: liandrad
* Fecha de creación: 10 sep. 2021
*/
package com.tis.mx.infraestructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.tis.mx.application.controller.CalculatorInputException;

/**
 * The Class GlobalExceptionHandler.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Bad request.
   *
   * @param calculatorInputException the calculator input exception
   * @return the response entity
   */
  @ExceptionHandler({CalculatorInputException.class})
  public ResponseEntity<ErrorResponse> badRequest(
      CalculatorInputException calculatorInputException) {
    return new ResponseEntity<>(new ErrorResponse(1001, calculatorInputException.getMessage(),
        "input validation", "reenvie la petición con valores de inversión correctos"),
        HttpStatus.BAD_REQUEST);
  }
  
  /**
   * Internal server exception.
   *
   * @param serverException the server exception
   * @return the response entity
   */
  @ExceptionHandler({Exception.class})
  public ResponseEntity<ErrorResponse> internalServerException(
      Exception serverException) {
    return new ResponseEntity<>(new ErrorResponse(9999, serverException.getMessage(),
        "error interno", null),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
