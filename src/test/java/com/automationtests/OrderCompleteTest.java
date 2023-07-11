package com.automationtests;

import base.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderCompleteTest extends BasePage {
	public OrderCompleteTest() throws IOException {
	super();
	}

	@BeforeTest
	public void setUp() throws IOException {
		driver = getDriver();
		driver.get(getUrl());
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}

	@Test
	public void endToEndTest() throws IOException {
		HomePage home = new HomePage(driver);
		home.getCookie().click();
		home.getTestStoreLink().click();

		Assert.assertEquals(driver.getCurrentUrl(),
				"http://teststore.automationtesting.co.uk/",
				"URL mismatch");

		ShopHomePage shopHome = new ShopHomePage(driver);
		WebElement productOne = shopHome.getProductOne();

		Assert.assertTrue(productOne.isDisplayed(), "Product One is not visible");
		shopHome.getProductOne().click();

		ShopProductPage shopProductPage = new ShopProductPage(driver);
		Select sizeDropdown = new Select(shopProductPage.getSizeOption());

		List<String> expectedSizes = Arrays.asList("S", "M", "L", "XL");
		List<String> actualSizes = sizeDropdown.getOptions()
				.stream()
				.map(WebElement::getText)
				.collect(Collectors.toList());

		Assert.assertEquals(actualSizes, expectedSizes,
				"Dropdown options do not match expected sizes");

		sizeDropdown.selectByVisibleText("M");

		shopProductPage.getQuantityIncrease().click();

		String quantityWanted = shopProductPage.getQuantityWanted().getAttribute("value");
		Assert.assertEquals(quantityWanted, "2", "Quantity value does not match expected");

		shopProductPage.getAddToCartBtn().click();

		ShopContentPanel shopPanel = new ShopContentPanel(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement label = wait.until(ExpectedConditions.visibilityOf(shopPanel.getModalLabel()));
		Assert.assertTrue(label.getText().contains("Product successfully added to " +
				"your shopping cart"),"Modal panel text does not match expected");

		shopPanel.getProceedToCheckoutBtn().click();
		Assert.assertEquals(driver.getTitle(), "Cart", "Cart page title does not match expected");

		ShoppingCart cart = new ShoppingCart(driver);
		cart.getHavePromo().click();
		cart.getPromoTextBox().sendKeys("20OFF");
		cart.getProceedToCheckoutBtn().click();

		Assert.assertEquals(driver.getCurrentUrl(),
				"http://teststore.automationtesting.co.uk/order",
				"Order page URL mismatch");

		OrderFormPersonInfo personInfo = new OrderFormPersonInfo(driver);
		Faker faker = new Faker();

		personInfo.getGenderMrs().click();
		personInfo.getFirstNameField().sendKeys(faker.name().firstName());
		personInfo.getLastNameField().sendKeys(faker.name().lastName());
		personInfo.getEmailField().sendKeys(faker.internet().emailAddress());
		personInfo.getReceiveOffersCheckbox().click();
		personInfo.getAgreeToTermsCheckbox().click();

		personInfo.getContinueBtn().click();

		OrderDeliveryForm deliveryForm = new OrderDeliveryForm(driver);
		deliveryForm.getAddressField().sendKeys(faker.address().streetAddress());
		deliveryForm.getCityField().sendKeys(faker.address().city());
		Select state  = new Select(deliveryForm.getStateDropdown());
		state.selectByIndex(5);
		deliveryForm.getPostcodeField().sendKeys(faker.number().digits(5));
		Select country = new Select(deliveryForm.getCountryDropdown());
		country.selectByVisibleText("United States");
		deliveryForm.getContinueBtn().click();

		OrderShippingMethodForm shippingMethodForm = new OrderShippingMethodForm(driver);
		shippingMethodForm.getDeliveryCommentField()
				.sendKeys(faker.chuckNorris().fact());

		shippingMethodForm.getContinueBtn().click();

		OrderPaymentForm paymentForm = new OrderPaymentForm(driver);
		paymentForm.getPayByCheck().click();
		paymentForm.getAgreeToTerms().click();
		paymentForm.getOrderBtn().click();

		Assert.assertEquals(driver.getTitle(), "Order confirmation",
				"Order confirmation page title does not match expected");

		OrderConfirmationPage confirmationPage = new OrderConfirmationPage(driver);
		Assert.assertTrue(confirmationPage.getConfirmationCard()
						.getText().contains("YOUR ORDER IS CONFIRMED"),
				"Confirmation message does not match expected");
	}
}
