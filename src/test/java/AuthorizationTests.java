import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationTests extends BaseTest {

    @Test
    public void loginToPortalWithCorrectCreds() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='loginBlock']//*[contains(@class, 'login')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("0930300179");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("TEST1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals("Андрей Калюк",
                driver.findElement(By.xpath("//*[contains(@class, 'userName')]")).getText(),
                "Name don't match with expected!");

        Thread.sleep(5000);
    }


    @Test
    public void loginToPortalWithIncorrectCreds() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='loginBlock']//*[contains(@class, 'login')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("0637057777");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("incorrectPass");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals("Неправильний номер телефону або пароль",
                driver.findElement(By.xpath("//*[@ng-if='loginWindow.loginError']")).getText());

        Thread.sleep(5000);
    }
}
