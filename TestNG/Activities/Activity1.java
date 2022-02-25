import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass()
    {
        driver=new FirefoxDriver();
        driver.get(" https://www.training-support.net");

    }

    @Test
    public void exampleTest()
    {   //print the title of the page
        System.out.println("Title: "+driver.getTitle());
        //Assert the page for the title
        Assert.assertEquals(driver.getTitle(),"Training Support");
        //Find the clickable link and click on it
        driver.findElement(By.xpath("//*[contains(text(),'About Us')]")).click();
        System.out.println("Title: "+driver.getTitle()); //get the title of the new page
        //Assert the new title
        Assert.assertEquals(driver.getTitle(),"About Training Support");
    }

    @AfterClass
    public void afterTest()
    {
        //close the driver
        driver.quit();
    }

}
