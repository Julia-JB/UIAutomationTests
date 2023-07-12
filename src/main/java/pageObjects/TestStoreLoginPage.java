package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestStoreLoginPage {
	public WebDriver driver;

	By email = By.cssSelector("section input[name='email']");

	By password = By.cssSelector("section input[name='password']");
	By loginBtn = By.cssSelector("#submit-login");
	
	public TestStoreLoginPage(WebDriver driver){
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLoginBtn() {
		return driver.findElement(loginBtn);
	}
}
