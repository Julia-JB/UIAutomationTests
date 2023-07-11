package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderFormPersonInfo {
	WebDriver driver;
	By genderMr = By.cssSelector("input[name='id_gender'][value='2']");
	By genderMs = By.cssSelector("input[name='id_gender'][value='2']");
	By firstNameField = By.cssSelector("input[name='firstname']");
	By lastNameField = By.cssSelector("input[name='lastname']");
	By emailField = By.cssSelector("#customer-form section input[name='email']");
	By passwordField = By.cssSelector("#customer-form input[name='password']");
	By birthdateField = By.cssSelector("#customer-form input[name='birthday']");
	By receiveOffersCheckbox = By.cssSelector("input[name='optin']");
	By newsletterCheckbox = By.cssSelector("input[name='newsletter']");
	By agreeToTermsCheckbox = By.cssSelector("input[name='psgdpr']");
	By continueBtn = By.cssSelector("#customer-form button[name='continue']");

	public OrderFormPersonInfo(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getGenderMr() {
		return driver.findElement(genderMr);
	}

	public WebElement getGenderMrs() {
		return driver.findElement(genderMs);
	}

	public WebElement getFirstNameField() {
		return driver.findElement(firstNameField);
	}

	public WebElement getLastNameField() {
		return driver.findElement(lastNameField);
	}

	public WebElement getEmailField() {
		return driver.findElement(emailField);
	}

	public WebElement getBirthdateField() {
		return driver.findElement(birthdateField);
	}

	public WebElement getPasswordField() {
		return driver.findElement(passwordField);
	}

	public WebElement getReceiveOffersCheckbox() {
		return driver.findElement(receiveOffersCheckbox);
	}

	public WebElement getNewsLetterCheckbox() {
		return driver.findElement(newsletterCheckbox);
	}

	public WebElement getAgreeToTermsCheckbox() {
		return driver.findElement(agreeToTermsCheckbox);
	}

	public WebElement getContinueBtn() {
		return driver.findElement(continueBtn);
	}
}
