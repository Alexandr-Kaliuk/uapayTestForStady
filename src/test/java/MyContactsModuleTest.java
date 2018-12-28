import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MyContactsModuleTest extends BaseTest {

    @Test
    public void createNewContactTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='loginBlock']//*[contains(@class, 'login')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("0930300179");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("TEST1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[contains(@class, 'userName')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@class='add-contact']")).click();
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("ContactName");
        driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("0630001100");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='contacts__link']")).isDisplayed(), "Contact not exist!");
    }

    @AfterMethod
    public void postCondition() throws InterruptedException {
        driver.findElement(By.xpath("//*[(contains(text(), 'ContactName')) and @class='contacts__name ng-binding']")).click();
        driver.findElement(By.xpath("//*[@ng-click='initialState.confirmState = 1; $event.preventDefault();']")).click();
        driver.findElement(By.xpath("//*[@ng-click='contactForm.removeContact(person.id, $index); $event.preventDefault();']")).click();
        Thread.sleep(3000);
    }
}
