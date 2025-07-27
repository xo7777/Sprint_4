package ru.yasamokat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yasamokat.page_object.HomePageScooter;


import static org.junit.Assert.assertEquals;

public class CheckTextAnswersTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void CheckTextAnswerOnFirstQuestion(){

        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-0")));
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickButtonCookie();
        objHomePage.clickHowMuchPayQuestionButton();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("accordion__panel-0")));
        String expectedResult = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actualResult = objHomePage.getTextHowMuchPayAnswer();
        assertEquals(expectedResult, actualResult);

    }


    @Test
    public void CheckTextAnswerOnSecondQuestion(){

        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-1")));
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickButtonCookie();
        objHomePage.clickWantSomeScooterQuestionButton();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("accordion__panel-1")));
        String expectedResult = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String actualResult = objHomePage.getTextWantSomeScooterAnswer();
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void CheckTextAnswerOnThirdQuestion(){

        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-2")));
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickButtonCookie();
        objHomePage.clickHowIsRentalTimeCalculatedQuestionButton();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("accordion__panel-2")));
        String expectedResult = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String actualResult = objHomePage.getTextHowIsRentalTimeCalculatedAnswer();
        assertEquals(expectedResult, actualResult);

    }


    @Test
    public void CheckTextAnswerOnFourthQuestion(){

        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-3")));
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickButtonCookie();
        objHomePage.clickCanOrderTodayQuestionButton();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("accordion__panel-3")));
        String expectedResult = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String actualResult = objHomePage.getTextCanOrderTodayAnswer();
        assertEquals(expectedResult, actualResult);

    }



    @Test
    public void CheckTextAnswerOnFifthQuestion(){

        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-4")));
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickButtonCookie();
        objHomePage.clickExtendAndReturnScooterQuestionButton();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("accordion__panel-4")));
        String expectedResult = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String actualResult = objHomePage.getTextExtendAndReturnScooterAnswer();
        assertEquals(expectedResult, actualResult);

    }



    @Test
    public void CheckTextAnswerOnSixthQuestion(){

        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-5")));
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickButtonCookie();
        objHomePage.clickBringChargerQuestionButton();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("accordion__panel-5")));
        String expectedResult = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String actualResult = objHomePage.getTextBringChargerAnswer();
        assertEquals(expectedResult, actualResult);

    }





    @Test
    public void CheckTextAnswerOnSeventhQuestion(){

        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-6")));
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickButtonCookie();
        objHomePage.clickCancelOrderQuestionButton();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("accordion__panel-6")));
        String expectedResult = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String actualResult = objHomePage.getTextCancelOrderAnswer();
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void CheckTextAnswerOnEighthQuestion(){

        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-7")));
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickButtonCookie();
        objHomePage.clickLongDistanceDeliveryQuestionButton();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("accordion__panel-7")));
        String expectedResult = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        String actualResult = objHomePage.getTextLongDistanceDeliveryAnswer();
        assertEquals(expectedResult, actualResult);

    }



    @After
    public void teardown() {
        driver.quit();
    }

}
