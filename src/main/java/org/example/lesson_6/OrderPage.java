package org.example.lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage{

    public OrderPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (id = "input-option1074_ms")
    private WebElement tipKroya;

    public OrderPage clickTipKroya() {
        tipKroya.click();
        return this;
    }

    @FindBy (xpath = "//span[contains(.,'Юбка-пачка')]")
    private WebElement yubkaPachka;

    public OrderPage ckickYubkaPachka() {
        yubkaPachka.click();
        return this;
    }

    @FindBy (id = "input-option1077_ms")
    private WebElement otdelkaPoyasa;

    public OrderPage clickOtdelkaPoyasa() {
        otdelkaPoyasa.click();
        return this;
    }

    @FindBy (xpath = "//span[contains(.,'пояс на резинке')]")
    private WebElement poyasNaRezinke;

    public OrderPage clickPoyasNaRezinke() {
        poyasNaRezinke.click();
        return this;
    }

    @FindBy (id = "input-option1076_ms")
    private WebElement dlinaYubki;

    public OrderPage clickDlinaYubki() {
        dlinaYubki.click();
        return this;
    }

    @FindBy (xpath = "//label[contains(.,'70 см')]")
    private WebElement sm70;

    public OrderPage click70sm() {
        sm70.click();
        return this;
    }
    @FindBy (id = "input-option1079")
    private WebElement obhvatTalii;

    public OrderPage fillObhvatTalii(String taliya) {
        obhvatTalii.sendKeys(taliya);
        return this;
    }

    @FindBy (id = "input-option1078")
    private WebElement obhvatByeder;

    public OrderPage fillObhvatByeder(String byedra) {
        obhvatByeder.sendKeys(byedra);
        return this;
    }
    @FindBy (xpath = "//a[contains(@class,'ui-spinner-up')]")
    private WebElement dobavitKolichestvo;

    public OrderPage clickDobavitKolichestvo() {
        dobavitKolichestvo.click();
        return this;
    }

    @FindBy (xpath = "//button[text()='Купить']")
    private WebElement kupitButton;

    public KorzinaPage clickKupitButton() {
        kupitButton.click();
        return new KorzinaPage(driver);
    }
}