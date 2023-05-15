package com.BDDCucumberProject.Utility;

import java.io.File;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {
	WebDriver driver;
	
	public void captureScreenshot() {
	File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destination=new File(System.getProperty("user.dir")+"/target/)"+Screenshot1.jpeg);
	FileHandler.copy(screenshot,destination);
	}
}
