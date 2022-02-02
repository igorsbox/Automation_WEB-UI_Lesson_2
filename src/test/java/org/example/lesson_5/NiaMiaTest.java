package org.example.lesson_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

public class NiaMiaTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String NIAMIA_URL = "https://www.niamia.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(NIAMIA_URL);
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Проверка перехода в раздел Детские юбки")
    void hoverMenuTest() throws InterruptedException {
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.xpath("//a[.='Магазин']")))
                .build()
                .perform();
        driver.findElement(By.xpath("//a[contains(text(),'Детские юбки')]")).click();
        assertTrue(driver.getCurrentUrl().contentEquals("https://niamia.ru/jubki-iz-fatina/detskie-jubki-iz-fatina"));
        Thread.sleep(2000);
    }

    @Test
    @DisplayName("Проверка заказа обратного звонка")
    void orderCallBackTest() throws InterruptedException {
        driver.findElement(By.xpath("//a[.='Обратный звонок']")).click();
        driver.findElement(By.xpath("//input[@placeholder='* Ваше имя:']")).sendKeys("Наталья Иванова");
        driver.findElement(By.xpath("//*[@placeholder='* Ваш телефон:']")).sendKeys("+7 (916) 135-85-25");
        driver.findElement(By.xpath("//*[@placeholder='Комментарий: ']")).sendKeys("TeSt123");
        driver.findElement(By.xpath("//button[text()='Отправить']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.=' Ваше сообщение отправлено.']")));
        assertTrue(driver.findElement(By.xpath("//*[@class='alert alert--green']")).isDisplayed());
        Thread.sleep(1000);
    }

    @Test
    @DisplayName("Проверка оформления Заказа в один клик")
    void orderInOneClick() throws InterruptedException {
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.xpath("//a[.='Магазин']")))
                .pause(java.time.Duration.ofSeconds(1))
                .moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Кружевные топы')]")))
                .click()
                .build()
                .perform();
        actions.moveToElement(driver.findElement(By.xpath("//a[@href='https://niamia.ru/jubki-iz-fatina/kruzhevnye-topy/roskoshnyj-top-s-vyshivkoj-na-setke'][@data-slick-index='2']")))
                .pause(java.time.Duration.ofSeconds(1))
                .moveToElement(driver.findElement(By.xpath("//span[.='Роскошный топ с вышивкой на сетке']")))
                .build()
                .perform();
        driver.findElement(By.xpath("//button[@onclick=\"cart.add('187', '1');\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Выберите')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Выберите')]")).click();
        driver.findElement(By.xpath("//span[.='44\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t']")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'ui-spinner-up')]")).click();
        driver.findElement(By.xpath("//a[.='Купить в один клик']")).click();
//        Thread.sleep(1000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form//h3[.='Купить в один клик']/following-sibling::div//a[.='согласие на обработку персональных данных.']")));
        driver.findElement(By.xpath("//form//h3[.='Купить в один клик']/following-sibling::input[@placeholder='* Имя']")).sendKeys("Василиса");
        driver.findElement(By.xpath("//form//h3[.='Купить в один клик']/following-sibling::input[@placeholder='* Телефон']")).sendKeys("+7 (916) 123-45-67");
        driver.findElement(By.xpath("//form//h3[.='Купить в один клик']/following-sibling::button")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Ваш заказ принят!']")));
        assertTrue(driver.findElement(By.xpath("//h1[.='Ваш заказ принят!']")).isDisplayed());
        Thread.sleep(2000);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
