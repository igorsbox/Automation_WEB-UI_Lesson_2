package org.example.lesson_6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessOrderPage extends BasePage{

    public SuccessOrderPage (WebDriver driver) {
        super(driver);
    }
    private final static String ZAKAZ_PRINYAT_BY_XPATH = "//h1[.='Ваш заказ принят!']";
    @FindBy (xpath = ZAKAZ_PRINYAT_BY_XPATH)
    private WebElement zakazPrinyat;

    @Step("Проверка оформления заказа")
    public SuccessOrderPage checkMadeOrder() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ZAKAZ_PRINYAT_BY_XPATH)));
        Assertions.assertTrue(driver.findElement(By.xpath(ZAKAZ_PRINYAT_BY_XPATH)).isDisplayed());
        return this;
    }

    @FindBy(xpath = "//a[contains(text(),'Продолжить')]")
    private WebElement prodolzhitButton;

    @Step("Клик на кнопку ПРОДОЛЖИТЬ")
    public MainPage clickProdolzhitButton() {
        prodolzhitButton.click();
        return new MainPage(driver);
    }
}
