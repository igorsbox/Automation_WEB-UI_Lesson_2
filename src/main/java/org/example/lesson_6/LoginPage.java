package org.example.lesson_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final static String LOGIN_INPUT_LOKATOR_BY_NAME = "email";
    @FindBy(name = LOGIN_INPUT_LOKATOR_BY_NAME)
    private WebElement loginInput;

    @FindBy(name = "password")
    private WebElement passInput;

    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement loginButton;

    public LoginPage fillLogin(String login) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(LOGIN_INPUT_LOKATOR_BY_NAME)));
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage fillPassword(String password) {
        passInput.sendKeys(password);
        return this;
    }

    public MainPage  clickLoginButton() {
        loginButton.click();
        return new MainPage(driver);
    }
}
