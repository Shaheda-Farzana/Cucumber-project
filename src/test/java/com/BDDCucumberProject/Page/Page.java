package com.BDDCucumberProject.Page;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {
	WebDriver driver;
	WebDriverWait wait;
	
	SoftAssert softAssert= new SoftAssert();
	
	public Page(WebDriver driver) {
		this.driver=driver;		
	}

	By item_category	 = By.linkText("Islamic Canvas");
	By product_Name		 =By.linkText("Kaaba Sharif Canvas Gallery Wraps");
	By add_to_cart_button=By.xpath("//button[@class='single_add_to_cart_button button alt wp-element-button']");
	By cart_item         =By.xpath("//div[@class='ast-product-name']");
	By removed_item      =By.xpath("//span[@class='ahfb-svg-iconset ast-inline-flex']");
	By undo_btn          =By.xpath("//a[@class='restore-item']");
	
	
	public WebDriver chrome_browser_launch() {
		 WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    return driver;
		
	}

	public void opens_Islahi_portal_link() {
		driver.get("https://islahiart.com/");	
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
	}

	public void validation_by_matching_page_title() {
		String actual_title="Islahi Art – The Islamic Store";
		String expected_title="Islahi Art – The Islamic Store";
		softAssert.assertEquals(actual_title, expected_title, "Title does not matched");
		
		softAssert.assertAll();
	}
	
	public void open_product_page() {
		driver.get("https://islahiart.com/");   
	}
	
	public void select_an_item_to_purchase() {
		try{
			wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(item_category));
			driver.findElement(item_category).click();
		
			JavascriptExecutor jsE= (JavascriptExecutor) driver ;
			long scrollHeight = (long) jsE.executeScript("return Math.max( document.body.scrollHeight, document.body.offsetHeight, document.documentElement.clientHeight, document.documentElement.scrollHeight, document.documentElement.offsetHeight )");
			jsE.executeScript("window.scrollTo(0, " + scrollHeight/2 + ")");
			
			driver.findElement(product_Name).click();
	   }catch(Exception e) {
		    System.out.println("Exception handled"+ e.getMessage());
			e.printStackTrace();
	   }
		
	}
	
	public void click_the_add_to_cart_button() {
		try {
		JavascriptExecutor jsE= (JavascriptExecutor) driver ;
		long scrollHeight = (long) jsE.executeScript("return Math.max( document.body.scrollHeight, document.body.offsetHeight, document.documentElement.clientHeight, document.documentElement.scrollHeight, document.documentElement.offsetHeight )");
		jsE.executeScript("window.scrollTo(0, " + scrollHeight/4 + ")");
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(add_to_cart_button));
		driver.findElement(add_to_cart_button).click();
		}catch(Exception e) {
			e.printStackTrace();	
		}
	}
	
    public void check_item_in_the_cart() {
		driver.get("https://islahiart.com/cart-2/");
		WebElement productName = driver.findElement(cart_item);
		String cartContent = productName.getText();
		softAssert.assertTrue(cartContent.contains("Kaaba Sharif Canvas Gallery Wraps - 32″ x 48″, Premium Gallery Wraps (1.25″)"), "Image not found in cart");
   
		softAssert.assertAll();
	}


	public void open_cart_page() {
		try {
			driver.get("https://islahiart.com/cart-2/");
		}catch(Exception e) {
			System.out.println("Exception handled"+e.getMessage());
		}
	}

	public void item_removed_from_the_cart() {
		
	   driver.findElement(removed_item).click();
	}

	public void validation_of_removed_item_in_the_cart() {
		WebElement undoMsg = driver.findElement(undo_btn);
    	String actualUndoMsg = undoMsg.getText();
    	Assert.assertFalse(actualUndoMsg.contains("Kaaba Sharif Canvas Gallery Wraps"), "Item still found in cart");
	}
	
	public void quit_browser() {
		driver.quit();
	}
}
