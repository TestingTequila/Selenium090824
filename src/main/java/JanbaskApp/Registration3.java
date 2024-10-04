package JanbaskApp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration3
{
    public static void main(String[] args) {
        //1. Open The Browser in maximize mode and Enter the url
        WebDriver driver = Utilities.launchBrowser(ApplicationData.BROWSER_NAME);
        CommonActions ca = new CommonActions(driver);

        //3. Click on My Account Icon
        ca.doClickXpath("//i[@class='fa fa-user']");

        //4. Click on Register Link
        ca.doClickXpath("//a[text()='Register']");

        //5. Fill the registration form
        ca.doSendKeysId("input-firstname",ApplicationData.FIRST_NAME );
        ca.doSendKeysName("lastname", ApplicationData.FIRST_NAME);
        ca.doSendKeysId("input-email",ApplicationData.EMAIL_ID );
        ca.doSendKeysName("telephone",ApplicationData.TELEPHONE_NUMBER);
        ca.doSelectValueFromDdlId("input-country", ApplicationData.COUNTRY_TO_SELECT);
        ca.doSendKeysId("input-password", ApplicationData.PASSWORD);
        ca.doSendKeysId("input-confirm",ApplicationData.PASSWORD );
        ca.doClickXpath("//input[@value=1 and @name='newsletter']");
        ca.doSelectValueFromDdlName("subscription",ApplicationData.SUBSCRIPTION_TO_SELECT );

        //6. Click on Privacy Policy checkbox
        ca.doClickName("agree");

        //7. Click on Continue button
        ca.doClickId("submitbtn");

        ca.doWaitImplicit(3);
        //8. Validate Registration Status
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
            //9. Close the browser
            driver.close();
        }



    }
}
