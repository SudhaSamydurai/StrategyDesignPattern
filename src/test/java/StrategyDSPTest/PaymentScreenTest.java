package StrategyDSPTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import StrategyDSP.PaymentOptionFactory;
import StrategyDSP.PaymentScreen;

public class PaymentScreenTest extends BaseTest{
	
	private PaymentScreen paymentScreen;


	@Test(dataProvider = "getData")
	public void makePayment(String option, Map<String, String> paymentDetails) {
		paymentScreen = new PaymentScreen(this.driver);
		paymentScreen.goTo();
		paymentScreen.getUserInformation().enterUserInformation("Sudha", "su", "hellow@gmail.com");
		paymentScreen.setPaymentOption(PaymentOptionFactory.get(option));
		paymentScreen.pay(paymentDetails);
		String orderNumber = this.paymentScreen.getOrder().placeOrder();
		System.out.println("Order Number is "+orderNumber);
		
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

	}
	
	
	@DataProvider
	public Object[][] getData(){
		
		Map<String, String> cc = new HashMap<>();
		cc.put("cc", "12345678901");
		cc.put("year", "2022");
		cc.put("cvv", "322");
		
		Map<String, String> nb = new HashMap<>();
		nb.put("bank", "WELLS FARGO");
		nb.put("account", "Myaccount12");
		nb.put("pin", "1234");
		
		return new Object[][] {
			{"CC", cc}, 
			{"NB", nb}
		};
	}
}
