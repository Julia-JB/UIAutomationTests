package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopHomePage {
	public WebDriver driver;

	By productOne = By.xpath("//section/div/article[1]/div/a");
	By productTwo = By.xpath("//section/div/article[2]/div/a");
	By productThree = By.xpath("//section/div/article[3]/div/a");
	By productFour = By.xpath("//section/div/article[4]/div/a");
	By productFive = By.xpath("//section/div/article[5]/div/a");
	By productSix = By.xpath("//section/div/article[6]/div/a");
	By productSeven = By.xpath("//section/div/article[7]/div/a");
	By productEight = By.xpath("//section/div/article[8]/div/a");


	public ShopHomePage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getProductOne() {
		return driver.findElement(productOne);
	}

	public WebElement getProductTwo() {
		return driver.findElement(productTwo);
	}
	public WebElement getProductThree() {
		return driver.findElement(productThree);
	}

	public WebElement getProductFour() {
		return driver.findElement(productFour);
	}

	public WebElement getProductFive() {
		return driver.findElement(productFive);
	}

	public WebElement getProductSix() {
		return driver.findElement(productSix);
	}

	public WebElement getProductSeven() {
		return driver.findElement(productSeven);
	}

	public WebElement getProductEight() {
		return driver.findElement(productEight);
	}
}
