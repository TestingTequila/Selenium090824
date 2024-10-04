package JanBaskAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Utilities
{
    static WebDriver driver;
    public static WebDriver launchBrowser(String browserName)
    {


        if(browserName.equals("Chrome"))
        {
             driver = new ChromeDriver();
        }
        else if (browserName.equals("Edge"))
        {
             driver = new EdgeDriver();
        }
        else if (browserName.equals("Firefox"))
        {
             driver = new FirefoxDriver();
        }
        else
        {
             driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://janbaskdemo.com/");
        return driver;
    }

    public static void closeBrowser()
    {
        driver.close();
    }
}
