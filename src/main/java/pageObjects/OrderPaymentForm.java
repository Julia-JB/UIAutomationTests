package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPaymentForm {
	WebDriver driver;

	By payByCheck = By.cssSelector("#payment-option-1");
	By payByWire = By.cssSelector("#payment-option-2");
	By agreeToTerms = By.cssSelector("#conditions_to_approve\\[terms-and-conditions\\]");
	By orderBtn = By.xpath("//div[@id='payment-confirmation']//button[@type='submit']");

	public OrderPaymentForm(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getPayByCheck() {
		return driver.findElement(payByCheck);
	}

	public WebElement getPayByWire() {
		return driver.findElement(payByWire);
	}

	public WebElement getAgreeToTerms() {
		return driver.findElement(agreeToTerms);
	}

	public WebElement getOrderBtn() {
		return driver.findElement(orderBtn);
	}
}
