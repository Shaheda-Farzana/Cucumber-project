package com.BDDCucumberProject.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"D:\\myWorkspace\\BDDCucumberProject\\src\\test\\resources\\features"},
		glue={"com/BDDCucumberProject/stepDef"}
		)

public class Runner {

}	
