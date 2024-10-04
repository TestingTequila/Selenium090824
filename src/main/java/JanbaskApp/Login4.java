package JanbaskApp;

import org.openqa.selenium.WebDriver;
import pom.AccountLogin;
import pom.MyAccount;
import pom.YourStore;

public class Login4
{
    public static void main(String[] args) throws InterruptedException {

        // 1. Open the browser, maximize it and Enter the url
        WebDriver driver = Utilities.launchBrowser(ApplicationData.BROWSER_NAME);

        // 2. Click on My Account Icon
        YourStore ys = new YourStore(driver);
        ys.clickOnMyAccountIcon();

        // 3. Click on Login Link
        AccountLogin al = ys.clickOnLoginLink();

        // 4. Enter correct email
        al.enterEmailId(ApplicationData.LOGIN_EMAIL_ID);

        // 5. Enter correct password
        al.enterPassword(ApplicationData.LOGIN_PASSWORD);

        // 6. Click on Login Button
        MyAccount ma = al.clickOnLoginButton();

        // 7. Validate Login Status
        ma.validateLoginStatus(ApplicationData.MY_ACCOUNT_PAGE_TITLE);

        // 8. Close the browser
        Utilities.closeBrowser();
    }
}
