package stepdefinition;

import Drivers.DriverInit;
import hooks.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.*;

import java.util.Map;

public class Register {
    WebDriver driver;


    @Given("User navigates to Register Account page")
    public void user_navigates_to_register_account_page() {
        driver = DriverInit.getdriver();
        driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
    }
    @When("User enters the details into below fields")
    public void user_enters_the_details_into_below_fields(DataTable dataTable) {
       Map<String, String> datamap =  dataTable.asMap(String.class, String.class);
       driver.findElement(By.id("input-firstname")).sendKeys(datamap.get("firstName"));
       driver.findElement(By.id("input-lastname")).sendKeys(datamap.get("lastName"));
       driver.findElement(By.id("input-email")).sendKeys("abc12345@gmail.com");
       driver.findElement(By.id("input-telephone")).sendKeys(datamap.get("telephone"));
       driver.findElement(By.id("input-password")).sendKeys(datamap.get("password"));
       driver.findElement(By.id("input-confirm")).sendKeys(datamap.get("password"));


    }
    @When("User selects Privacy Policy")
    public void user_selects_privacy_policy() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@name='agree']")).click();
    }
    @When("User clicks on Continue button")
    public void user_clicks_on_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }
    @Then("User account should get created successfully")
    public void user_account_should_get_created_successfully() {
        boolean check = driver.findElement(By.xpath("//div[@id='content']/h1")).isDisplayed();
        Assert.assertTrue(check);
    }

    @When("User selects Yes for Newsletter")
    public void user_selects_yes_for_newsletter() {
        driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
    }

    @When("User enters the details into below fields with duplicate email")
    public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
        Map<String, String> datamap =  dataTable.asMap(String.class, String.class);
        driver.findElement(By.id("input-firstname")).sendKeys(datamap.get("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(datamap.get("lastName"));
        driver.findElement(By.id("input-email")).sendKeys(datamap.get("email"));
        driver.findElement(By.id("input-telephone")).sendKeys(datamap.get("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(datamap.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(datamap.get("password"));

    }
    @Then("User should get a proper warning about duplicate email")
    public void user_should_get_a_proper_warning_about_duplicate_email() {
        boolean flag = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).isDisplayed();
        Assert.assertTrue(flag);
    }

    @When("User dont enter any details into fields")
    public void user_dont_enter_any_details_into_fields() {

    }
    @Then("User should get proper warning messages for every mandatory field")
    public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
        boolean firstNameWarning = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed();
        Assert.assertTrue(firstNameWarning);
        boolean lastNameWarning = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed();
        Assert.assertTrue(lastNameWarning);
        boolean emailWarning = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).isDisplayed();
        Assert.assertTrue(emailWarning);
        boolean telephoneWarning = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed();
        Assert.assertTrue(telephoneWarning);
        boolean passwordWarning = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed();
        Assert.assertTrue(passwordWarning);
    }


}
