package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertTestSteps {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Alert alert;

    @Given("^User is on the page$")
    public void user_is_on_the_page()  {
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");

    }

    @When("^User clicks the Simple Alert button$")
    public void user_clicks_the_simple_alert_button() {
      driver.findElement(By.id("simple")).click();
    }

    @When("^User clicks the Confirm Alert button$")
    public void user_clicks_the_confirm_alert_button() {
        driver.findElement(By.id("confirm")).click();
    }

    @Then("^Alert opens$")
    public void alert_opens()  {
        alert=driver.switchTo().alert();
    }

    @And("^Read the text from it and print it$")
    public void read_the_text_from_it_and_print_it()  {
     String alert_message=alert.getText();
     System.out.println("Alert message is: "+alert_message);
    }

    @And("^Close the alert$")
    public void close_the_alert() {
        alert.accept();
    }

    @When("^Close the alert with Cancel$")
    public void close_the_alert_with_cancel() {
        alert.dismiss();
    }

    @When("^User clicks the Prompt Alert button$")
    public void user_clicks_the_prompt_alert_button() {
        driver.findElement(By.id("prompt")).click();

    }

    @When("^Write a custom message in it$")
    public void write_a_custom_message_in_it()  {
        alert.sendKeys("Custom Message");
    }

    @And("^Close Browser$")
    public void close_browser() {
        driver.quit();
    }
}
