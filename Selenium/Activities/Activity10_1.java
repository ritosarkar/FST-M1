import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Activity10_1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new FirefoxDriver();
        Actions actions= new Actions(driver);

        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println("Title of the page is: "+driver.getTitle());
        WebElement cube=driver.findElement(By.id("wrapD3Cube"));
        //WebElement cubeVal= driver.findElement(By.className("active"));

        //Left click
        actions.click(cube);
        System.out.println("Left click & value is: "+driver.findElement(By.className("active")).getText());

        //Double click
        actions.doubleClick(cube).perform();
        System.out.println("Double click & value is: "+driver.findElement(By.className("active")).getText());

        //Context click or right click
        actions.contextClick(cube).perform();
        System.out.println("Right click & value is: "+driver.findElement(By.className("active")).getText());

        driver.quit();
    }
}