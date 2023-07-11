package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart {
	WebDriver driver;
	By havePromo = By.cssSelector("p a.collapse-button");
	By promoTextBox = By.name("discount_name");
	By promoAddBtn = By.xpath("//span[text()= 'Add'])");
	By proceedToCheckoutBtn = By.linkText("PROCEED TO CHECKOUT");
	By removeItemOne = By.cssSelector(".cart-items .cart-item:nth-of-type(1) .float-xs-left");
	By removeItemTwo = By.cssSelector(".cart-items .cart-item:nth-of-type(2) .float-xs-left");
	By totalValue = By.cssSelector(".cart-total .value");

	public ShoppingCart(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getHavePromo() {
		return driver.findElement(havePromo);
	}

	public WebElement getPromoTextBox() {
		return driver.findElement(promoTextBox);
	}

	public WebElement getPromoAddBtn() {
		return driver.findElement(promoAddBtn);
	}

	public WebElement getProceedToCheckoutBtn() {
		return driver.findElement(proceedToCheckoutBtn);
	}

	public WebElement getRemoveItemOne() {
		return driver.findElement(removeItemOne);
	}

	public WebElement getRemoveItemTwo() {
		return driver.findElement(removeItemTwo);
	}

	public WebElement getTotalValue() {
		return driver.findElement(totalValue);
	}



}
