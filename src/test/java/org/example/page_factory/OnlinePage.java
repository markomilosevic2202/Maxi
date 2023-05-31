package org.example.page_factory;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OnlinePage {

    @FindBy(xpath = "//div[contains(text(),'Dobro došli')]")
    WebElement linkDobroDosli;

    @FindBy(xpath = "//button[contains(text(),'Odjava')]")
    WebElement linkOdjava;

    @FindBy(xpath = "//*[contains(@class,'sc-6t7480-0 bPqIRK')]")
    WebElement element;

    @FindBy(xpath = "//a[contains(text(),'Preskoči link')]")
    WebElement linkHome;

    WebDriver driver;

    public OnlinePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void verifyElementExist(String text){
        List<WebElement> list = driver.findElements(By.xpath("//div[contains(text(),'" + text + "')]"));
        Assertions.assertTrue(list.size() > 0, "There is no element with this text '" + text + "'");
    }
    public void verifyElementNotExist(String text){
        List<WebElement> list = driver.findElements(By.xpath("//div[contains(text(),'" + text + "')]"));
        Assertions.assertTrue(list.size() == 0, "Element with this text '" + text + "' exist");
    }
    public void clickDobroDosli(){
        linkDobroDosli.click();
    }
    public void clickOdjava(){
        linkOdjava.click();
    }
    public void clickProductGroup(String productGroup){
        driver.findElement(By.xpath("//a[.//span[contains(text(), '" + productGroup + "')]]")).click();
    }
    public void clickProduct(String product){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.numberOfElementsToBe(By.xpath("//a[.//span[contains(text(), '" + product + "')]]"), 2));
        driver.findElements(By.xpath("//a[.//span[contains(text(), '" + product + "')]]")).get(1).click();
    }
    public void clickHome(){
        linkHome.click();
    }

}
