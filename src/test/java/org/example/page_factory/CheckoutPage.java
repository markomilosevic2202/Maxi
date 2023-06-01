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

public class CheckoutPage {
    @FindBy(className = "sc-1mgqutw-0")
    WebElement element;

    @FindBy(className = "sc-10nbkk3-0")
    List<WebElement> listItems;

    @FindBy(className = "khUemx")
    WebElement priceAllItems;


    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyElementExist(int numberItems) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
         Assertions.assertTrue(listItems.size() == numberItems);
    }

    public void verify(Double bill) {
        System.out.println(bill);
        System.out.println(priceAllItems.findElement(By.className("dSLFbb")).getText());
//        Assertions.assertTrue(listItems.size() == numberItems);
    }
}
