package com.loop.utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static com.loop.utilities.Driver.getDriver;
import static org.junit.Assert.assertTrue;


public class BrowserUtils {
    /**
     * validate if driver switched to expected url and title
     *
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author alina
     * implements assertion
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle) {
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     * switches to the new window by the exact title
     * return to original window if the window with given title not found
     *
     * @param targetTitle
     * @oaran driver
     */

    public static void switchToWindow(WebDriver driver, String targetTitle) {

        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }


    /**
     * @param driver
     * @param expectedTitle returns void, assertion is implemented
     * @author alina
     */
    public static void validateTitle(WebDriver driver, String expectedTitle) {
        assertTrue(driver.getTitle().contains(expectedTitle));
    }


    /**
     * Click any link from loop practice
     *
     * @param nameOfPage
     * @author alina
     */
    public static void loopLinkClick(String nameOfPage) {
        WebElement element = getDriver().findElement(By.xpath("//a[.='" + nameOfPage + "']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Moves the mouse to given element
     *
     * @param element on which to hover
     * @author alina
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     * @author alina
     */

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click;", element);
    }

    /**
     * Performs double click action on an element
     *
     * @param element
     * @author alina
     */

    public static void doubleClick(WebElement element) {
        new Actions(getDriver()).doubleClick(element).build().perform();
    }

    /**
     * Waits for the provided element to be visible on the page
     *
     * @param element
     * @param timeToWaitInSec
     * @return
     * @author alina
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for the provided element to be invisible on the page
     *
     * @param element
     * @param timeToWaitInSec
     * @author alina
     */
    public static void waitForInVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * * Waits for provided element to be clickable
     * * @param element
     * * @param timeout
     * * @return
     * * @author alina
     */

    public static WebElement waitForClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

/**
 *
 */
public static void justWait(int seconds) {
    try {
        Thread.sleep(seconds);
    }catch (InterruptedException e){
        e.printStackTrace();
    }
}

public static Scenario myScenario;
public static void takeScreenshot(){
    try {
        myScenario.log("Current url is: " + Driver.getDriver().getCurrentUrl() );
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        myScenario.attach(screenshot, "image/png", myScenario.getName());
    }catch (WebDriverException wbd) {
        wbd.getMessage();
    }catch (ClassCastException classCastException){
        classCastException.getMessage();
    }
}

}
