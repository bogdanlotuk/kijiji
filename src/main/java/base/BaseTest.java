package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public Constants constants = new Constants();
    @BeforeClass
    public void BeforeClass(){
//        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
//        Configuration.browserSize = "1366x768";
//        System.out.println("BeforeClass started");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterClass
    public void AfterClass(){
        Selenide.closeWindow();
        WebDriverManager.chromedriver().quit();
        System.out.println("AfterClass started");
    }
}
