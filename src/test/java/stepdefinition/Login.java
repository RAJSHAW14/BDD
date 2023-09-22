package stepdefinition;

import Drivers.DriverInit;
import hooks.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Login{
    WebDriver driver;



    @Given("User navigates to login page")
    public void User_navigates_to_login_page(){
        driver = DriverInit.getdriver();
        driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
    }

    @When("^User enters valid email address (.+) into email field$")
    public void User_enters_valid_email_address_into_email_field(String emailText) {

        driver.findElement(By.id("input-email")).sendKeys(emailText);

    }

    @And("^User enters valid password (.+) into password field$")
    public void user_enters_valid_password_into_password_field(String passwordText) {

        driver.findElement(By.id("input-password")).sendKeys(passwordText);

    }

    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {

        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in(){
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'My Account')]")).isDisplayed());
    }

    @When("User enters invalid email address into email field")
    public void user_enters_invalid_email_address_into_email_field() {
        driver.findElement(By.id("input-email")).sendKeys("emailText");
    }
    @When("User enters invalid password {string} into password field")
    public void user_enters_invalid_password_into_password_field(String passwordText) {
        driver.findElement(By.id("input-password")).sendKeys(passwordText);
    }
    @Then("User should get a proper warning message about credentials mismatch")
    public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
       boolean error = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed();
       Assert.assertTrue(error);
    }

    @When("User dont enter email address into email field")
    public void user_dont_enter_email_address_into_email_field() {

    }
    @When("User dont enter password into password field")
    public void user_dont_enter_password_into_password_field() {

    }

}
