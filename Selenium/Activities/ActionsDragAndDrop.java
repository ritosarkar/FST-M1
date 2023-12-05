import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsDragAndDrop {
    public static void main(String[] args)
    {
        WebDriver driver;
        WebElement footBall,dropZone1,dropZone2;
        Actions actions;
        WebDriverWait wait;

        driver=new FirefoxDriver();
        actions=new Actions(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://training-support.net/selenium/drag-drop");
        System.out.println("Page title is: "+driver.getTitle());

        footBall=driver.findElement(By.id("draggable"));
        dropZone1=driver.findElement(By.id("droppable"));
        dropZone2=driver.findElement(By.id("dropzone2"));

        actions.moveToElement(footBall).clickAndHold().dragAndDrop(footBall,dropZone1).release();
        Action action=actions.build();
        action.perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(dropZone1,"background-color"));

        actions.moveToElement(footBall).clickAndHold().dragAndDrop(dropZone1,dropZone2).release();
        action=actions.build();
        action.perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(dropZone1,"background-color"));

        driver.quit();

    }
}
