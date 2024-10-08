package JanbaskApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Login2
{
    public static void main(String[] args) throws InterruptedException {


        //To verify Login functionality when correct email and correct password in entered
        // 1. Open the browser
        WebDriver driver = new ChromeDriver();//Chrome Browser
        driver.manage().window().maximize();

        CommonActions ca = new CommonActions(driver);

        // 2. Enter the url
        driver.get("https://janbaskdemo.com/");

        // 3. Click on My Account Icon
        ca.doClickXpath("//i[@class='fa fa-user']");
        ca.doWaitImplicit(5);

        // 4. Click on Login Link
        ca.doClickXpath("//a[text()='Login']");

        // 5. Enter correct email
        ca.doSendKeysXpath("//input[@id='input-email']", ApplicationData.LOGIN_EMAIL_ID);

        // 6. Enter correct password
        ca.doSendKeysXpath("//input[@name='password']", ApplicationData.LOGIN_PASSWORD);

        // 7. Click on Login Button
        ca.doClickXpath("//input[@type='submit']");

        // 8. Validate Login Status
        ca.validatePageTitle("My Account");
        // 9. Close the browser
        driver.close();
    }

}
