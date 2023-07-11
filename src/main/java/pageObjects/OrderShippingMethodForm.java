package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderShippingMethodForm {
	WebDriver driver;
	By deliveryCommentField = By.cssSelector("#delivery_message");
	By continueBtn = By.cssSelector("button[name='confirmDeliveryOption']");

	public OrderShippingMethodForm(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getDeliveryCommentField() {
		return driver.findElement(deliveryCommentField);
	}

	public WebElement getContinueBtn() {
		return driver.findElement(continueBtn);
	}
}
