package com.nordstrom.demo.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import junit.framework.Test;


@RunWith(Cucumber.class)
@CucumberOptions(features = "features", glue = {"stepDefinition"})
public class TestRunner{
	
	
	
}

