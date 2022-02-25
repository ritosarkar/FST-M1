package suiteExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.internal.junit.ArrayAsserts;

public class Activity5 {

    WebDriver driver;

    @BeforeTest (alwaysRun = true)
    public void beforeTest()
    {
        //Instantiate the browser and open the browser
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test(groups = {"HeaderTests","ButtonTests"})
    public void getTitle(){
        //get the title and assert it
        String pageTitle=driver.getTitle();
        Assert.assertEquals(pageTitle,"Target Practice");
    }

    @Test(dependsOnMethods = {"getTitle"}, groups = {"HeaderTests"})
    public void headerTestOne()
    {
        //find the third header and asser the text
        String thirdHeader= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(thirdHeader,"Third header");
    }

    @Test(dependsOnMethods = {"getTitle"}, groups = {"HeaderTests"})
    public void headerTestTwo()
    {
        //Get the color for the 5th header and assert the same
        WebElement headerFive=driver.findElement(By.xpath("//h3"));
        Assert.assertEquals(headerFive.getCssValue("color"),"rgb(251, 189, 8)");
    }

    @Test (dependsOnMethods = {"getTitle"}, groups = {"ButtonTests"})
    public void buttonTestOne()
    {
        //Find the button with the class olive and assert it text.
        WebElement element= driver.findElement(By.xpath("//button[@class='ui olive button']"));
        Assert.assertEquals(element.getText(),"Olive");
    }

    @Test (dependsOnMethods = {"getTitle"}, groups = {"ButtonTests"})
    public void buttonTestTwo()
    {
        //find the first button on third row and assert the color
        WebElement element=driver.findElement(By.cssSelector("button.brown"));
        Assert.assertEquals(element.getCssValue("color"),"rgb(255, 255, 255)");
    }


    @AfterTest (alwaysRun = true)
    public void afterTest()
    {
        //close the browser
        driver.quit();
    }
}
