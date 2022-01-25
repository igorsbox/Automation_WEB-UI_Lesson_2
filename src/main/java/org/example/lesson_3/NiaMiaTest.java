package org.example.lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NiaMiaTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://niamia.ru/");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@href='#account']")).click();
//      WebElement loginButton = driver.findElement(By.xpath("xpath=//a[@href='#account']"));
//      loginButton.click();
        driver.findElement(By.name("email")).sendKeys("test123@test.ru");
        driver.findElement(By.name("password")).sendKeys("test123");
        driver.findElement(By.xpath("//button[text()='Войти']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Магазин')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Юбки-солнце из фатина')]")).click();
        driver.findElement(By.xpath("//span[contains(.,'Юбка-солнце из фатина Тысяча океанов')]")).click();
        driver.findElement(By.id("input-option1074_ms")).click();
        driver.findElement(By.xpath("//span[contains(.,'Юбка-пачка')]")).click();
        driver.findElement(By.id("input-option1077_ms")).click();
        driver.findElement(By.xpath("//span[contains(.,'пояс с потайной молнией, обтянут фатином')]")).click();
        driver.findElement(By.id("input-option1076_ms")).click();
        driver.findElement(By.xpath("//label[contains(.,'70 см')]")).click();
        driver.findElement(By.id("input-option1079")).sendKeys("100");
        driver.findElement(By.id("input-option1078")).sendKeys("200");
        driver.findElement(By.xpath("//*[@class='ui-spinner-button ui-spinner-up ui-corner-tr']")).click();
        driver.findElement(By.className("ui-spinner-up")).click();
        driver.findElement(By.className("ui-spinner-up")).click();
        driver.findElement(By.xpath("//button[text()='Купить']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Оформить заказ')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Оформить заказ')]")).click();
        driver.findElement(By.id("comment")).sendKeys("TEST");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Оформить заказ')]")));
        driver.findElement(By.className("simplecheckout-button-right")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Продолжить')]")).click();

       driver.quit();
    }
}
