package org.example.lesson_6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//a[@href='#account']")
    private WebElement loginButton;

    @Step("Нажать на иконку авторизации на главной странице")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }

    @FindBy (xpath = "//a[contains(text(),'Обратный звонок')]")
    private WebElement callBackButton;

    @Step("Нажать на кнопку Обратный звонок на главной странице")
    public CallBackPage clickCallBack() {
        callBackButton.click();
        return new CallBackPage(driver);
    }

    @FindBy (xpath = "//a[contains(text(),'Магазин')]")
    private WebElement magazinButton;

    @Step("Кликнуть на МАГАЗИН в меню на главной странице")
    public MainPage clickMagazin() {
        magazinButton.click();
        return this;
    }

    @FindBy (xpath = "//span[contains(text(),'Юбки-солнце из фатина')]")
    private WebElement yubkiSolntseIzFatina;

    @Step("Кликнуть на ЮБКИ-СОЛНЦЕ ИЗ ФАТИНА в меню на главной странице")
    public YubkiSolntseIzFatinaPage clickYubkiSolntseIzFatina() {
        yubkiSolntseIzFatina.click();
        return new YubkiSolntseIzFatinaPage(driver);
    }

    @FindBy (xpath = "//a[contains(text(),'Отзывы')]")
    private WebElement otzyvyButton;

    @Step("Кликнуть на ОТЗЫВЫ в меню на главной странице")
    public MainPage clickOtzyvy() {
        otzyvyButton.click();
        return this;
    }
}
