package JanbaskApp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationWithTestNg
{
    WebDriver driver;
    CommonActions ca;
   @BeforeMethod
    public void launchBrowserAndEnterUrl()
    {
         driver = Utilities.launchBrowser(ApplicationData.BROWSER_NAME);
         ca = new CommonActions(driver);
    }

    @Test
    public  void registration()
   {
    ca.doClickXpath("//i[@class='fa fa-user']");
    ca.doClickXpath("//a[text()='Register']");
    ca.doSendKeysId("input-firstname",ApplicationData.FIRST_NAME );
    ca.doSendKeysName("lastname", ApplicationData.FIRST_NAME);
    ca.doSendKeysId("input-email",ApplicationData.EMAIL_ID );
    ca.doSendKeysName("telephone",ApplicationData.TELEPHONE_NUMBER);
    ca.doSelectValueFromDdlId("input-country", ApplicationData.COUNTRY_TO_SELECT);
    ca.doSendKeysId("input-password", ApplicationData.PASSWORD);
    ca.doSendKeysId("input-confirm",ApplicationData.PASSWORD );
    ca.doClickXpath("//input[@value=1 and @name='newsletter']");
    ca.doSelectValueFromDdlName("subscription",ApplicationData.SUBSCRIPTION_TO_SELECT );
    ca.doClickName("agree");
    ca.doClickId("submitbtn");
    ca.doWaitImplicit(3);

   }
        @AfterMethod
        public void validateRegistrationStatus()
        {
            try {
                WebElement successMessage = driver.findElement(By.xpath("//p[contains(text(), 'Congratulations!')]"));
                String successMessageText= successMessage.getText();
                if(successMessageText.contains("Congratulations"))
                {
                    System.out.println("Registration is successful");
                }
                else
                {
                    System.out.println("Registration Failed....Please check email...");
                }
            }catch (NoSuchElementException e)
            {
                e.printStackTrace();
            }
            finally {
                driver.close();
            }
        }





}
