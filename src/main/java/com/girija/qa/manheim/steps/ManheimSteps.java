package com.girija.qa.manheim.steps;


import java.util.Map;
import java.util.Map.Entry;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.girija.qa.manheim.pages.HomePage;
import com.girija.qa.manheim.pages.MonthPage;
import com.girija.qa.manheim.pages.PageFactory;
import com.google.common.base.Splitter;

import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class ManheimSteps {
	
    public HomePage homePage;
    
    public MonthPage monthPage;
    
    public String emailString = "test@user.com";
    
	public String message = "Thanks! We will notify you of our new shoes at this email: " + emailString;
	
	public ManheimSteps(PageFactory pageFactory){
 
		homePage = pageFactory.newHomePage();
		monthPage = pageFactory.newMonthPage();
		
    }
	    @Given("I am on shoestore-manheim")
	    public void givenTheUserIsOnHomePage() {
	        is_the_home_page();
	    }

	    @When("I enter valid e-mail in an area to submit email address and submit")
	    public void whenTheUserEntersValidEmail() {
	    	entersEmail(emailString);
	    }
	    
	    @Then("I should get <Thanks! We will notify you of our new shoes at this email: users email> message")
	    public void thenTheyShouldSeeValidResponse() {
	    	verifyEmailSubscriptionMessage(message);
	    }
	    
	    @When("I select a month for shoe release")
	    public void whenTheUserSelectsMonth(@Named("month") String month) {
	        selectMonth(month);
	    }

	    @Then("month should display a small Blurb of each shoe")
	    public void thenMonthDisplayBlurb(@Named("blurb") String blurb) {
			if (!blurb.trim().isEmpty()) {
				Map<String, String> map = Splitter.on(';')
						.withKeyValueSeparator("=").split(blurb.trim());
				for (Entry<String, String> entry : map.entrySet()) {
					verifyBlurb(entry.getValue(),
							Integer.parseInt(entry.getKey()));
				}
			} else {
				verifyNoResultsOnPage();
			}
	    }
	    
	    @Then("Month should display an image each shoe being released")
	    public void thenMonthDisplayImage(@Named("image") String image) {
	    	if (!image.trim().isEmpty()) {
				Map<String, String> map = Splitter.on(';')
						.withKeyValueSeparator("=").split(image.trim());
				for (Entry<String, String> entry : map.entrySet()) {
					verifyImage(entry.getValue(),
							Integer.parseInt(entry.getKey()));
				}
			} else {
				assertThat(true,Matchers.equalTo(true));
			}
	    }
	    
	    @Then("shoe should have a suggested price pricing")
	    public void thenMonthDisplayPrice(@Named("price") String price) {
	    	
	    	if (!price.trim().isEmpty()) {
				Map<String, String> map = Splitter.on(';')
						.withKeyValueSeparator("=").split(price.trim());
				for (Entry<String, String> entry : map.entrySet()) {
					verifyPrice(entry.getValue(),
							Integer.parseInt(entry.getKey()));
				}
			} else {
				assertThat(true,Matchers.equalTo(true));
			}
	    }
	    
	    public void entersEmail(String emailString) {
	        homePage.enterEmail(emailString);
	        homePage.submitEmail();
	    }

	    public void verifyEmailSubscriptionMessage(String emailMessage) {
	    	assertThat(homePage.verifyEmailMessage(emailMessage),Matchers.equalTo(true));
	    }

	    public void selectMonth(String monthLinkText) {
	    	homePage.selectMonth(monthLinkText);
	    }

	    public void is_the_home_page() {
	        homePage.go();
	    }
	    
	    public void verifyBlurb(String blurb, int index) {
	    	assertThat(monthPage.verifyShoeDescription(blurb,index),Matchers.equalTo(true));
	    }
	    
	    public void verifyImage(String image, int index) {
	    	assertThat(monthPage.verifyShoeImage(image,index),Matchers.equalTo(true));
	    }
	    
	    public void verifyPrice(String price, int index) {
	    	assertThat(monthPage.verifyShoePrice(price,index),Matchers.equalTo(true));
	    }
	    
	    public void verifyNoResultsOnPage() {
	    	assertThat(monthPage.shoesCount(),Matchers.lessThanOrEqualTo(0));
	    }
}
