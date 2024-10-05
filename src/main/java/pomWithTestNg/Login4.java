package pomWithTestNg;

import JanBaskAutomation.ApplicationData;
import JanBaskAutomation.Utilities;
import JanbaskApp.CommonActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.AccountLogin;
import pom.MyAccount;
import pom.YourStore;

import java.time.Duration;

public class Login4
{

    WebDriver driver;
    CommonActions ca;
    @BeforeMethod
    public void launchBrowserAndEnterUrl()
    {
        driver = Utilities.launchBrowser(ApplicationData.BROWSER_NAME);
        ca = new CommonActions(driver);
    }

    @Test(priority = 4, enabled = false)
    public void loginWithValidCredentials()
    {
        YourStore ys = new YourStore(driver);
        ys.clickOnMyAccountIcon();

        AccountLogin al = ys.clickOnLoginLink();

        al.enterEmailId(ApplicationData.LOGIN_EMAIL_ID);

        al.enterPassword(ApplicationData.LOGIN_PASSWORD);

        MyAccount ma = al.clickOnLoginButton();

        ma.validateLoginStatus(ApplicationData.MY_ACCOUNT_PAGE_TITLE);
    }

    @Test(priority = 4, dataProvider = "getData")
    public void loginWithDataProviderCredentials(String emailId, String password)
    {
        YourStore ys = new YourStore(driver);
        ys.clickOnMyAccountIcon();

        AccountLogin al = ys.clickOnLoginLink();

        al.enterEmailId(emailId);

        al.enterPassword(password);

        MyAccount ma = al.clickOnLoginButton();

        ma.validateLoginStatus(ApplicationData.MY_ACCOUNT_PAGE_TITLE);
    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = {{"ben.fletcher@janbask.com","test@1234"}, {"kerrie.wright@gmail.com","test@1234"}, {"forest.grump@janbask.com","test@1234"}};
        return data;
    }
    @Test(priority = 3, groups = "sanity", enabled = false)
    public void loginWithInvalidCredentials()
    {
        YourStore ys = new YourStore(driver);
        ys.clickOnMyAccountIcon();

        AccountLogin al = ys.clickOnLoginLink();

        al.enterEmailId(ApplicationData.LOGIN_INVALID_EMAIL_ID);

        al.enterPassword(ApplicationData.LOGIN_PASSWORD);

        MyAccount ma = al.clickOnLoginButton();

        ma.validateLoginStatus(ApplicationData.MY_ACCOUNT_PAGE_TITLE);
    }

    @Test(priority = 2, enabled = false, groups = "smoke")
    public void loginWithNoCredentials()
    {
        YourStore ys = new YourStore(driver);
        ys.clickOnMyAccountIcon();

        AccountLogin al = ys.clickOnLoginLink();

        al.enterEmailId(ApplicationData.LOGIN_NO_EMAIL_ID);

        al.enterPassword(ApplicationData.LOGIN_PASSWORD);

        MyAccount ma = al.clickOnLoginButton();

        ma.validateLoginStatus(ApplicationData.MY_ACCOUNT_PAGE_TITLE);
    }

    @Test(priority = 1, groups = "smoke", enabled = false)
    public  void registration()
    {
        ca.doClickXpath("//i[@class='fa fa-user']");
        ca.doClickXpath("//a[text()='Register']");
        ca.doSendKeysId("input-firstname", JanbaskApp.ApplicationData.FIRST_NAME );
        ca.doSendKeysName("lastname", JanbaskApp.ApplicationData.FIRST_NAME);
        ca.doSendKeysId("input-email", JanbaskApp.ApplicationData.EMAIL_ID );
        ca.doSendKeysName("telephone", JanbaskApp.ApplicationData.TELEPHONE_NUMBER);
        ca.doSelectValueFromDdlId("input-country", JanbaskApp.ApplicationData.COUNTRY_TO_SELECT);
        ca.doSendKeysId("input-password", JanbaskApp.ApplicationData.PASSWORD);
        ca.doSendKeysId("input-confirm", JanbaskApp.ApplicationData.PASSWORD );
        ca.doClickXpath("//input[@value=1 and @name='newsletter']");
        ca.doSelectValueFromDdlName("subscription", JanbaskApp.ApplicationData.SUBSCRIPTION_TO_SELECT );
        ca.doClickName("agree");
        ca.doClickId("submitbtn");
        ca.doWaitImplicit(3);
        Assert.fail();
    }

    @AfterMethod
    public void closeBrowser()
    {
        Utilities.closeBrowser();
    }

}
