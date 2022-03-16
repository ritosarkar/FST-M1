import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_1 {

    public static void main(String[] args)
    {
        WebDriver driver;
        WebElement toggleCheckBox, inputCheckBox ;
        WebDriverWait wait;

        driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        System.out.println("Page title: "+driver.getTitle());

        inputCheckBox=driver.findElement(By.xpath("//input[@type='checkbox']"));
        toggleCheckBox=driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));

        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        toggleCheckBox.click();
        wait.until(ExpectedConditions.invisibilityOf(inputCheckBox));
        System.out.println("Check is visible?: "+inputCheckBox.isDisplayed());

        toggleCheckBox.click();
        wait.until(ExpectedConditions.visibilityOf(inputCheckBox));
        System.out.println("Check is visible?: "+inputCheckBox.isDisplayed());

        driver.quit();

    }
}
