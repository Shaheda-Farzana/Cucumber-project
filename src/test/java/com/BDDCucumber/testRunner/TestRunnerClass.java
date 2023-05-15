package com.BDDCucumber.testRunner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.BDDCucumber.stepDef.StepDefinitionClass;


public class TestRunnerClass {
	WebDriver driver;
	StepDefinitionClass object;
	
	@BeforeTest
	public void beforeTest()  {
		object=new StepDefinitionClass();
		object.user_launches_chrome_browser(); 
		object.user_opens_Islahi_portal_link();
		object.user_should_see_the_page_title();
		
	}
	@Test (priority=0)
	public void product_page() {
		object.user_is_on_the_product_page();
	}	
	@Test (priority=1)
	public void select_item_To_purchase()  {
		object.user_select_an_item_to_purchase();
	}
	
	@Test (priority=2)
	public void click_add_to_cart_button()  {
		object.user_click_the_add_to_cart_button();
	}	
	
	@Test (priority=3)
	public void check_item_in_the_cart() {	
		object.user_should_see_the_item_in_the_cart();
	}
		
	@Test (priority=4)
	public void cart_page()  {
	    object.user_is_on_cart_page();
	}
	
	@Test (priority=5)
	public void remove_item_from_cart() {
	    object.user_remove_the_item_from_the_cart();
	}   
	 
	@Test (priority=6)
	public void check_item_remove_from_cart() {
	    object.user_should_not_see_the_item_in_the_cart() ;
	}
	
	@AfterTest 
	public void afterTest() {
		object.user_quits_the_browser();
	}
}
