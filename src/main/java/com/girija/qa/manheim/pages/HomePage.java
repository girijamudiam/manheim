package com.girija.qa.manheim.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	WebDriver webDriver;

	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void go() {
		webDriver.get("http://shoestore-manheim.rhcloud.com");
	}

	public WebElement email;

	public WebElement submitEmail;

	public WebElement promoCode;

	public WebElement submitPromoCode;

	public WebElement brand;

	public WebElement search;

	public WebElement emailMessage;

	public WebElement findMonthLink(String linktext) {
		return webDriver.findElement(By.linkText(linktext));
	}

	public void selectMonth(String month) {
		findMonthLink(month).click();
	}

	public void enterEmail(String emailstring) {
		email = webDriver.findElement(By.id("remind_email_input"));
		email.sendKeys(emailstring);
	}

	public void submitEmail() {
		submitEmail = webDriver.findElement(By.xpath("//*[@id='remind_email_form']/div/input[@type='submit']"));
		submitEmail.click();
	}

	public void enterPromoCode(String promocode) {
		promoCode = webDriver.findElement(By.id("promo_code_input"));
		promoCode.sendKeys(promocode);
	}

	public void submitPromoCode() {
		submitPromoCode = webDriver.findElement(By.xpath("//*[@id='promo_code_form']/div/input[@type='submit']"));
		submitPromoCode.click();
	}

	public void selectBrand(String brandSelect) {
		brand = webDriver.findElement(By.id("brand"));
		Select select = new Select(brand);
		select.selectByValue(brandSelect);
	}

	public void searchByBrand() {
		search = webDriver.findElement(By.id("search_button"));
		search.click();
	}

	public Boolean verifyEmailMessage(String message) {
		emailMessage = webDriver.findElement(By.cssSelector("#flash > div"));
		return emailMessage.getText().contains(message);
	}
}
