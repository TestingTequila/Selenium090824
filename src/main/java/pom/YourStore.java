package pom;

import JanbaskApp.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.plaf.basic.BasicComboBoxUI;
import java.time.Duration;

public class YourStore
{
    WebDriver driver;
    CommonActions ca;
   public YourStore(WebDriver driver)
   {
       this.driver=driver;
       ca = new CommonActions(driver);
   }
    public void clickOnMyAccountIcon()
    {
        ca.doClickXpath("//i[@class='fa fa-user']");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public  AccountLogin clickOnLoginLink()
    {
       ca.doClickXpath("//a[text()='Login']");
       return new AccountLogin(driver);
    }
}
