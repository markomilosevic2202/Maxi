package org.example.page_factory;

import org.example.object.Product;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;

public class OnlinePage {

    @FindBy(xpath = "//div[contains(text(),'Dobro došli')]")
    WebElement linkDobroDosli;

    @FindBy(xpath = "//button[contains(text(),'Odjava')]")
    WebElement linkOdjava;

    @FindBy(xpath = "//*[contains(@class,'sc-6t7480-0 bPqIRK')]")
    WebElement element;

    @FindBy(xpath = "//*[contains(@class,'sc-17vg88v-0 kuvTkU')]")
    WebElement linkHome;

    @FindBy(xpath = "//*[contains(@class,'iaPCqF')]")
    WebElement scheduleDelivery;

    @FindBy(xpath = "//button[contains(@class,'sc-dyjemn-9 huSpzL')]")
    WebElement btnChooseLater;

    @FindBy(xpath = "//*[contains(@class,'sc-y4jrw3-0 gTTPXD')]")
    List<WebElement> listProduct;

    @FindBy(className = "fTJKCW")
    WebElement elementBasket;


    WebDriver driver;

    public OnlinePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyElementExist(String text) {
        List<WebElement> list = driver.findElements(By.xpath("//div[contains(text(),'" + text + "')]"));
        Assertions.assertTrue(list.size() > 0, "There is no element with this text '" + text + "'");
    }

    public void verifyElementNotExist(String text) {
        List<WebElement> list = driver.findElements(By.xpath("//div[contains(text(),'" + text + "')]"));
        Assertions.assertTrue(list.size() == 0, "Element with this text '" + text + "' exist");
    }

    public void clickDobroDosli() {
        linkDobroDosli.click();
    }

    public void clickOdjava() {
        linkOdjava.click();
    }

    public void clickProductGroup(String productGroup) {
        driver.findElement(By.xpath("//a[.//span[contains(text(), '" + productGroup + "')]]")).click();
    }

    public void clickProduct(String product) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.numberOfElementsToBe(By.xpath("//a[.//span[contains(text(), '" + product + "')]]"), 2));
        driver.findElements(By.xpath("//a[.//span[contains(text(), '" + product + "')]]")).get(1).click();
    }

    public void clickHome() {

        linkHome.click();
    }

    public Product addProduct(int ordinalNumber, int numberOfPieces) throws InterruptedException {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        Product product = new Product();

        WebElement webElement = listProduct.get(ordinalNumber);
        String priceString = webElement.findElement(By.className("cvodff")).findElement(By.className("sc-1qeaiy2-2")).getText();
        priceString = priceString.replace(",", ".");//jEVmkC
        Double price = Double.parseDouble(priceString.substring(0,priceString.indexOf(" ")));
        webElement.findElement(By.className("dyQUVu")).click();

        for (int i = 1; i < numberOfPieces; i++) {
            webElement.findElements(By.className("cAKAfV")).get(1).click();
        }
        product.setNumberOfPieces(numberOfPieces);
        product.setPrice(Double.valueOf(df.format(price)));
        product.setTotalPrice(Double.valueOf(df.format(numberOfPieces * price)));
        product.setName(webElement.findElement(By.className("hgxuXW")).getText());
        product.setWeight(webElement.findElement(By.className("laiUsZ")).getText());
        return product;

    }
    public void waitWindowScheduleDelivery(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(scheduleDelivery));

    }
    public void clickChooseLater(){
        btnChooseLater.click();

    }
    public void verifyNumberItemsOnBasket(int numberItem){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.textToBe(By.className("fTJKCW"), Integer.toString(numberItem)));
       Assertions.assertTrue(numberItem == Integer.parseInt(elementBasket.getText()), "The number of elements in the basket is incorrect ");

    }
    public void clickOnBasket(){
        elementBasket.click();

    }
}
