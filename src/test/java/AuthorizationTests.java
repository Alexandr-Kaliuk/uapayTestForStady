import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AuthorizationTests {

    @Test
    public void loginToPortalWithCorrectCreds() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://uapay.ua");
        driver.findElement(By.xpath("//*[@id='loginBlock']//*[contains(@class, 'login')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("0637052580");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("80637052580As");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals("Андрей Калюк",
                driver.findElement(By.xpath("//*[contains(@class, 'userName')]")).getText(),
                "Name don't match with expected!");

        driver.close();
        driver.quit();
    }
}
