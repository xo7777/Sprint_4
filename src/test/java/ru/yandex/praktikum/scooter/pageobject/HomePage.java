package ru.yandex.praktikum.scooter.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    //Массив локаторов вопросов

    private By[] questions = {By.id("accordion__heading-0"),
            By.id("accordion__heading-1"),
            By.id("accordion__heading-2"),
            By.id("accordion__heading-3"),
            By.id("accordion__heading-4"),
            By.id("accordion__heading-5"),
            By.id("accordion__heading-6"),
            By.id("accordion__heading-7")
    };

    //Массив локаторов ответов

    private By[] answers = {By.id("accordion__panel-0"),
            By.id("accordion__panel-1"),
            By.id("accordion__panel-2"),
            By.id("accordion__panel-3"),
            By.id("accordion__panel-4"),
            By.id("accordion__panel-5"),
            By.id("accordion__panel-6"),
            By.id("accordion__panel-7")
    };


    //Кнопка заказать вверху страницы

    private By buttonOrderUpPage = By.className("Button_Button__ra12g");

    //Кнопка заказать посередине страницы

    private By buttonOrderMiddlePage = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Кнопка подтверждения куки

    private By buttonCookie = By.className("App_CookieButton__3cvqF");

    //URL сайта

    private static final String URL_SCOOTER = "https://qa-scooter.praktikum-services.ru/";


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    //Открытие сайта

    public void openScooterSite() {
        driver.get(URL_SCOOTER);
    }


    //Клик по вопросу

    public void clickQuestions(int index) {
        driver.findElement(questions[index]).click();
    }

    //Получение текста ответа

    public String getAnswersText(int index) {
        return driver.findElement(answers[index]).getText();
    }

    //Клик по верхней кнопке заказать

    public void clickButtonOrderUpPage() {
        driver.findElement(buttonOrderUpPage).click();
    }

    //Клик по средней кнопке заказать

    public void clickButtonOrderMiddlePage() {
        driver.findElement(buttonOrderMiddlePage).click();
    }

    //Клик по кнопке принятия куки

    public void clickButtonCookie() {
        driver.findElement(buttonCookie).click();
    }


    //Ожидание загрузки вопроса

    public void waitForLoadQuestion(int index) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(questions[index]));
    }


    //Ожидание загрузки текста ответа

    public void waitForLoadAnswer(int index) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(answers[index]));
    }


    //Ожидание кликабельности верхней кнопки заказать

    public void waitForLoadUpButtonOrder() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(buttonOrderUpPage));
    }

    //Ожидание кликабельности средней кнопки заказать

    public void waitForLoadMiddleButtonOrder() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(buttonOrderMiddlePage));
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(buttonOrderMiddlePage));
    }


}