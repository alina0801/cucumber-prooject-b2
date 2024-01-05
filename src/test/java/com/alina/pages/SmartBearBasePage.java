package com.alina.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
public class SmartBearBasePage {

    public void navigateToURL() {
        Driver.getDriver().get(ConfigurationReader.getProperty("smart.bear"));
    }
    @FindBy(xpath = "//ul[@id='ctl00_menu']//li//a")
    List<WebElement> allOrderModules;

    public void navigateOrderModules(String orderModuleName) {

        for (int i = 0; i < allOrderModules.size(); i++) {
            if(allOrderModules.get(i).getText().contains(orderModuleName)){
                BrowserUtils.waitForClickable(allOrderModules.get(i), DocuportConstants.large).click();
            }
        }
    }

//        for (WebElement each : allOrderModules) {
//            if (each.getText().equals(orderModuleName)) {
//                BrowserUtils.waitForClickable(each, DocuportConstants.medium).click();
//            }
//        }
// }
    public SmartBearBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    }

