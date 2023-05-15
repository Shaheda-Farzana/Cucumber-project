package com.BDDCucumber.stepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.BDDCucumberProject.Page.Page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionClass {
	public static WebDriver driver;
	WebDriverWait wait;
	
	Page page=new Page(driver);
	
	SoftAssert softAssert=new SoftAssert();
	
	@Given("^User launches chrome browser$")
	public void user_launches_chrome_browser() {
		page.chrome_browser_launch();	
	}
 
	@ When ("^User opens Islahi portal link$")
	public void user_opens_Islahi_portal_link() {
		page.opens_Islahi_portal_link();
	}

	@Then("^User should see the page title$")
	public void user_should_see_the_page_title() {
		page.validation_by_matching_page_title();
	}
	
	@Given("^User is on the product page$")
	public void user_is_on_the_product_page() {
		page.open_product_page();   
	}
	
	@When("^User select an item to purchase$")
	public void user_select_an_item_to_purchase() {
		page.select_an_item_to_purchase();
	}
	
	@And("^User click the Add to cart button$")
	public void user_click_the_add_to_cart_button() {
		page. click_the_add_to_cart_button();
	}
	
	@Then("^User should see the item in the cart$")
    public void user_should_see_the_item_in_the_cart() {
		page.check_item_in_the_cart();
	}

	@Given("^User is on cart page$")
	public void user_is_on_cart_page() {
		page. open_cart_page();
	}

	@When("^User remove the item from the cart$")
	public void user_remove_the_item_from_the_cart() {
		page. item_removed_from_the_cart();
	}

	@Then("^User should not see the item in the cart$")
	public void user_should_not_see_the_item_in_the_cart() {
		page.validation_of_removed_item_in_the_cart();
	}
	
	@And("^User quits the browser$")
	public void user_quits_the_browser() {
		page. quit_browser();
	}
}
