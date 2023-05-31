package org.example.page_factory;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Mozzart {

    @FindBy(xpath = "//span[contains(text(),'Fudbal')]")
    WebElement btnFootball;


    WebDriver driver;

    public Mozzart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
