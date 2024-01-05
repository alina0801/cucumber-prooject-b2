package com.alina.pages;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.DocuportConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import static com.loop.utilities.SmartBearConstants.*;
public class SmartBearOrderPage extends SmartBearBasePage {

    @FindBy(xpath = "//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']")
    public WebElement productButton;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityBox;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement nameBox;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetBox;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityBox;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateBox;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipBox;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    public WebElement americanExpressRadioButton;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visaRadioButton;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    public WebElement masterCardRadioButton;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement creditCardInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expDateCreditCardInput;
    @FindBy(xpath = "//strong[normalize-space(text())='New order has been successfully added.']")
    public WebElement successfulMessage;
    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processOrderButton;
    @FindBy(xpath = "//a[@href='Default.aspx']")
    public WebElement allTables;
    @FindBy(xpath = "(//th[text()='Name']/..//following-sibling::tr//td)[2]")
    public WebElement firstListName;

    public void dropdownProductType() {
         BrowserUtils.waitForClickable(productButton, DocuportConstants.small);
        Select productDropdown = new Select(productButton);
        productDropdown.selectByValue(productTypeSmartBear);
    }
    public void creditCardType(String cardType){

        switch (cardType){
            case "Visa":
                BrowserUtils.waitForClickable(visaRadioButton,DocuportConstants.small).click();
                break;
            case "MasterCard":
                BrowserUtils.waitForClickable(masterCardRadioButton,DocuportConstants.small).click();
                break;
            case "American Express":
                BrowserUtils.waitForClickable(americanExpressRadioButton,DocuportConstants.small).click();
        }

    }

}

//    public void enterAddressInf(String addressInfInput) {
//        for (WebElement each : addressInformation) {
//            if (each.getText().equals(addressInfInput)) {
//                if (addressInfInput.equals("Customer name")) {
//                    nameBox.clear();
//                    nameBox.sendKeys(nameAddressInputSmartBear);
//                } else if (addressInfInput.equals("Street")) {
//                    nameBox.clear();
//                    nameBox.sendKeys(streetAddressInputSmartBear);
//                } else if (addressInfInput.equals("City")) {
//                    nameBox.clear();
//                    nameBox.sendKeys(cityAddressInputSmartBear);
//                } else if (addressInfInput.equals("State")) {
//                    nameBox.clear();
//                    nameBox.sendKeys(stateAddressInputSmartBear);
//                } else if (addressInfInput.equals("Zip")) {
//                    nameBox.clear();
//                    nameBox.sendKeys(zipAddressInputSmartBear);
//            }


