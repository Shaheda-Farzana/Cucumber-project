package com.BDDCucumberProject.Utility;


import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;


public class FluentWaits {

			private static final Duration DEFAULT_TIMEOUT=Duration.ofSeconds(30);
			private static final Duration DEFAULT_POLLING_INTERVAL=Duration.ofSeconds(1);
			private static final Class<? extends Throwable> DEFAULT_EXCEPTION_TO_IGNORE= NoSuchElementException.class;
			
			public static WebElement waitForElement(WebDriver driver, final By by) {
				FluentWait<WebDriver> wait=new FluentWait<> (driver)
						.withTimeout(DEFAULT_TIMEOUT)
						.pollingEvery(DEFAULT_POLLING_INTERVAL)
						.ignoring(DEFAULT_EXCEPTION_TO_IGNORE);
				
				return (WebElement) wait.until(new Function<WebDriver,WebElement>(){
					public WebElement apply(WebDriver driver) {
						return driver.findElement(by);
					}
				});
		    }

			
			public static WebElement waitForElement(WebDriver driver, final By by, Duration timeout) {
				FluentWait<WebDriver> wait=new FluentWait<> (driver)
						.withTimeout(timeout)
						.pollingEvery(DEFAULT_POLLING_INTERVAL)
						.ignoring(DEFAULT_EXCEPTION_TO_IGNORE);
			
				return (WebElement) wait.until(new Function<WebDriver,WebElement>(){
					public WebElement apply(WebDriver driver) {
						return driver.findElement(by);
					}
				});
			}


			public static WebElement waitForElement(WebDriver driver, final By by,Duration timeout, Duration pollingInterval, Class<? extends Throwable> exceptionsToIgnore) {
				FluentWait<WebDriver> wait=new FluentWait<> (driver)
					.withTimeout(timeout)
					.pollingEvery(pollingInterval)
					.ignoring(exceptionsToIgnore);
			
				return (WebElement) wait.until(new Function<WebDriver,WebElement>(){
					public WebElement apply(WebDriver driver) {
						return driver.findElement(by);
					}
				});
			}
	}

