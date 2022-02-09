package org.example.lesson_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.example.lesson_7.CustomLogger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.util.Iterator;

public class NiaMiaPageObjectTest {
    WebDriver driver;
    private final static String NIAMIA_URL = "https://www.niamia.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
 //       driver = new ChromeDriver();
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        driver.get(NIAMIA_URL);
    }

    @Test
    @Description("Проверка заказа обратного звонка")
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
                .checkSentCallBack()
                .clickCloseButton()
                .clickOtzyvy();
    }

    @Test
    @Description("Проверка заказа товара")
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
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
 /*       Iterator<LogEntry> iterator = logEntries.iterator();
        while (iterator.hasNext()) {
            Allure.addAttachment("Лог браузера", iterator.next().getMessage());
        }*/

        for (LogEntry log: logEntries) {
            Allure.addAttachment("Лог браузера:", log.getMessage());
        }

        driver.quit();
    }
}
