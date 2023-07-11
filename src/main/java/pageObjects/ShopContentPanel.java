package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopContentPanel {
	public WebDriver driver;
	By continueShoppingBtn = By.xpath("//button[contains(text(), 'Continue')]");
	By proceedToCheckoutBtn = By.partialLinkText("PROCEED TO CHECKOUT");

	By modalLabel = By.cssSelector("#myModalLabel");

	public ShopContentPanel(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getContinueShoppingBtn() {
		return driver.findElement(continueShoppingBtn);
	}

	public WebElement getProceedToCheckoutBtn() {
		return driver.findElement(proceedToCheckoutBtn);
	}

	public WebElement getModalLabel() {
		return driver.findElement(modalLabel);
	}
}
