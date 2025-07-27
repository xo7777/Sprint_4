package ru.yasamokat.page_object;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class HomePageScooter {
    private WebDriver driver;
    //Кнопка "Сколько это стоит? И как оплатить?"
    private By howMuchPayQuestion = By.id("accordion__heading-0");
    //Ответ на вопрос Сколько стоит
    private By howMuchPayAnswer = By.id("accordion__panel-0");

    //Кнопка "Хочу сразу несколько самокатов! Так можно?"
    private By wantSomeScooterQuestion = By.id("accordion__heading-1");
    //Ответ на вопрос про несколько самокатов
    private By wantSomeScooterAnswer = By.id("accordion__panel-1");

    //Кнопка "Как рассчитывается время аренды?"
    private By howIsRentalTimeCalculatedQuestion = By.id("accordion__heading-2");
    //Ответ на вопроос про время аренды
    private By howIsRentalTimeCalculatedAnswer = By.id("accordion__panel-2");

    //Кнопка "Можно ли заказать самокат прямо на сегодня?"
    private By canOrderTodayQuestion = By.id("accordion__heading-3");
    //Ответ на вопрос
    private By canOrderTodayAnswer = By.id("accordion__panel-3");

    //Кнопка "Можно ли продлить заказ или вернуть самокат раньше?"
    private By extendAndReturnScooterQuestion = By.id("accordion__heading-4");
    //Ответ на вопрос
    private By extendAndReturnScooterAnswer = By.id("accordion__panel-4");

    //Кнопка "Вы привозите зарядку вместе с самокатом?"
    private By bringChargerQuestion = By.id("accordion__heading-5");
    //Ответ на вопрос
    private By bringChargerAnswer = By.id("accordion__panel-5");

    //Кнопка "Можно ли отменить заказ?"
    private By cancelOrderQuestion = By.id("accordion__heading-6");
    //Ответ на вопрос
    private By cancelOrderAnswer = By.id("accordion__panel-6");

    //Кнопка "Я живу за МКАДом, привезёте?"
    private By longDistanceDeliveryQuestion = By.id("accordion__heading-7");
    //Ответ на вопрос
    private By longDistanceDeliveryAnswer = By.id("accordion__panel-7");

    //Кнопка заказать вверху страницы
    private By buttonOrderUpPage = By.className("Button_Button__ra12g");
    //Кнопка заказать посередине страницы
    private By buttonOrderMiddlePage = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка подтверждения куки
    private By buttonCookie = By.className("App_CookieButton__3cvqF");



    public HomePageScooter(WebDriver driver){
        this.driver = driver;
    }


    public void clickHowMuchPayQuestionButton(){
        driver.findElement(howMuchPayQuestion).click();
    }

    public void clickWantSomeScooterQuestionButton(){
        driver.findElement(wantSomeScooterQuestion).click();
    }

    public void clickHowIsRentalTimeCalculatedQuestionButton(){
        driver.findElement(howIsRentalTimeCalculatedQuestion).click();
    }

    public void clickCanOrderTodayQuestionButton(){
        driver.findElement(canOrderTodayQuestion).click();
    }

    public void clickExtendAndReturnScooterQuestionButton(){
        driver.findElement(extendAndReturnScooterQuestion).click();
    }

    public void clickBringChargerQuestionButton(){
        driver.findElement(bringChargerQuestion).click();
    }

    public void clickCancelOrderQuestionButton(){
        driver.findElement(cancelOrderQuestion).click();
    }

    public void clickLongDistanceDeliveryQuestionButton(){
        driver.findElement(longDistanceDeliveryQuestion).click();
    }

    public void clickButtonOrderUpPage(){
        driver.findElement(buttonOrderUpPage).click();
    }

    public void clickButtonOrderMiddlePage(){
        driver.findElement(buttonOrderMiddlePage).click();
    }


    public String getTextHowMuchPayAnswer(){
        return driver.findElement(howMuchPayAnswer).getText();
    }

    public String getTextWantSomeScooterAnswer(){
        return driver.findElement(wantSomeScooterAnswer).getText();
    }

    public String getTextHowIsRentalTimeCalculatedAnswer(){
        return driver.findElement(howIsRentalTimeCalculatedAnswer).getText();
    }


    public String getTextCanOrderTodayAnswer(){
        return driver.findElement(canOrderTodayAnswer).getText();
    }

    public String getTextExtendAndReturnScooterAnswer(){
        return driver.findElement(extendAndReturnScooterAnswer).getText();
    }

    public String getTextBringChargerAnswer(){
        return driver.findElement(bringChargerAnswer).getText();
    }

    public String getTextCancelOrderAnswer(){
        return driver.findElement(cancelOrderAnswer).getText();
    }

    public String getTextLongDistanceDeliveryAnswer(){
        return driver.findElement(longDistanceDeliveryAnswer).getText();
    }

    public void clickButtonCookie() {
        driver.findElement(buttonCookie).click();
    }
}
