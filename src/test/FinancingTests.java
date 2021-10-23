package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import test.factory.FinancingFactory;

public class FinancingTests {
	
	final double VALID_TOTAL_AMOUNT = 100000.00;
	final double VALID_SET_TOTAL_AMOUNT = 99999.99;
	final double INVALID_TOTAL_AMOUNT = 1000000.00;
	
	final double VALID_INCOME = 2000.00;
	final double VALID_SET_INCOME = 2000.01;
	final double INVALID_INCOME = 1;
	
	final int VALID_MONTHS = 80;
	final int VALID_SET_MONTHS = 81;
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
	
	@Test
	public void setTotalAmountShouldThorwsIllegalArgumentExceptionWhenInvalidData() {
		//arrange
		Financing f = FinancingFactory.createFinancingWithValidDatas();
		
		//assert with action
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			f.setTotalAmount(INVALID_TOTAL_AMOUNT);
		});
	}
	
	@Test
	public void setIncomeShouldUpdateIncomeWhenValidData() {
		//arrange
		Financing f = FinancingFactory.createFinancingWithValidDatas();
		
		//action
		f.setIncome(VALID_SET_INCOME);
		
		//assert
		Assertions.assertEquals(f.getIncome(), VALID_SET_INCOME);
	}
	
	@Test
	public void setIncomeShouldThrowsIllegalArgumentExceptionWhenInvalidData() {
		//arrange
		Financing f = FinancingFactory.createFinancingWithValidDatas();
		
		//assert with action
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			f.setIncome(INVALID_INCOME);
		});
	}
	
	@Test
	public void setMonthsShouldUpdateMonthsWhenValidData() {
		//arrange
		Financing f = FinancingFactory.createFinancingWithValidDatas();
		
		//action
		f.setMonths(VALID_SET_MONTHS);
		
		//assert
		Assertions.assertEquals(f.getMonths(), VALID_SET_MONTHS);
	}
	
	@Test
	public void setMonthsShouldThrowsIllegalArgumentExceptionWhenInvalidMonthsData() {
		//arrange
		Financing f = FinancingFactory.createFinancingWithValidDatas();
		
		//assert with action
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			f.setMonths(INVALID_MONTHS);
		});
	}
	
	@Test
	public void entryShouldCalculateCorrectlyTheEntryValue() {
		//arrange
		double entry = VALID_TOTAL_AMOUNT * 0.2;
		Financing f = FinancingFactory.createFinancingWithValidDatas();
		
		//action
		double realEntry = f.entry();
		
		//assert
		Assertions.assertEquals(realEntry, entry);
	}
	
	@Test
	public void quotaShouldCalculateCorrectlyTheValueQuota() {
		//arrange
		double quota = (VALID_TOTAL_AMOUNT - (VALID_TOTAL_AMOUNT *0.2)) / VALID_MONTHS;
		Financing f = FinancingFactory.createFinancingWithValidDatas();
		
		//action
		double realQuota = f.quota();
		
		//assert
		Assertions.assertEquals(realQuota, quota);
	}

}