package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import test.factory.FinancingFactory;

public class FinancingTests {
	
	final double VALID_TOTAL_AMOUNT = 100000.00;
	final double VALID_INCOME = 2000.00;
	final int VALID_MONTHS = 80;
	
	final double VALID_SET_TOTAL_AMOUNT = 99999.99;
	
	final int INVALID_MONTHS = 20;
	
	@Test
	public void constructorShouldCreateObjectsCorrectlyWhenValidData() {
	
		Financing f = FinancingFactory.createFinancingWithValidDatas();
		
		Assertions.assertEquals(f.getTotalAmount(), VALID_TOTAL_AMOUNT);
		Assertions.assertEquals(f.getIncome(), VALID_INCOME);
		Assertions.assertEquals(f.getMonths(), VALID_MONTHS);
	}
	
	@Test
	public void constructorShouldThrowsIllegalArgumentExceptionWhenInvalidData() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = FinancingFactory.createFinancingWithInvalidDatas();
		});	
	}
	
	@Test
	public void setTotalAmountShouldUpdateTheValuesWhenValidData() {
		//arrange
		Financing f = FinancingFactory.createFinancingWithValidDatas();
		
		//action
		f.setTotalAmount(VALID_SET_TOTAL_AMOUNT);
		
		//assert
		Assertions.assertEquals(f.getTotalAmount(), VALID_SET_TOTAL_AMOUNT);
		
	}

}