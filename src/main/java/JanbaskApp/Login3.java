package JanbaskApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login3
{
    public static void main(String[] args) throws InterruptedException {

        // 1. Open the browser, maximize it and Enter the url
        WebDriver driver = Utilities.launchBrowser(ApplicationData.BROWSER_NAME);

        CommonActions ca = new CommonActions(driver);

        // 2. Click on My Account Icon
        ca.doClickXpath("//i[@class='fa fa-user']");
        ca.doWaitImplicit(5);

        // 3. Click on Login Link
        ca.doClickXpath("//a[text()='Login']");

        // 4. Enter correct email
        ca.doSendKeysXpath("//input[@id='input-email']", ApplicationData.LOGIN_EMAIL_ID);

        // 5. Enter correct password
        ca.doSendKeysXpath("//input[@name='password']", ApplicationData.LOGIN_PASSWORD);

        // 6. Click on Login Button
        ca.doClickXpath("//input[@type='submit']");

        // 7. Validate Login Status
        ca.validatePageTitle("My Account");
        // 8. Close the browser
        driver.close();
    }
}
