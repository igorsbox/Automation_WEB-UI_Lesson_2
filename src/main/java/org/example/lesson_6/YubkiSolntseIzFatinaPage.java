package org.example.lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YubkiSolntseIzFatinaPage extends BasePage{

    public YubkiSolntseIzFatinaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//span[contains(.,'Юбка-солнце из фатина Тысяча океанов')]")
    private WebElement tycyachaOkeanov;

    public OrderPage clickTysyachaOkeanov() {
        tycyachaOkeanov.click();
        return new OrderPage(driver);
    }
}
