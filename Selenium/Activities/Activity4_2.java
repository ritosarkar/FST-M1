import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

    public static void main(String[] args)
    {
        //Instantiate new firefox browser
        WebDriver driver = new FirefoxDriver();
        //Launch the URL-browser
        driver.get("https://www.training-support.net/selenium/simple-form");
        //Send the first name
        driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]")).sendKeys("Rito");
        //Send the last name
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Sarkar");
        //Send the email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@xyz.com");
        //Send the phone number
        driver.findElement(By.xpath("//input[@id='number']")).sendKeys("9001001910");
        //click on submit
        driver.findElement(By.xpath("//input[@value='submit']")).submit();
        driver.close();

    }
}
