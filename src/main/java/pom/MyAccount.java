package pom;

import JanbaskApp.CommonActions;
import org.openqa.selenium.WebDriver;

public class MyAccount
{
    WebDriver driver;
    CommonActions ca;
    public MyAccount(WebDriver driver)
    {
        this.driver = driver;
        ca = new CommonActions(driver);
    }
    public void  validateLoginStatus(String pageTitle)
    {
        ca.validatePageTitle(pageTitle);
    }
}
