package com.alina.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.loop.utilities.SmartBearConstants.*;
public class SmartBearLoginPage extends SmartBearBasePage {
    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernameBox;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement passwordBox;
    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginButton;

    public void login() {

        usernameBox.sendKeys(usernameSmartBear);
        passwordBox.sendKeys(passwordSmartBear);
        loginButton.click();
    }
}
