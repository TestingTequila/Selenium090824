package TestNgConcepts;
import org.testng.Assert;
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

    @Test(priority = 3, groups = "sanity", dependsOnGroups = "smoke", alwaysRun = true, enabled = false)
    public void c()
    {
        System.out.println("@Test : This is login function3");
    }
    @Test(priority = 1, enabled = false, groups = "smoke", invocationCount = 10, threadPoolSize = 2)
    public void a()
    {
        System.out.println("@Test : This is login function");
        Assert.fail();
    }

    @Test(priority = 2, groups = "smoke", enabled = false)
    public void b()
    {
        System.out.println("@Test : This is login function2");
    }

    @Test(dataProvider = "getData")
    public void addition(int a, int b, String name)
    {
        int sum = a+b;
        System.out.println("Sum of " +a+  " and " + b +" is " + sum);
        System.out.println("My Name is : " + name);
    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = {{12, 8 , "Jason"}, {7,45, "Kerrie"}, {56, 100, "Ashish"}};
        return data;
    }



    @AfterMethod
    public void removeUrl()
    {
        System.out.println("@AfterMethod :  Remove the url");
    }


    //Order of Execution of TestNG annotations:
    //1. @BeforeSuite
    //2. @BeforeTest
    //3. @BeforeClass
    //4. @BeforeMethod
    //5. @Test
    //6. @AfterMethod
    //7. @AfterClass
    //8. @AfterTest
    //9. @AfterSuite

    //Priority: Negative >Default > Positive
}
