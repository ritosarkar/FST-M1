import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class getWindowHandle {

    public static void main(String[] args){

        WebDriver driver=new FirefoxDriver();
        WebElement clickMeElement;
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(10));
        String windowTwo = null;

        //Launching URL
        driver.get("https://www.training-support.net/selenium/tab-opener");
        System.out.println("Page tile is: "+driver.getTitle());

        //Getting all windows available
        String parentWindow=driver.getWindowHandle();
        System.out.println("Window handle is:"+parentWindow);

        //Click to open new window
        clickMeElement=driver.findElement(By.id("launcher"));
        clickMeElement.click();

        webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windows=driver.getWindowHandles();
        for(String window:windows)
        {
            System.out.println("Window is: "+window);
            if(!(window.equals(parentWindow)))
            {
                windowTwo=window;
                driver.switchTo().window(window);
                webDriverWait.until(ExpectedConditions.titleIs("Newtab"));
            }
        }

        System.out.println("Window title after switching: "+driver.getTitle());
        System.out.println("Window handle after switching: "+driver.getWindowHandle());
        String switchTabText=driver.findElement(By.xpath("//div[contains(text(),'New Tab')]/div")).getText();

        System.out.println("Text is:"+ switchTabText);
        driver.findElement(By.id("actionButton")).click();
        webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(3));
        windows=driver.getWindowHandles();

        for(String window:windows)
        {
            System.out.println("Window is: "+window);
            if(!(window.equals(parentWindow) && window.equals(windowTwo)))
            {
                driver.switchTo().window(window);
                webDriverWait.until(ExpectedConditions.titleIs("Newtab2"));
                System.out.println("Window title after switching: "+driver.getTitle());
                System.out.println("Window handle after switching: "+driver.getWindowHandle());
            }
        }

        driver.quit();
    }
}
