package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTestSteps {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @Given("^User is on Login page$")
    public void user_is_on_login_page()  {
       driver = new FirefoxDriver();
       webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
       driver.get("https://www.training-support.net/selenium/login-form");
    }

    @When("^User enters username and password$")
    public void user_enters_username_and_password() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        if (username.isDisplayed() && password.isDisplayed()) {
            username.sendKeys("admin");
            password.sendKeys("password");
        }
        if(driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).isEnabled())
            driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
    }

    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void user_enters_something_and_something(String usernames, String passwords)  {
        WebElement user= driver.findElement(By.id("username"));
        WebElement pwd= driver.findElement(By.id("password"));
        if (user.isDisplayed() && pwd.isDisplayed()) {
            driver.findElement(By.id("username")).sendKeys(usernames);
            pwd.sendKeys(passwords);
        }
        if(driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).isEnabled())
            driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
    }


    @Then("^Read the page title and confirmation message$")
    public void read_the_page_title_and_confirmation_message() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        String confirmation = driver.findElement(By.id("action-confirmation")).getText();
        String title = driver.getTitle();
        System.out.println("Login message: "+confirmation);
        System.out.println("Page title: "+title);
    }

    @And("^Close the Browser$")
    public void close_the_browser()  {
    driver.quit();
    }
}
