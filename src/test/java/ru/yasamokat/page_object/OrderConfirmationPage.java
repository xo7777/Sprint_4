package ru.yasamokat.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {
    private WebDriver driver;
    //Кнопка Да
    private By yesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //Для сравнения текста заголовка "Заказ оформлен"
    private By headerText = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderConfirmationPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickYesButton(){
        driver.findElement(yesButton).click();
    }

    public String getHeaderText(){
        String text = driver.findElement(headerText).getText();
        return text;
    }

}

