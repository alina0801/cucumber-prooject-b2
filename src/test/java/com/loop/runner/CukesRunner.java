package com.loop.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//1. We write Scenarios in Feature class, 2.Run cukes class - to generate the snippet, 3. in step_definition package create snippets 4.RUN the code in runner class.


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/cucumber-report.html",  // on jenkins cucumber is html report
                "json:target/jason-reports/json-report"},           // helps to add report to JiraXray,
        // Jira test execution -> manually - evidence(steps +screenshots)
        //1 test execution - 1 sprint - all tests -> link test execution (маnual report)

        // automation cucumber no steps -> all together --> json report --> import to XRay
        features = "src/test/resources/features",                   // if you want multiple files {"","",""}
        glue = "com/loop/step_definitions",                         // step definitions package
        dryRun = false,                                              // switch on off//false - normally executing, will check everything, go inside the code, its actually check test/code, if true -                                                            not checking what is in your code, checking if all your scenarios/steps have code implemented - quick, doesn't care
        monochrome = true,                                          //reduce unnecessary inflammation , redness of the code
        tags = "@multithreading",                                             // @vip - if not ready yet
        // "or" will run both matching // && - will run the first // tags = "@smoke and @regression" // tags = "@smoke or @regression and not @closed - only one will run
        publish = false
)
public class CukesRunner {
}
