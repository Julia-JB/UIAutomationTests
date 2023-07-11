package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPage {
	WebDriver driver;

	By confirmationCard = By.cssSelector(".h1.card-title");

	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getConfirmationCard() {
		return driver.findElement(confirmationCard);
	}
}
