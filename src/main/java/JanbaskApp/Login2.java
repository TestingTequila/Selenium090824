package JanbaskApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Login
{
    public static void main(String[] args) throws InterruptedException {
        //To verify Login functionality when correct email and correct password in entered
        // 1. Open the browser
        WebDriver driver = new ChromeDriver();//Chrome Browser
        driver.manage().window().maximize();

        // 2. Enter the url
        driver.get("https://janbaskdemo.com/");

        // 3. Click on My Account Icon
        WebElement myAccountIcon=driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        myAccountIcon.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // 4. Click on Login Link
        WebElement loginLink= driver.findElement(By.xpath("//a[text()='Login']"));
        loginLink.click();

        // 5. Enter correct email
       WebElement emailTextBox= driver.findElement(By.xpath("//input[@id='input-email']"));
       emailTextBox.sendKeys("ben.fletcher@janbask.com");

        // 6. Enter correct password
        WebElement passwordTextBox=driver.findElement(By.xpath("//input[@name='password']"));
        passwordTextBox.sendKeys("test@1234");

        // 7. Click on Login Button
        WebElement loginButton= driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        // 8. Validate Login Status
        String currentPageTitle= driver.getTitle();
        if(currentPageTitle.equals("My Account"))
        {
            System.out.println("Login is successful");
        }
        else
        {
            System.out.println("Login Failed....Please check credentials....");
        }
        // 9. Close the browser
        driver.close();
    }

}
