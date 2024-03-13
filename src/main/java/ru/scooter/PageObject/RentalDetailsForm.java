package ru.scooter.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RentalDetailsForm extends BaseCostract {
    // Кнопка заказа в шапке страницы
    private final By orderHeaderButtonInThePage = By.className("Button_Button__ra12g");
    //Кнопка оформления заказа на главной странице
    private final By orderMainButtonOnThePage = By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp' and text()='Заказать']");

    //Поле ввода имени пользователя
    private final By firstNameFieldForOrderingAScooter = By.xpath(".//input[@placeholder='* Имя']");
    //Поле ввода Фамилии
    private final By lastNameFieldForOrderingAScooter = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле ввода Адрес
    private final By deliveryAddressInputField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле ввода Станции метро
    private final By inputMetroStationClick = By.xpath(".//input[@class='select-search__input']");
    //Поле ввода Телефона
    private final By telephoneInputFieldForOrderDelivery = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее формы Для кого заказ
    private final By buttonToGoToTheNextOrderForm = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    //Поле Когда привезти самокат
    private final By deliveryDateInputField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле Срок аренды
    private final By scooterRentalPeriodList = By.xpath(".//span[@class='Dropdown-arrow']");

    //Чекбоксы с выбором цвета самоката Черный
    private final By choiceOfBlackScooterColor = By.xpath(".//label[@class='Checkbox_Label__3wxSf' and @for='black']");
    //Чекбоксы с выбором цвета самоката Серый
    private final By choiceOfGreyScooterColor = By.xpath(".//label[@class='Checkbox_Label__3wxSf' and @for='grey']");
    //Поле Комментарий для курьера
    private final By commentEntryFieldForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка подтверждения оформления заказа
    private final By orderConfirmationButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    //Кнопка подтверждения создания заказа на форме Хотите оформить заказ
    private final By buttonYesInFinalFormCreateOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //Текст подтверждения, что заказ успешно создан
    private final By textFinishOrder = By.className("Order_ModalHeader__3FDaJ");

    public RentalDetailsForm(WebDriver driver) {
        super(driver);
    }

    //Метод клика на кнопку заказать в шапке
    public void clickONButtonOrderInHeaderPage() {
        driver.findElement(orderHeaderButtonInThePage).click();
    }

    //Метод клика по кнопке заказа в центре страницы
    public void clickONButtonOrderInCenterPage() {
        WebElement element = driver.findElement(By.xpath(".//div[@class='Home_FinishButton__1_cWm']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderMainButtonOnThePage).click();
    }


    //Метод клика на поле указания имени
    public void setFirstNameFieldForOrderingAScooter(String username) {
        driver.findElement(firstNameFieldForOrderingAScooter).sendKeys(username);
    }

    //Метод клика на поле указания фамилии
    public void setLastNameFieldForOrderingAScooter(String userLastName) {
        driver.findElement(lastNameFieldForOrderingAScooter).sendKeys(userLastName);
    }

    //Метод клика на поле указания адреса доставки
    public void setDeliveryAddressInputField(String address) {
        driver.findElement(deliveryAddressInputField).sendKeys(address);
    }

    //Метод клика на поле указания станции метро
    public void setFieldForSelectingAMetroStationForDelivery(int stationIndex) {
        driver.findElement(inputMetroStationClick).click();
        driver.findElement(By.xpath(".//ul/li[@data-index='" + stationIndex + "']")).click();
    }

    //Метод клика на поле указания телефона
    public void setTelephoneInputFieldForOrderDelivery(String phoneNumber) {
        driver.findElement(telephoneInputFieldForOrderDelivery).sendKeys(phoneNumber);
    }

    //Метод клика на кнопку перехода ко второй форме оформления заказа(Далее)
    public void clickForButtonToGoToTheSecondOrderForm() {
        driver.findElement(buttonToGoToTheNextOrderForm).click();
    }

    //Метод клика на поле выбора даты доставки самоката
    public void setDeliveryDateInputField(String dateDelivery) {
        driver.findElement(deliveryDateInputField).sendKeys(dateDelivery);
    }

    //Метод клика на поле выбора срока аренды
    public void ScooterRentalPeriodChoice(String periodOrder) {
        driver.findElement(scooterRentalPeriodList).click();
        driver.findElement(By.xpath(".//div[text()='" + periodOrder + "']")).click();
    }

    //Метод клика на поле выбора цвета самоката
    public void clickForColorBoxForScooter(String color) {
        if (color == "Черный") {
            driver.findElement(choiceOfBlackScooterColor).click();
        } else if (color == "Серый") {
            driver.findElement(choiceOfGreyScooterColor).click();
        }
    }

    //Метод клика на поле указания комментария курьеру
    public void setCommentEntryFieldForCourier(String comment) {
        driver.findElement(commentEntryFieldForCourier).sendKeys(comment);
    }

    //Метод клика на на кнопку Заказать
    public void clickForButtonOrderComplete() {
        driver.findElement(orderConfirmationButton).click();
    }

    //Метод подтверждения заказа на форме Хотите оформить заказ?
    public void clickForButtonYesInFinalFormCreateOrder() {
        driver.findElement(buttonYesInFinalFormCreateOrder).click();
    }

    //Метод проверки отображения об успешно созданном заказе
    public boolean checkTextFinishOrder() {
        return driver.findElement(textFinishOrder).isDisplayed();
    }

    public void shapeForWhomScooter(String username, String userLastName, String address, int index, String phoneNumber) {
        setFirstNameFieldForOrderingAScooter(username);
        setLastNameFieldForOrderingAScooter(userLastName);
        setDeliveryAddressInputField(address);
        setFieldForSelectingAMetroStationForDelivery(index);
        setTelephoneInputFieldForOrderDelivery(phoneNumber);
        clickForButtonToGoToTheSecondOrderForm();
    }

    public void formAboutRent(String dateDelivery, String periodOrder, String color, String comment) {
        setDeliveryDateInputField(dateDelivery);
        ScooterRentalPeriodChoice(periodOrder);
        clickForColorBoxForScooter(color);
        setCommentEntryFieldForCourier(comment);
        clickForButtonOrderComplete();
    }

}
