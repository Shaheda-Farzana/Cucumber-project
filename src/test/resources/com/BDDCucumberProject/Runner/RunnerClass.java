package com.BDDCucumberProject.Runner;

import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
				features={"D:\\myWorkspace\\BDDCucumberProject\\src\\test\\resources\\features"},
				glue={"com/BDDCucumberProject/stepDef"}
				)

public class RunnerClass {

}
