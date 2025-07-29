package ru.yandex.praktikum.scooter.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmationPage {

    private WebDriver driver;

    //Кнопка Да

    private By yesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    //Для сравнения текста заголовка "Заказ оформлен"

    private By headerText = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Клик по кнопке "Да"

    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    //Получение текста заголовка на странице с успешным заказом

    public String getHeaderText() {
        String text = driver.findElement(headerText).getText();
        return text;
    }


    //Ожидание загрузки страницы с подтверждением заказа

    public void waitForLoadOrderConfirmationPage() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(yesButton));
    }


    //Ожидание загрузки страницы со статусом заказа

    public void waitForLoadHeader() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(headerText));
    }


}