package com.loop.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//We write Scenarios in Feature class, create snippets in regular java class in step_definition package and RUN the code in another java class which is in runner package.
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/loop/step_definitions"   // step definitions
)
public class CukesRunner {
}
