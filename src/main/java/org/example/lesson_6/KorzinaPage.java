package org.example.lesson_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KorzinaPage extends BasePage{

    public KorzinaPage (WebDriver driver) {
        super(driver);
    }
    private final static String LOGIN_INPUT_LOKATOR_BY_XPATH = "//a[contains(text(),'Оформить заказ')]";

    @FindBy (xpath = LOGIN_INPUT_LOKATOR_BY_XPATH)
    private WebElement oformitZakazButton;

    public KorzinaPage clickOformitZakaz() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGIN_INPUT_LOKATOR_BY_XPATH)));
        oformitZakazButton.click();
        return this;
    }

    @FindBy (id = "comment")
    private WebElement comment;

    public KorzinaPage fillComment(String commentary) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Оформить заказ')]")));
        comment.sendKeys(commentary);
        return this;
    }

    @FindBy (className = "simplecheckout-button-right")
    private WebElement oformitZakazButton2;

    public SuccessOrderPage clickOformitZakazButton2() {
        oformitZakazButton2.click();
        return new SuccessOrderPage(driver);
    }
}
