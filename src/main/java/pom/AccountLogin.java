package pom;

import JanbaskApp.CommonActions;
import org.openqa.selenium.WebDriver;

public class AccountLogin
{
    WebDriver driver;
    CommonActions ca;
    public  AccountLogin(WebDriver driver)
    {
        this.driver=driver;
        ca= new CommonActions(driver);
    }
    public void enterEmailId(String emailId)
    {
        ca.doSendKeysXpath("//input[@id='input-email']", emailId);
    }

    public void enterPassword(String password)
    {
        ca.doSendKeysXpath("//input[@name='password']", password);
    }

    public  MyAccount clickOnLoginButton()
    {
         ca.doClickXpath("//input[@type='submit']");
         return new MyAccount(driver);
    }
}
