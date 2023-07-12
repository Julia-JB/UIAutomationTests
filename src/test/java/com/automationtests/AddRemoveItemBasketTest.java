package com.automationtests;

import base.BasePage;
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

public class AddRemoveItemBasketTest extends BasePage {
	public AddRemoveItemBasketTest() throws IOException {
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
	public void addRemoveItem() throws IOException, InterruptedException {
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

		shopPanel.getContinueShoppingBtn().click();

		shopProductPage.getHomePageLink().click();
		shopHome.getProductTwo().click();
		shopProductPage.getAddToCartBtn().click();
		shopPanel.getProceedToCheckoutBtn().click();

		ShoppingCart cart = new ShoppingCart(driver);

		Assert.assertEquals(cart.getCartItems().size(), 2,
				"Number of items does not match expected");
		double totalBefore = Double.parseDouble(cart.getTotalValue().getText().replaceAll("[^\\d.]", ""));

		cart.getRemoveItemTwo().click();

		wait.until(ExpectedConditions.invisibilityOf(cart.getItemTwo()));

		Assert.assertEquals(cart.getCartItems().size(), 1,
				"Number of items does not match expected");

		double totalAfter = Double.parseDouble(cart.getTotalValue().getText().replaceAll("[^\\d" +
				".]", ""));
		Assert.assertTrue(totalBefore > totalAfter, "Total price was not reduced after item " +
				"removal");
	}
}
