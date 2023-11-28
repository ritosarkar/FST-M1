import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity8_2 {

    public static void main(String[] args)
    {
        WebDriver driver;
        List<WebElement> rowElements, columnElements,footerEle;
        WebElement table,secondRowColA,secondRowColB;
        WebDriverWait wait;

        driver=new FirefoxDriver();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/selenium/tables");
        table=driver.findElement(By.xpath("//table[@id='sortableTable']"));

        jse.executeScript("arguments[0].scrollIntoView();",table);
        wait.until(ExpectedConditions.visibilityOf(table));

        rowElements=driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        columnElements=driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        footerEle=driver.findElements(By.xpath("//tfoot/tr/th"));
        System.out.println("Table consists of: "+rowElements.size()+" rows and "+columnElements.size()+" columns.");

        secondRowColB=driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row and second column: "+secondRowColB.getText());

        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[1]")).click();
        secondRowColA=driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row and second column: "+secondRowColA.getText());

        for(WebElement element:footerEle)
            System.out.print("<"+element.getText()+"> ");

        System.out.println();

        driver.quit();


    }
}
