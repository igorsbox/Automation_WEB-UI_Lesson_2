package org.example.lesson_6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CallBackPage extends BasePage {

    public CallBackPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@placeholder='* Ваше имя:']")
    private WebElement nameInput;

    @FindBy (xpath = "//*[@placeholder='* Ваш телефон:']")
    private WebElement phoneInput;

    @FindBy (xpath = "//*[@placeholder='Комментарий: ']")
    private WebElement commentInput;

    @FindBy(xpath = "//button[text()='Отправить']")
    private WebElement sendButton;

    @FindBy (xpath = "//*[@class='popup-simple__close']")
    private WebElement closeButton;

    @Step("Заполнить поле ВАШЕ ИМЯ")
    public CallBackPage fillName(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    @Step("Заполнить поле ВАШ ТЕЛЕФОН")
    public CallBackPage fillPhone(String phone) {
        phoneInput.sendKeys(phone);
        return this;
    }

    @Step("Заполнить поле КОММЕНТАРИЙ")
    public CallBackPage fillComment(String comment) {
        commentInput.sendKeys(comment);
        return this;
    }

    @Step("Клик на кнопку ОТПРАВИТЬ")
    public CallBackPage clickSendButton() {
        sendButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.=' Ваше сообщение отправлено.']")));
        return this;
    }

    @Step("Проверка отправки Обратного звонка")
    public CallBackPage checkSentCallBack(){
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='alert alert--green']")).isDisplayed());
        return this;
    }

    @Step("Закрыть форму заказа обратного звонка")
    public MainPage clickCloseButton() {
        closeButton.click();
        return new MainPage(driver);
    }
}
