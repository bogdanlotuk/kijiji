package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public Constants constants = new Constants();
    @BeforeClass
    public void BeforeClass(){
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        Configuration.browserSize = "1366x768";
//        System.out.println("BeforeClass started");
    }

    @AfterClass
    public void AfterClass(){
        Selenide.closeWindow();
        WebDriverManager.chromedriver().quit();
        System.out.println("AfterClass started");
    }
}
