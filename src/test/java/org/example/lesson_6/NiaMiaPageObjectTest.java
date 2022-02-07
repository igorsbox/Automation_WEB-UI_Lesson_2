package org.example.lesson_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NiaMiaPageObjectTest {
    WebDriver driver;
    private final static String NIAMIA_URL = "https://www.niamia.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get(NIAMIA_URL);
    }

    @Test
    void orderCallBackTest() {
        new MainPage(driver).clickLoginButton()
                .fillLogin("test123@test.ru")
                .fillPassword("test123")
                .clickLoginButton()
                .clickCallBack()
                .fillName("Олег")
                .fillPhone("+79161378226")
                .fillComment("Перезвоните, please!")
                .clickSendButton()
                .checkSentCallBack();
    }

    @Test
    void orderProductTest() {
        new MainPage(driver).clickLoginButton()
                .fillLogin("test123@test.ru")
                .fillPassword("test123")
                .clickLoginButton()
                .clickMagazin()
                .clickYubkiSolntseIzFatina()
                .clickTysyachaOkeanov()
                .clickTipKroya()
                .ckickYubkaPachka()
                .clickOtdelkaPoyasa()
                .clickPoyasNaRezinke()
                .clickDlinaYubki()
                .click70sm()
                .fillObhvatTalii("70")
                .fillObhvatByeder("100")
                .clickDobavitKolichestvo()
                .clickKupitButton()
                .clickOformitZakaz()
                .fillComment("СПАСИБО!")
                .clickOformitZakazButton2()
                .checkMadeOrder()
                .clickProdolzhitButton();

    }

    @AfterEach
    void killDriver() {
        driver.quit();
    }
}
