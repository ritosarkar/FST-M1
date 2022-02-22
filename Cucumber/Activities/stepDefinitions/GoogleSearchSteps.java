package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchSteps {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @Given("^User is on Google Home Page$")
    public void user_is_on_google_home_page() {
        driver = new FirefoxDriver();
        webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
    }

    @When("^User types in Cheese and hits enter$")
    public void user_types_in_cheese_and_hits_enter() {
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Cheese", Keys.ENTER);

    }

    @Then("^Show how many search results were shown$")
    public void show_how_many_search_results_were_shown() {
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
    String stats=driver.findElement(By.id("result-stats")).getText();
    System.out.println("Search statistics: "+stats);
    }

    @And("^Close the browser$")
    public void close_the_browser()  {
    driver.quit();
    }
}
