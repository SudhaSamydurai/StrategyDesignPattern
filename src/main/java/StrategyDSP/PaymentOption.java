package StrategyDSP;

import java.util.Map;

public interface PaymentOption {
	
	public abstract void enterDetails(Map<String, String> paymentDetails);

}
