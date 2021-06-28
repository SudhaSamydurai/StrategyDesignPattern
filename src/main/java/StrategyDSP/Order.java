package StrategyDSP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Order {

	@FindBy(id="buy")
	private WebElement buyNowBtn;
	
	@FindBy(id="ordernumber")
	private WebElement orderNumberLabel;
	
	public String placeOrder() {
		this.buyNowBtn.click();
		return this.orderNumberLabel.getText();
	}
}
