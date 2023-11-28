import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class visibilityOf_Scenario {

    public static void main(String[] args)
    {
        String user="RitoSarkar";
        String pass="password";
        String emailId="rito.sarkar@ibm.com";

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-attributes");

        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("Page title is: "+driver.getTitle());
        WebElement userName, password, confirmPassword, email, signUpSuccess;

        userName=driver.findElement(By.xpath("//input[contains(@class, '-username')]"));
        userName.sendKeys(user);

        password=driver.findElement(By.xpath("//input[contains(@class, '-password')]"));
        password.sendKeys(pass);

        confirmPassword=driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following::input"));
        confirmPassword.sendKeys(pass);

        email=driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys(emailId);

        driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();

        signUpSuccess=driver.findElement(By.id("action-confirmation"));
        webDriverWait.until(ExpectedConditions.visibilityOf(signUpSuccess));
        System.out.println(signUpSuccess.getText());

        driver.close();






    }
}
