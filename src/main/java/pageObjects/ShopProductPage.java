package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopProductPage {
	public WebDriver driver;

	By sizeOption = By.cssSelector("select#group_1");
	By quantityIncrease = By.cssSelector(".touchspin-up");
	By quantityDecrease = By.cssSelector(".touchspin-down");
	By quantityWanted = By.cssSelector("#quantity_wanted");
	By addToCartBtn = By.cssSelector(".add-to-cart");
	By homepageLink = By.xpath("//span[text()='Home']");

	public ShopProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSizeOption() {
		return driver.findElement(sizeOption);
	}

	public WebElement getQuantityIncrease() {
		return driver.findElement(quantityIncrease);
	}

	public WebElement getQuantityDecrease() {
		return driver.findElement(quantityDecrease);
	}

	public WebElement getQuantityWanted() {
		return driver.findElement(quantityWanted);
	}

	public WebElement getAddToCartBtn() {
		return driver.findElement(addToCartBtn);
	}

	public WebElement getHomePageLink() {
		return driver.findElement(homepageLink);
	}
}
