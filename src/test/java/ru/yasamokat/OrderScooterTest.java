package ru.yasamokat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yasamokat.page_object.HomePageScooter;
import ru.yasamokat.page_object.OrderConfirmationPage;
import ru.yasamokat.page_object.OrderScooterPage;
import ru.yasamokat.page_object.RentalInformationPage;

import static org.junit.Assert.assertEquals;
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

    @Parameterized.Parameters
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


    @Test
    public void orderScooterForUpButtonOrder() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.className("Button_Button__ra12g")));

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickButtonOrderUpPage();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Имя']")));

        OrderScooterPage objOrderScooterPage = new OrderScooterPage(driver);
        objOrderScooterPage.orderScooter(name, secondName, adress, subway, phone);

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Когда привезти самокат']")));

        RentalInformationPage objRentalInformationPage = new RentalInformationPage(driver);
        objRentalInformationPage.addRentalInformation(date, comment);

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']")));

        OrderConfirmationPage objOrderConfirmationPage = new OrderConfirmationPage(driver);
        objOrderConfirmationPage.clickYesButton();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_ModalHeader__3FDaJ")));

        assertTrue(objOrderConfirmationPage.getHeaderText().contains(expectedResult));
    }

    //Тест для заказа через кнопку в центре страницы
    @Test
    public void orderScooterForButtonOrderMiddlePage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickButtonCookie();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")));
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")));
        objHomePage.clickButtonOrderMiddlePage();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Имя']")));
        OrderScooterPage objOrderScooterPage = new OrderScooterPage(driver);
        objOrderScooterPage.orderScooter(name, secondName, adress, subway, phone);

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Когда привезти самокат']")));

        RentalInformationPage objRentalInformationPage = new RentalInformationPage(driver);
        objRentalInformationPage.addRentalInformation(date, comment);

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']")));

        OrderConfirmationPage objOrderConfirmationPage = new OrderConfirmationPage(driver);
        objOrderConfirmationPage.clickYesButton();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_ModalHeader__3FDaJ")));

        assertTrue(objOrderConfirmationPage.getHeaderText().contains(expectedResult));
    }


    @After
    public void teardown() {
        driver.quit();
    }

}



