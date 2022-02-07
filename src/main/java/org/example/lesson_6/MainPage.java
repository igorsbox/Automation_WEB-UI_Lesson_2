package org.example.lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//a[@href='#account']")
    private WebElement loginButton;

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }

    @FindBy (xpath = "//a[contains(text(),'Обратный звонок')]")
    private WebElement callBackButton;

    public CallBackPage clickCallBack() {
        callBackButton.click();
        return new CallBackPage(driver);
    }

    @FindBy (xpath = "//a[contains(text(),'Магазин')]")
    private WebElement magazinButton;

    public MainPage clickMagazin() {
        magazinButton.click();
        return this;
    }

    @FindBy (xpath = "//span[contains(text(),'Юбки-солнце из фатина')]")
    private WebElement yubkiSolntseIzFatina;

    public YubkiSolntseIzFatinaPage clickYubkiSolntseIzFatina() {
        yubkiSolntseIzFatina.click();
        return new YubkiSolntseIzFatinaPage(driver);
    }
}
