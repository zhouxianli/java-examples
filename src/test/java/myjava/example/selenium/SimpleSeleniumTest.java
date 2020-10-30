package myjava.example.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SimpleSeleniumTest {
    @Test
    public void test10086() {
        // Set Driver environment property or add to PATH
        System.setProperty("webdriver.chrome.driver", "D:\\JavaTools\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            driver.get("http://10086.cn/index_5074.htm");
            WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("#bj_tail > section > div.xuke > span:nth-child(2)")));
            System.out.println(firstResult.getText());
            assertEquals("本网站支持IPv6访问", firstResult.getText());
        } finally {
            driver.quit();
        }
    }
}
