package JanbaskApp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Registration
{
    public static void main(String[] args) {
        //1. Open The Browser in maximize mode
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Enter the url
        driver.get("https://janbaskdemo.com/");

        //3. Click on My Account Icon
        WebElement myAccountIcon=driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        myAccountIcon.click();

        //4. Click on Register Link
        WebElement registerLink= driver.findElement(By.xpath("//a[text()='Register']"));
        registerLink.click();

        //5. Fill the registration form
        WebElement firstNameTextBox= driver.findElement(By.id("input-firstname"));
        firstNameTextBox.sendKeys("Ron");
        WebElement lastNameTextBox= driver.findElement(By.name("lastname"));
        lastNameTextBox.sendKeys("Lincoln");
        WebElement emailTextBox =driver.findElement(By.id("input-email"));
        emailTextBox.sendKeys("ron.lincoln1@janbask.com");
        WebElement telephoneTextBox= driver.findElement(By.name("telephone"));
        telephoneTextBox.sendKeys("545464564");
        WebElement countryDropdown= driver.findElement(By.id("input-country"));
        Select country = new Select(countryDropdown);
        //country.selectByVisibleText("India");
        //country.selectByValue("100");
        //country.selectByIndex(100);
        //The above 3 approaches will work only if dropdown has select tag
        List<WebElement> countries =country.getOptions();
        for(WebElement we: countries)
        {
            String countryText=we.getText();
            if(countryText.equals("India"))
            {
                we.click();
                break;
            }
        }
        WebElement passwordTextBox= driver.findElement(By.id("input-password"));
        passwordTextBox.sendKeys("test@1234");
        WebElement confirmPasswordTextBox= driver.findElement(By.id("input-confirm"));
        confirmPasswordTextBox.sendKeys("test@1234");
        WebElement radioButtonYes= driver.findElement(By.xpath("//input[@value=1 and @name='newsletter']"));
        radioButtonYes.click();
        WebElement subscriptionDropDown = driver.findElement(By.name("subscription"));
        Select subscribe = new Select(subscriptionDropDown);
        List<WebElement> subscribeOptions=  subscribe.getOptions();
        for(WebElement we: subscribeOptions)
        {
           String subscribeOptionText= we.getText();
           if(subscribeOptionText.equals("Monthly"))
           {
               we.click();
           }
        }
//        subscribe.selectByVisibleText("Monthly");
        //6. Click on Privacy Policy checkbox
        WebElement privacyPolicyCheckBox= driver.findElement(By.name("agree"));
        privacyPolicyCheckBox.click();

        //7. Click on Continue button
        WebElement continueButton= driver.findElement(By.id("submitbtn"));
        continueButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
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
