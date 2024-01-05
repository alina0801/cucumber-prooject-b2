package com.alina.step_definitions;

import com.alina.pages.WikiPage;
import com.loop.utilities.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;

import static com.loop.utilities.WikipediaConstants.wikipedia_search;
import static com.loop.utilities.WikipediaConstants.wikipedia_title;
import static org.junit.Assert.assertEquals;

public class WikiStepDef {

    WikiPage wikiPage = new WikiPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("wikipedia"));
    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String input) {
        wikiPage.searchBox.sendKeys(wikipedia_search + Keys.ENTER);

    }

    @And("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiPage.searchButton.click();
        BrowserUtils.takeScreenshot();
    }

    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String title) {
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals("Expected does not match the actual", wikipedia_title, actualTitle);

    }

    @Then("User sees {string} is in the main header")
    public void user_sees_is_in_the_main_header(String header) {
        Assert.assertTrue("Test fail", wikiPage.headerImage.isDisplayed());

    }

    @Then("User sees {string} is in the image header")
    public void user_sees_is_in_the_image_header(String imageHeader) {
        Assert.assertTrue("Test fail", wikiPage.mainHeader.isDisplayed());

    }
}

