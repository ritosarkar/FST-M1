import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_2 {

    public static void main(String[] args){
        WebDriver driver= new FirefoxDriver();
        String pageTitle;
        WebElement defaultFrame,frame1,frameOneHeading,frame2, frameTwoHeading;
        driver.get("https://www.training-support.net/selenium/nested-iframes");
        //Get the page title
        pageTitle=driver.getTitle();
        //Print the page title
        System.out.println("Page title is: "+pageTitle);

        //Traverse into the first frame
        defaultFrame=driver.findElement(By.xpath("//iframe[contains(@src,'iframe1')]"));
        driver.switchTo().frame(defaultFrame);

        System.out.println("<<<window value: "+driver.getWindowHandle()+" >>>.");

        //Traverse into the first iframe in that frame
        frame1=driver.findElement(By.xpath("//iframe[contains(@src,'/selenium/frame1')]"));
        driver.switchTo().frame(frame1);
        //Get the heading of the first frame
        frameOneHeading=driver.findElement(By.cssSelector("div.content"));
        System.out.println("Heading of the first frame: "+frameOneHeading.getText());

        //Traversing from the starting
        driver.switchTo().defaultContent();
        System.out.println("<<<window value: "+driver.getWindowHandle()+" >>>.");
        driver.switchTo().frame(0);
        System.out.println("<<<window value: "+driver.getWindowHandle()+" >>>.");


        //Traverse into the second frame
        frame2=driver.findElement(By.xpath("//iframe[contains(@src,'/selenium/frame2')]"));
        driver.switchTo().frame(frame2);
        System.out.println("<<<window value: "+driver.getWindowHandle()+" >>>.");
        //Get the heading of the second frame
        frameTwoHeading=driver.findElement(By.cssSelector("div.content"));
        System.out.println("Heading of the second frame: "+frameTwoHeading.getText());

        driver.quit();


    }
}
