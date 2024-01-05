package com.alina.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//We write Scenarios in Feature class add tag, create step_definition package, run runner class, create snippets for step_definition package from runner output, create page(constructor+elements), code in stepDef - create an instance object of the page  (add screenshot method for evidence), RUN the code in runner package.

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/cucumber-report.html",  // on jenkins cucumber is html report
                "json:target/jason-reports/json-report"}, // helps to add report to JiraXray
        features = "src/test/resources/alina_features",
        glue = "com/alina/step_definitions",
        dryRun = false, //false - normally executing, will check everything, go inside the code, its actually check test/code, if true - not checking what is in your code, checking if all your scenarios/steps have code implemented - quick, doesn't care
        monochrome = true,  //reduce unnecessary red inflammation of code
        tags = "  @B2G3-150 or @B2G3-224 or B2G3-243" // @wip if not ready yet  // "or" will run both matching // tags = "@smoke and @regression" - will run the first
)
public class CukesRunner {
}
