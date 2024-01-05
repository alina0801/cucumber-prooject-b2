package com.loop.step_definitions;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before // different annotation from testNG
    public void setUp(Scenario scenario) {
        Driver.getDriver();
        BrowserUtils.myScenario = scenario;
    }

    @After
    public void tearDown(Scenario scenario){    //scenario - io.cucumber.java
        //only takes a screenshot when scenario is failed
        if(scenario.isFailed()){
           final byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);//downcast  to the driver

            scenario.attach(screenshot,"image/png", scenario.getName());   //attach only byte or string
        }
        Driver.closeDriver();
    }

    // @AfterStep
    public void screenShot(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png", scenario.getName());
    }
    }
    

