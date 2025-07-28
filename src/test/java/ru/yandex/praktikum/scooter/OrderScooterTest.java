package ru.yandex.praktikum.scooter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.scooter.pageobject.*;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderScooterTest {
    private WebDriver driver;
    private final String name;
    private final String secondName;
    private final String adress;
    private final int subway;
    private final String phone;
    private final String date;
    private final String comment;
    private final String expectedResult;


    public OrderScooterTest(String name, String secondName, String adress, int subway, String phone, String date, String comment, String expectedResult) {
        this.name = name;
        this.secondName = secondName;
        this.adress = adress;
        this.subway = subway;
        this.phone = phone;
        this.date = date;
        this.comment = comment;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "Имя: = {0}, Фамилия: = {1}, Адрес: = {2}, Метро под номером: = {3}, Телефон: = {4}, Дата доставки: = {5}, Комментарий курьеру: = {6}, Ожидаемый заголовок: = {7}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Владимир", "Набоков", "Мясницкая улица", 1, "+79099995546", "30.07.2025", "Позвонить по телефону по прибытию", "Заказ оформлен"},
                {"Петр", "Михайлов", "Проспект мира", 2, "+79034859648", "01.08.2025", "Припаркуйте у подъезда", "Заказ оформлен"},
        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

//Тест для заказа через верхнюю кнопку зазаза

    @Test
    public void orderScooterForUpButtonOrderTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.openScooterSite();
        objHomePage.waitForLoadUpButtonOrder();
        objHomePage.clickButtonOrderUpPage();
        OrderScooterPage objOrderScooterPage = new OrderScooterPage(driver);
        objOrderScooterPage.waitForLoadOrderScooterPage();
        objOrderScooterPage.orderScooter(name, secondName, adress, subway, phone);
        RentalInformationPage objRentalInformationPage = new RentalInformationPage(driver);
        objRentalInformationPage.waitForLoadAddRentalInformation();
        objRentalInformationPage.addRentalInformation(date, comment);
        OrderConfirmationPage objOrderConfirmationPage = new OrderConfirmationPage(driver);
        objOrderConfirmationPage.waitForLoadOrderConfirmationPage();
        objOrderConfirmationPage.clickYesButton();
        objOrderConfirmationPage.waitForLoadHeader();
        assertTrue(objOrderConfirmationPage.getHeaderText().contains(expectedResult));
    }

//Тест для заказа через кнопку в центре страницы

    @Test
    public void orderScooterForButtonOrderMiddlePageTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.openScooterSite();
        objHomePage.clickButtonCookie();
        objHomePage.waitForLoadMiddleButtonOrder();
        objHomePage.clickButtonOrderMiddlePage();
        OrderScooterPage objOrderScooterPage = new OrderScooterPage(driver);
        objOrderScooterPage.waitForLoadOrderScooterPage();
        objOrderScooterPage.orderScooter(name, secondName, adress, subway, phone);
        RentalInformationPage objRentalInformationPage = new RentalInformationPage(driver);
        objRentalInformationPage.waitForLoadAddRentalInformation();
        objRentalInformationPage.addRentalInformation(date, comment);
        OrderConfirmationPage objOrderConfirmationPage = new OrderConfirmationPage(driver);
        objOrderConfirmationPage.waitForLoadOrderConfirmationPage();
        objOrderConfirmationPage.clickYesButton();
        objOrderConfirmationPage.waitForLoadHeader();
        assertTrue(objOrderConfirmationPage.getHeaderText().contains(expectedResult));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}