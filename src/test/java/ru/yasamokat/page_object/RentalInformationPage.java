package ru.yasamokat.page_object;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RentalInformationPage {

    private WebDriver driver;
    //Поле дата
    private By dateField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Когда привезти самокат']");
    //Поле срок аренды
    private By rentalPeriodField = By.className("Dropdown-arrow");
    //Выбор аренды на двое суток
    private By twoDays = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");
    //Выбор черного цвета
    private By blackCheckbox = By.xpath(".//input[@id='black']");
    //Выбор серого цвета
    private By greyCheckbox = By.xpath(".//input[@id='grey']");
    //Комментарий курьеру
    private By courierComment = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='Комментарий для курьера']");
    //Кнопка Заказать
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    public RentalInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDateField(String date) {
        driver.findElement(dateField).sendKeys(date);
    }

    public void setRentalPeriodField() {
        driver.findElement(rentalPeriodField).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(twoDays));
        driver.findElement(twoDays).click();
    }

    public void chooseBlackCheckbox() {
        driver.findElement(blackCheckbox).click();
    }

    public void chooseGreyCheckbox() {
        driver.findElement(greyCheckbox).click();
    }


    public void setCourierComment(String comment) {
        driver.findElement(courierComment).sendKeys(comment);
    }


    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }


    public void addRentalInformation(String date, String comment) {
        setDateField(date);
        setRentalPeriodField();
        chooseBlackCheckbox();
        setCourierComment(comment);
        clickOrderButton();

    }
}