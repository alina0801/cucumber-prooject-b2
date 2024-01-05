package com.alina.step_definitions;
import com.alina.pages.SmartBearLoginPage;
import com.alina.pages.SmartBearOrderPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import static com.loop.utilities.SmartBearConstants.*;
public class OrderStepDef {
    SmartBearLoginPage smartBearLoginPage = new SmartBearLoginPage();;
    SmartBearOrderPage smartBearOrderPage = new SmartBearOrderPage();
    @Given("user is already logged in and navigated to order page")
    public void user_is_already_logged_in_and_navigated_to_order_page() {

      smartBearLoginPage.navigateToURL();
      smartBearLoginPage.login();
      smartBearOrderPage.navigateOrderModules("Order");
    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String productType) {

      smartBearOrderPage.dropdownProductType();

    }
    @When("user enters quantity {int}")
    public void user_enters_quantity(Integer quantity) {
        smartBearOrderPage.quantityBox.clear();
        BrowserUtils.waitForClickable(smartBearOrderPage.quantityBox, DocuportConstants.small);
        smartBearOrderPage.quantityBox.sendKeys(quantitySmartBear.toString());
    }
    @When("user enters customer name {string}")
    public void user_enters_customer_name(String name) {
        smartBearOrderPage.nameBox.sendKeys(Keys.BACK_SPACE,
                nameAddressInputSmartBear);
    }
    @When("user enters street {string}")
    public void user_enters_street(String street) {
        smartBearOrderPage.streetBox.sendKeys(Keys.BACK_SPACE,
                streetAddressInputSmartBear);

    }
    @When("user enters city {string}")
    public void user_enters_city(String city) {
        smartBearOrderPage.cityBox.sendKeys(Keys.BACK_SPACE,
                cityAddressInputSmartBear);

    }
    @When("user enters state {string}")
    public void user_enters_state(String state) {
        smartBearOrderPage.stateBox.sendKeys(Keys.BACK_SPACE,
                stateAddressInputSmartBear);
    }
    @When("user enters zip {string}")
    public void user_enters_zip(String zip) {
        smartBearOrderPage.zipBox.sendKeys(Keys.BACK_SPACE,
                zipAddressInputSmartBear);

    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String cardType) {
       smartBearOrderPage.creditCardType(creditCardTypeSmartBear);
    }
    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String creditCardInput) {
      smartBearOrderPage.creditCardInput.sendKeys(creditCardInputSmartBear);


    }
    @When("user enters expiration date {string}")
    public void user_enters_expiration_date(String expDate) {
        smartBearOrderPage.expDateCreditCardInput.sendKeys(expDateCreditCardSmartBear);
    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
       smartBearOrderPage.processOrderButton.click();
       smartBearOrderPage.successfulMessage.isDisplayed();
    }
    @Then("user should see {string} in the first row of the table")
    public void user_should_see_in_the_first_row_of_the_table(String name) {

        smartBearOrderPage.navigateOrderModules("View all orders");
        //smartBearOrderPage.allTables.click();
        
       String actual = smartBearOrderPage.firstListName.getText();
        Assert.assertEquals("Actual doesn't match expected", name, actual);

    }
}
