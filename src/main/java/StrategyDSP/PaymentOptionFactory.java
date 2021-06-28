package StrategyDSP;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionFactory {
	
	public static final Supplier<PaymentOption> CC = ()->new CreditCard();
	public static final Supplier<PaymentOption> NB = () -> new NetBanking();
	public static final Map<String, Supplier<PaymentOption>> map = new HashMap<>();
	
	
	static {
		map.put("CC", CC);
		map.put("NB", NB);
	}
	
	public static  PaymentOption get(String option) {
		return map.get(option).get();
	}
	

}
