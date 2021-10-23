package test.factory;


import entities.Financing;

public class FinancingFactory {
	
	public static Financing createFinancingWithInvalidDatas() {
		return new Financing(100000.00, 2000.00, 20); 
	}
	
	public static Financing createFinancingWithValidDatas() {
		return new Financing(100000.00, 2000.00, 80); 
	}

}
