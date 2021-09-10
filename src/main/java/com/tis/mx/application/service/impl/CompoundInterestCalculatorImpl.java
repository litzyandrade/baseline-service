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
* Nombre de archivo: CompoundInterestCalculatorImpl.java
* Autor: liandrad
* Fecha de creación: 9 sep. 2021
*/
package com.tis.mx.application.service.impl;


import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import com.tis.mx.application.service.CompoundInterestCalculator;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.springframework.stereotype.Service;

@Service
public class CompoundInterestCalculatorImpl implements CompoundInterestCalculator {

  /**
   * Creates the revenue grid. 
   *
   * @param initialInvestment the initial investment
   * @return the list
   */
  @Override
  public List<InvestmentYieldDto> createRevenueGrid(InitialInvestmentDto initialInvestment) {
    
    Integer year = 0;
    Double initialBalance = 0.0,yearlyInput = 0.0, invYield = 0.0,finalBalance = 0.0, finalAmount= 0.0,investmentProfit =0.0, sum = 0.0;
    
    year = initialInvestment.getInvestmentYears();
    
    ArrayList<InvestmentYieldDto> list = new ArrayList<>();
    
    for(int i= 0; i<year; i++) {
      InvestmentYieldDto output = new InvestmentYieldDto();
     
      if (i==0) {
        
        output.setInvestmentYear(1);
        initialBalance = initialInvestment.getInitialInvestment();
        sum+= yearlyInput = initialInvestment.getYearlyInput();

       } 
          else if (i>0) {
        output.setInvestmentYear(i+ 1);
        initialBalance = finalBalance;        
       sum+=  yearlyInput = (yearlyInput + (initialInvestment.getYearlyInput())*initialInvestment.getYearlyInputIncrement()/100);
         }
      
      invYield = (initialBalance + yearlyInput)*(initialInvestment.getInvestmentYield()/100);
      finalBalance =  initialBalance +yearlyInput + invYield;
      finalAmount = finalBalance;
      output.setInitialInvestment(Math.ceil(initialBalance));
      output.setYearlyInput(Math.ceil(yearlyInput));
      output.setInvestmentYield(Math.ceil(invYield));
      output.setFinalBalance(Math.ceil(finalBalance));
      
      list.add(output);
    }
    
    investmentProfit = finalAmount - initialInvestment.getInitialInvestment() - sum;
    
    //System.out.println("Ganancia por inversion: " + investmentProfit);
    //System.out.println("Monto Final: "+ finalAmount);
    //System.out.println(list);
    return list;
  }

  @Override
  public boolean validateInput(InitialInvestmentDto initialInvestment) {
   
   return initialInvestment.getInitialInvestment() >= 1000 &&
       initialInvestment.getYearlyInput() >0 && 
       initialInvestment.getYearlyInputIncrement() >0 && 
       initialInvestment.getInvestmentYears() >0;
           
  }

}
