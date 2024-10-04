package TestNgConcepts;
import org.testng.annotations.*;

public class LearningTestNgAnnotations
{
    @BeforeSuite
    public void checkSystemStability()
    {
        System.out.println("@BeforeSuite : Check System Stability");
    }

    @AfterSuite
    public void UnCheckSystemStability()
    {
        System.out.println("@AfterSuite : Un-Check System Stability");
    }
    @BeforeTest
    public  void checkTheRAM()
    {
        System.out.println("@BeforeTest: Checking the RAM of system...");
    }

    @AfterTest
    public  void unCheckTheRAM()
    {
        System.out.println("@AfterTest : Un-Checking the RAM of system...");
    }
    @BeforeClass
    public void openTheBrowser()
    {
        System.out.println("@BeforeClass : Open the browser");
    }

    @AfterClass
    public void closeTheBrowser()
    {
        System.out.println("@AfterClass : Close the browser");
    }
    @BeforeMethod
    public void enterUrl()
    {
        System.out.println("@BeforeMethod : Enter the url");
    }
    @Test
    public void login()
    {
        System.out.println("@Test : This is login function");
    }

    @Test
    public void login2()
    {
        System.out.println("@Test : This is login function2");
    }

    @Test
    public void login3()
    {
        System.out.println("@Test : This is login function3");
    }

    @AfterMethod
    public void removeUrl()
    {
        System.out.println("@AfterMethod :  Remove the url");
    }

}
