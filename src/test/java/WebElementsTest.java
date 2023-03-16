import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions.*;

import java.sql.Driver;
import java.util.List;


public class WebElementsTest {
    WebDriver driver;

    public WebElementsTest(){
        System.setProperty("webdriver.chrome.driver","C:/Users/zuram/Documents/cu/Test Automation/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @Test
    public void WebElementsTest1() throws InterruptedException {



        driver.navigate().to("http://the-internet.herokuapp.com/dynamic_controls");
        System.out.println("Page Title Is:" + driver.getTitle());
        System.out.println(driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).isEnabled());
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        Thread.sleep(5000);
        System.out.println("Button Text Is: "+driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).getText());
        System.out.println("Message Text Is: "+driver.findElement(By.xpath("//p[@id='message']")).getText());





    }
    @Test
    public void WebElementsTest2() throws InterruptedException{
        System.out.println("///////////////////////////////TEST2//////////////////////////////////////////////////////");
        driver.navigate().to("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        System.out.println("Last Button Text is: "+driver.findElement(By.cssSelector("button[class='added-manually']:last-of-type")).getText());
        System.out.println("Added Element Count is: "+driver.findElements(By.xpath("//button[@class='added-manually']")).size());
        driver.findElement(By.xpath("//*[contains(@class,'added')]")).click();
        System.out.println("Element Count is: "+driver.findElements(By.xpath("//button[@class='added-manually']")).size());
    }


}
