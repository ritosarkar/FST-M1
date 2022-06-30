import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_1 {

    public static void main(String[] args)
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/iframes");

        //print the title of the web page
        System.out.println("Title of the page is: "+driver.getTitle());
        //******Switch to first iframe on the page**********
        driver.switchTo().frame(0);

        //Perform operation on the first frame
        WebElement frameHeading1 = driver.findElement(By.cssSelector("div.content"));
        System.out.println(frameHeading1.getText());

        //Identify button element
        WebElement button=driver.findElement(By.id("actionButton"));
        //Get the button text
        System.out.println("Button text from frame: "+button.getText());
        //Get the back-ground color
        System.out.println("Color code: "+button.getCssValue("background-color"));
        button.click();
        //Get the button text
        System.out.println("After clicking button text from frame: "+button.getText());
        //Get the back-ground color
        System.out.println("After clicking color code: "+button.getCssValue("background-color"));

        //switch back to default content
        driver.switchTo().defaultContent();

        //******Switch to second iframe on the page**********
        WebElement frameElement=driver.findElement(By.xpath("//iframe[contains(@src,'/selenium/frame2')]"));
        //Switch to new frame
        driver.switchTo().frame(frameElement);

        WebElement frameHeading2 = driver.findElement(By.cssSelector("div.content"));
        System.out.println(frameHeading2.getText());


        //Identify button element from second frame
        WebElement button1=driver.findElement(By.id("actionButton"));
        //Get the button text from second frame
        System.out.println("Button text from second frame: "+button1.getText());
        //Get the back-ground color from second frame
        System.out.println("From second frame color code: "+button1.getCssValue("background-color"));
        button1.click();
        //Get the button text from second frame
        System.out.println("After clicking button text from second frame: "+button1.getText());
        //Get the back-ground color from second frame
        System.out.println("From second frame after clicking color code: "+button1.getCssValue("background-color"));

        //switch back to default content
        driver.switchTo().defaultContent();

        driver.quit();



    }
}
