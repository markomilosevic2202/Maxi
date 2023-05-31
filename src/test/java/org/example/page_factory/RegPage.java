package org.example.page_factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegPage {

    @FindBy(xpath = "//*[contains(text(),'Prijavite se')]")
    WebElement btnSubmit;

    @FindBy(id = "emailOrPhoneNumber")
    WebElement inpEmail;

    @FindBy(id = "current-password")
    WebElement inpPass;

    @FindBy(xpath = "//*[contains(@class,'sc-46osa9-2 sc-46osa9-4 crUUAk hEpyWp')]")
    WebElement btnPrihvatam;






    WebDriver driver;

    public RegPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickSubmit(){
        btnSubmit.click();
    }
    public void clickPrihvatam(){
        btnPrihvatam.click();
    }
    public void enterEmail(String email) throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(inpEmail));
        inpEmail.sendKeys(email);
    }
    public void enterPass(String pass){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(inpEmail));
        inpPass.sendKeys(pass);
    }


}
