package Drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverInit {
    static WebDriver driver = null;
    public static WebDriver setup(){
        driver = new EdgeDriver();
        WebDriverManager.edgedriver().setup();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getdriver(){
        return driver;
    }
}
