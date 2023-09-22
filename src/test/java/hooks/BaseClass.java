package hooks;

import Drivers.DriverInit;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {
    WebDriver driver;


    @Before
    public void setup(){
        driver = DriverInit.setup();
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
