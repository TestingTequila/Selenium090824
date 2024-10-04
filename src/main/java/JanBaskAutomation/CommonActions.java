package JanBaskAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class CommonActions
{
    WebDriver driver; //Chrome

    public  CommonActions(WebDriver driver)
    {
        this.driver = driver;
    }
    public WebElement doGetWebElementByXpath(String xpath)
    {
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement doGetWebElementById(String id)
    {
        return driver.findElement(By.id(id));
    }

    public WebElement doGetWebElementByName(String name)
    {
        return driver.findElement(By.name(name));
    }
    public  void doClickXpath(String xpath)
    {
        doGetWebElementByXpath(xpath).click();
    }

    public  void doClickId(String id)
    {
        doGetWebElementById(id).click();
    }

    public  void doClickName(String name)
    {
        doGetWebElementByName(name).click();
    }

    public  void doSendKeysXpath(String xpath, String text)
    {
        doGetWebElementByXpath(xpath).sendKeys(text);
    }

    public  void doSendKeysName(String name, String text)
    {
        doGetWebElementByName(name).sendKeys(text);
    }

    public  void doSendKeysId(String id, String text)
    {
        doGetWebElementById(id).sendKeys(text);
    }

    public  void validatePageTitle(String PageTitle)
    {
        String currentPageTitle= driver.getTitle();
        if(currentPageTitle.equals(PageTitle))
        {
            System.out.println(ApplicationData.SUCCESS_LOGIN_MESSAGE);
        }
        else
        {
            System.out.println(ApplicationData.FAIL_LOGIN_MESSAGE);
        }
    }

    public void doWaitImplicit(int time)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }
    
    public void doSelectValueFromDdlId(String id, String valueToSelect)
    {
        Select s = new Select(doGetWebElementById(id));
        List<WebElement> list =s.getOptions();
        for(WebElement we: list)
        {
            String text=we.getText();
            if(text.equals(valueToSelect))
            {
                we.click();
                break;
            }
        }
    }

    public void doSelectValueFromDdlName(String name, String valueToSelect)
    {
        Select s = new Select(doGetWebElementByName(name));
        List<WebElement> list =s.getOptions();
        for(WebElement we: list)
        {
            String text=we.getText();
            if(text.equals(valueToSelect))
            {
                we.click();
                break;
            }
        }
    }

    public void doSelectValueFromDdlXpath(String Xpath, String valueToSelect)
    {
        Select s = new Select(doGetWebElementByXpath(Xpath));
        List<WebElement> list =s.getOptions();
        for(WebElement we: list)
        {
            String text=we.getText();
            if(text.equals(valueToSelect))
            {
                we.click();
                break;
            }
        }
    }
}
