package com.girija.qa.manheim.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MonthPage {

	WebDriver webDriver;

	public MonthPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public List<WebElement> shoeBrandList;

	public List<WebElement> shoeNameList;

	public List<WebElement> shoePriceList;

	public List<WebElement> shoeDescriptionList;

	public List<WebElement> shoeReleaseMonth;

	public List<WebElement> shoeImageList;

	private WebElement montResultsTitle;

	public Boolean verifyShoeBrand(String brand, int index) {
		shoeBrandList = webDriver.findElements(By
				.cssSelector("td.shoe_result_value.shoe_brand > a"));
		return shoeBrandList.get(index).getText().contains(brand);
	}

	public Boolean verifyShoeName(String name, int index) {
		 shoeNameList = webDriver.findElements(By
					.cssSelector("td.shoe_result_value.shoe_name"));
		return shoeNameList.get(index).getText().contains(name);
	}

	public Boolean verifyShoePrice(String price, int index) {
		shoePriceList = webDriver.findElements(By
				.cssSelector("td.shoe_result_value.shoe_price"));
		return shoePriceList.get(index).getText().contains(price);
	}

	public Boolean verifyShoeDescription(String description, int index) {
		shoeDescriptionList = webDriver.findElements(By
				.cssSelector("td.shoe_result_value.shoe_description"));
		return shoeDescriptionList.get(index).getText().contains(description);
	}

	public Boolean verifyShoeReleaseMonth(String month, int index) {
		shoeReleaseMonth = webDriver.findElements(By
				.cssSelector("td.shoe_result_value.shoe_release_month"));
		return shoeReleaseMonth.get(index).getText().contains(month);
	}

	public Boolean verifyMontResultsTitle(String title) {
		montResultsTitle = webDriver.findElement(By
				.cssSelector("body > div.title > h2"));
		return montResultsTitle.getText().contains(title);
	}

	public Boolean verifyShoeImage(String image, int index) {
		shoeImageList = webDriver.findElements(By
				.cssSelector("tr.shoe_result_row > td.shoe_image > img"));
		return shoeImageList.get(index).getAttribute("src").contains(image);
	}

	public int shoesCount() {
		shoeNameList = webDriver.findElements(By
				.cssSelector("td.shoe_result_value.shoe_name"));
		try {
			int i = shoeNameList.size();
			return i;
		} catch (Exception e) {
			return 0;
		}
	}
}
