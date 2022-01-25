package org.example.lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("user-agent=googlebot/2.1 (+http://www.google.com/bot.html)");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://google.com");
        Thread.sleep(5000);
        driver.quit();
    }



}
