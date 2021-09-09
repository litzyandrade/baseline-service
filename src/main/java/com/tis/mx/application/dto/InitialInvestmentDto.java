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
* Nombre de archivo: InitialInvestmentDto.java
* Autor: liandrad
* Fecha de creación: 9 sep. 2021
*/
package com.tis.mx.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Gets the investment years.
 *
 * @return the investment years
 */
@Getter

/**
 * Sets the investment years.
 *
 * @param investmentYears the new investment years
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
public class InitialInvestmentDto {
  
  /** The initial investment. */
  private Double initialInvestment; 
  
  /** The yearly input. */
  private Double yearlyInput; 
  
  /** The yearly input increment. */
  private Integer yearlyInputIncrement; 
  
  /** The investment yield. */
  private Float investmentYield; 
  
  /** The investment years. */
  private Integer investmentYears; 
  
  
  
  
}
