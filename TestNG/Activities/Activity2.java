
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeClass
    public void getUrl() {
        //create new instance of the driver and open the URL
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");

    }

    @Test
    public void getTitle() {
        //Getting the page title
        String pageTitle = driver.getTitle();
        //asserting the page-test case will pass
        Assert.assertEquals(pageTitle, "Target Practice");
        System.out.println("Title: " + pageTitle);
    }

    @Test
    public void findButton() {
        String findText = driver.findElement(By.xpath("//*[contains(@class,'ui black button')]")).getText();
        //this assertion will fail
        Assert.assertEquals(findText, "Gray");
    }

    @Test(enabled = false)
    public void skipTest()
    {
        System.out.println("This test will be skipped.");
    }
    @Test
    public void aSkipTestException()
    {
        throw new SkipException("Skipping skip test");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
