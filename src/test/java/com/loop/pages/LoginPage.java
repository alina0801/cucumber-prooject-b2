package com.loop.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//input[@id='input-14']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@id='input-15']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@type='submit']//span")
    public WebElement continueButton;

    /**
     * logins to DOCUPORT
     * @param username
     * @param password
     * @author alina
     */
    public void loginDocuport(String username, String password){
        BrowserUtils.waitForVisibility(userNameInput, DocuportConstants.small);
        userNameInput.clear();
        userNameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
        if (BrowserUtils.waitForVisibility(continueButton, DocuportConstants.small).isDisplayed()) {
            continueButton.click();
        }
    }

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
