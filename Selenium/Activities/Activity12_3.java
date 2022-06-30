import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Activity12_3 {
    public static void main(String[] args){
        WebDriver driver=new FirefoxDriver();
        String  tooltipText;
        WebElement signInButton, user, password,loginConfirmation;
        driver.get("https://www.training-support.net/selenium/popups");
        Actions actions = new Actions(driver);

        //Find the sign-In button element
        signInButton=driver.findElement(By.cssSelector("button.ui.huge.inverted.orange.button"));
        //Hover over the signIn button
        actions.moveToElement(signInButton).pause(Duration.ofSeconds(1)).build().perform();
        //Get the tool tip text
        tooltipText=signInButton.getAttribute("data-tooltip");
        System.out.println("Tooltip text is :"+tooltipText);
        //Click the button
        signInButton.click();
        //Find the username element enter the username
        user=driver.findElement(By.id("username"));
        user.sendKeys("admin");
        //Find the password element and enter the password
        password=driver.findElement(By.id("password"));
        password.sendKeys("password");
        //Click sign in button
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        //Login confirmation message
        loginConfirmation=driver.findElement(By.id("action-confirmation"));
        System.out.println("Login confirmation message: "+loginConfirmation.getText());

        driver.quit();

    }
}
