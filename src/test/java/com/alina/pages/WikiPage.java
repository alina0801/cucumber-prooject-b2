package com.alina.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPage {

    @FindBy(xpath = "//input[@id='searchInput']")
    public WebElement searchBox;
    WebElement searchBox1 = Driver.getDriver().findElement(By.xpath("//"));
    //WE(interfacee)
    // xpass(static method) -> Object of By(method)
    @FindBy(xpath = "i[contains(text(),'Search')]")
    public WebElement searchButton;

    @FindBy(xpath = "//span[@class='mw-page-title-main']")
    public WebElement mainHeader;

    @FindBy(xpath = "//th[@class='infobox-above']/div")
    public WebElement headerImage;

    public WikiPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
}
