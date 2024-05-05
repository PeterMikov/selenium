package org.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Getter
@Setter
public class BaseTest {

    public WebDriver driver;
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
