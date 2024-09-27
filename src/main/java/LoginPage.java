import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginPage
{
    public static void main(String[] args) {
        //To validate login feature when correct email and correct password is entered
        //Steps
        // 1- Open the browser
        WebDriver driver = new EdgeDriver();
        // 2- Enter the url
        driver.get("https://www.facebook.com/");

        // 3- Enter correct email
       WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='email']"));
       emailTextBox.sendKeys("ben.fletcher@janbask.com");

        // 4- Enter correct password
        WebElement passwordTextBox=driver.findElement(By.xpath("//input[@id='pass']"));
        passwordTextBox.sendKeys("test@1234");

        // 5- Click on Login button
        WebElement loginButton=driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        // 6- Validate Login Status
        WebElement errorMessage = driver.findElement(By.xpath("//a[contains(text(), 'Find your account and log in.')]"));
        String errorMessageText= errorMessage.getText();
        if(errorMessageText.equals("Login Successful"))
        {
            System.out.println(" Login is successful");
        }
        else
        {
            System.out.println("Login Failed: " + errorMessageText);
        }

        // 7- Close the browser
        driver.close();
    }

}
