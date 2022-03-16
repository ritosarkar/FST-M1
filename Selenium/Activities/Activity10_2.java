import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {

    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);
        WebElement element;

        //Launch URL and get the title
        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println("Page title: "+driver.getTitle());

        //using build patterns then build the actions in an action and perform
        element=driver.findElement(By.id("keyPressed"));
        actions.keyDown(element, Keys.SHIFT).sendKeys("r").keyUp(Keys.SHIFT);
        Action action=actions.build();
        action.perform();
        System.out.println("Pressed key: "+element.getText());

        Action actionSeq=actions
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .build();
        actionSeq.perform();

        System.out.println("Pressed key: "+element.getText());

        driver.quit();
    }
}
