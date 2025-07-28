package ru.yandex.praktikum.scooter.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderScooterPage {

    private WebDriver driver;

    //Поле Имя

    private By nameField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Имя']");

    //Поле Фамилия

    private By secondNameField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Фамилия']");

    //Поле адрес

    private By adressField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Адрес: куда привезти заказ']");

    //Поле метро

    private By subwayField = By.xpath(".//input[@placeholder='* Станция метро']");

    //Поле телефон

    private By phoneField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка далее

    private By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    //Для выбора метро из списка

    private final String metro = ".//button[@value='%s']";

    public OrderScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнение поля Имя

    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    //Заполнение поля Фамилия

    public void setSecondName(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }


    //Заполнение поля Адрес

    public void setAdressField(String adress) {
        driver.findElement(adressField).sendKeys(adress);
    }


    //Заполнение поля Метро

    public void setSubwayField(int subway) {
        driver.findElement(subwayField).click();
        By chooseMetroStation = By.xpath(String.format(metro, subway));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(chooseMetroStation));
        driver.findElement(chooseMetroStation).click();
    }


    //Заполнение поля Телефон

    public void setPhoneField(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }


    //Клик по кнопке Далее

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }


    //Ожидание загрузки страницы заказа самоката

    public void waitForLoadOrderScooterPage() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(nameField));
    }


    //Метод для заполнения страницы заказа

    public void orderScooter(String name, String secondName, String adress, int subway, String phone) {
        setName(name);
        setSecondName(secondName);
        setAdressField(adress);
        setSubwayField(subway);
        setPhoneField(phone);
        clickNextButton();

    }
}