package com.loop.step_definitions;

import com.loop.pages.GoogleSearchPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GoogleSearchStepDef {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("smart.bear"));
    }
    @When("user types Loop Academy in the google search box and clicks enter")
    public void user_types_loop_academy_in_the_google_search_box_and_clicks_enter() {
        googleSearchPage.searchBox.sendKeys("Loop Academy" + Keys.ENTER);
        BrowserUtils.takeScreenshot();
    }
    public void user_should_see_loop_academy_google_search_in_the_google_title() {
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals("expected does not match the actual", "Loop Academy - Google Search", actualTitle);
    }

    @When("user types {string} in the google search box and clicks enter")
    public void user_types_in_the_google_search_box_and_clicks_enter(String input) {
        googleSearchPage.searchBox.sendKeys(input + Keys.ENTER);
    }
    public void user_should_see_in_the_google_title(String title) {
        assertEquals("expected title: - " + title + " does not match actual title: " + Driver.getDriver().getTitle(), title, Driver.getDriver().getTitle());
    }
    @Then("user ")
    public void user_searches_the_following_item(List<String> items) {
//        items.forEach(p -> {
//            googleSearchPage.searchBox.clear();
//            googleSearchPage.searchBox.sendKeys(p + Keys.ENTER);
//            assertEquals(p + " - Google Search", Driver.getDriver().getTitle());
//        } );

        for (String s : items){
            googleSearchPage.searchBox.clear();
            googleSearchPage.searchBox.sendKeys(s + Keys.ENTER);
            assertEquals(s + " - Google Search", Driver.getDriver().getTitle());
        }

    }

    @When("user searches the the {string}")
    public void user_searches_the_the(String country) {
        googleSearchPage.searchBox.sendKeys("What is the capital of " + country + Keys.ENTER);
       // BrowserUtils.justWait(DocuportConstants.small);
    }
    public void user_should_see_the_in_the_result(String capital) {
       assertEquals("Expected capital city: " + capital + "does NOT match with actual: " + googleSearchPage.capital.getText() , googleSearchPage.capital.getText(), capital);

       
    }
}




