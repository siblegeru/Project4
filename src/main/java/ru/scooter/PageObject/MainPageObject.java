package ru.scooter.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPageObject extends BaseCostract {
    private final By sectionOfQuestionsAboutImportantThings = By.xpath(".//div[text()='Вопросы о важном']");
    //Список номеров вопросов
    List<WebElement> webElementListFAQ = driver.findElements(By.className("accordion__button"));
    //Список номеров текстов ответов
    List<WebElement> webElementListTextAnswerFAQ = driver.findElements(By.className("accordion__panel"));


    public MainPageObject(WebDriver driver) {
        super(driver);
    }

    public void scrollForFAQ() {
        WebElement element = driver.findElement(sectionOfQuestionsAboutImportantThings);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickingOnQuestions(int numQuestions) {
        webElementListFAQ.get(numQuestions).click();
    }

    public boolean textFAQAnswerIsVisibale(int numAnswer) {
        WebElement checkQuestionsText = webElementListTextAnswerFAQ.get(numAnswer);
        return checkQuestionsText.isDisplayed();
    }

}
