package org.example.page_factory;

import org.example.object.Product;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class CheckoutPage {
    @FindBy(className = "sc-1mgqutw-0")
    WebElement element;

    @FindBy(className = "caWbHO")
    List<WebElement> listItems;

    @FindBy(className = "leZJRR")
    WebElement priceAllItems;

    @FindBy(className = "cAKAfV")
    List <WebElement> btnAddOrRemove;

    @FindBy(className = "bmBhCh")
    List <WebElement> inpNumberPieces;

    @FindBy(className = "eXNxVJ")
    List <WebElement> btnRemoveProduct;

    @FindBy(className = "iGMXEt")
    List <WebElement> btnNotification;

    @FindBy(id = "pickerNote")
    WebElement textarea;

    @FindBy(className = "fgOqya")
    WebElement btnSave;

    @FindBy(className = "hKgYcE")
    List <WebElement> numberNotification;

    DecimalFormat df = new DecimalFormat("#.##");

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyElementExist(int numberItems) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
        Assertions.assertTrue(listItems.size() == numberItems, " :: Number product in list not correct :: ");
    }

    public void verifyTotalBill(Double bill)  {

        String totalPriceString = priceAllItems.getText();
        totalPriceString = totalPriceString.replace(",", ".");
        Double totalPriceDouble = Double.parseDouble(totalPriceString.substring(totalPriceString.indexOf(" "), totalPriceString.length()));
        Assertions.assertTrue(Double.compare(totalPriceDouble,Math.round(bill * 100.0) / 100.0) == 0, " :: The total price is not correct :: ");

    }

    public List<Product> addAllElementsInList() {

        df.setRoundingMode(RoundingMode.HALF_UP);
        List<Product> listProduct = new ArrayList<>();

        for (int i = 0; i < listItems.size(); i++) {

            Product product = new Product();
            WebElement webElement = listItems.get(i);
            String priceString = webElement.findElement(By.className("sc-1qeaiy2-2")).getText();
            priceString = priceString.replace(",", ".");
            Double price = Double.parseDouble(priceString.substring(0, priceString.indexOf(" ")));
            int numberOfPieces = Integer.parseInt(webElement.findElement(By.className("bmBhCh")).getAttribute("value"));
            product.setNumberOfPieces(numberOfPieces);
            product.setTotalPrice(Double.valueOf(df.format(price)));
            product.setPrice(Double.valueOf(df.format(price / product.getNumberOfPieces())));
            product.setName(webElement.findElement(By.className("bVltfk")).getText());
            product.setWeight(webElement.findElement(By.className("laiUsZ")).getText());
            listProduct.add(product);

        }
        return listProduct;

    }
    public void addProduct(int numberItems) {

        for (int i = 0; i < numberItems; i++) {
            btnAddOrRemove.get(1).click();
        }

    }
    public void removeProduct(int numberItems) {
        btnAddOrRemove.get(0).click();
    }

    public void verifyNumber(int numberPieces)  {

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.attributeContains(inpNumberPieces.get(0), "value", String.valueOf(numberPieces)));
        int numberPiecesPage = Integer.parseInt(inpNumberPieces.get(0).getAttribute("value"));
        Assertions.assertTrue(numberPiecesPage == numberPieces, " :: Number of pieces of the product is not correct :: ");

    }
    public void totalPriceItem(Double totalBilOnItems)  {
        WebElement webElement = listItems.get(0);
        String priceString = webElement.findElement(By.className("sc-1qeaiy2-2")).getText();
        priceString = priceString.replace(",", ".");
        Double price = Double.parseDouble(priceString.substring(0, priceString.indexOf(" ")));
        price = Math.round(totalBilOnItems * 100.0) / 100.0;
        Assertions.assertTrue(Double.compare(price,Math.round(totalBilOnItems * 100.0) / 100.0) == 0, " :: The total price item is not correct :: ");

    }
    public void removeFirsProduct(){
        btnRemoveProduct.get(0).click();
    }
    public void verifyNameElementNotExist(String name){

        List<Product> list = addAllElementsInList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)){
                Assertions.fail(" :: Name product exist in checkout :: ");
            }
        }
    }
    public void inputText(String text) {
        textarea.clear();
        textarea.sendKeys(text);
    }
    public void clickNotificationFirstElement() {
        btnNotification.get(0).click();
    }
    public void clickSaveNotification() {
        btnSave.click();
    }

    public void verifyNumberNotificationIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.className("hKgYcE")));
        Assertions.assertTrue(numberNotification.size() > 0, " :: Number notification does not exist :: ");

    }
    public void verifyNumberNotificationIsNotVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.numberOfElementsToBe(By.className("hKgYcE"),0));
        Assertions.assertTrue(numberNotification.size() == 0, " :: Number notification exists :: ");

    }

    public void verifyTextNotificationCorrect(String text) {
        String textInput = textarea.getText();
        Assertions.assertTrue(textInput.equals(text), " :: Text Notification does not correct :: ");

    }




    }


