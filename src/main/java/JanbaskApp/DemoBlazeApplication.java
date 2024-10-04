package JanbaskApp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoBlazeApplication
{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        WebElement loginLink= driver.findElement(By.id("login2"));
        loginLink.click();
        //(a): Wait Approach
        //1. Thread.sleep(time); // Java
        //2. Implicit Wait // diver.manage.timeOut().implicitWait(time);
        //3. Explicit Wait
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        //4. Fluent Wait

        //(b) //JS approach
        WebElement emailTextBox= driver.findElement(By.id("loginusername"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].value='jason.roger@demoblaze.com';",emailTextBox );

        driver.findElement(By.id("loginpassword")).sendKeys("test@1234");

    }
}
