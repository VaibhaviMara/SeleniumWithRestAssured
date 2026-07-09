package Swagger.POMPackage;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static TakesScreenshot screenshot;
    private static Actions actions;



    static{
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        screenshot = (TakesScreenshot) driver;
        actions = new Actions(driver);
    }

    public WebDriver getDriver(){return driver;}

    public static WebDriverWait getWait() {return wait;}

    public static TakesScreenshot getScreenshot() {return screenshot;}

    public static Actions getActions() {return actions;}
}



