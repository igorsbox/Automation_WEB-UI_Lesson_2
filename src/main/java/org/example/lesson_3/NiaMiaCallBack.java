package org.example.lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NiaMiaCallBack {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://niamia.ru/");
//        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[@href='#account']")).click();
        driver.findElement(By.name("email")).sendKeys("test123@test.ru");
        driver.findElement(By.name("password")).sendKeys("test123");
        driver.findElement(By.xpath("//button[text()='Войти']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Обратный звонок')]")).click();
//        Thread.sleep(1000);
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//placeholder[contains(text(),'Ваше имя']")));
        driver.findElement(By.xpath("//*[@placeholder='* Ваше имя:']")).sendKeys("Наталья Иванова");
        driver.findElement(By.xpath("//*[@placeholder='* Ваш телефон:']")).sendKeys("81234567890");
        driver.findElement(By.xpath("//*[@placeholder='Комментарий: ']")).sendKeys("TeSt");
        driver.findElement(By.xpath("//button[text()='Отправить']"));
        Thread.sleep(2000);
        driver.quit();
    }
}
