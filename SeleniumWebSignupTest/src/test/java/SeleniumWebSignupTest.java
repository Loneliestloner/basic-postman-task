import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;
public class SeleniumWebSignupTest {
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://selenium-blog.herokuapp.com");
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            System.out.println("correct webpage");
        else
            System.out.println("wrong webpage");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }


    @Test(priority = 0)
    //verify that a user can signup successfully with valid details
    public void PositiveSignup() throws InterruptedException {
        //input username in the username field
        driver.findElement(By.id("user_username")).sendKeys("fggu");
        //input email on the email field
        driver.findElement(By.id("user_email")).sendKeys("g@mailinator.com");
        //input password on the password field
        driver.findElement(By.id("user_password")).sendKeys("rggur");
        //click on the signup button
        driver.findElement(By.id("submit")).click();
        //wait for success message
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void logoutsuccess() throws InterruptedException {
        //Verify that user can logout successfully
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        String expectedtitle = "Alphablog";
        String actualtitle = driver.getTitle();
        if (actualtitle.contains(expectedtitle))
            System.out.println("correct webpage");
        else
            System.out.println("wrong webpage");
        Thread.sleep(5000);

    }

    @Test(priority = 2)
    public void clickuser1item() throws InterruptedException {
        //verify that the alpha blog is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        String expectedTitle = "Alphablog";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle))
            System.out.println("correct webpage");
        else
            System.out.println("wrong webpage");
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void logout() throws InterruptedException {
        //verify User logsout successfully
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a")).click();
        Thread.sleep(5000);
    }


    @Test(priority = 4)
    public void negativeSignup1() throws InterruptedException {
        //User cannot signup with username less than three character
        //Click on the signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Input username in the username field
        driver.findElement(By.id("user_username")).sendKeys("lou");
        //Input an email in the email field
        driver.findElement(By.id("user_email")).sendKeys("iytg@mailinator.com");
        //input a password
        driver.findElement(By.id("user_password")).sendKeys("otryece");
        //Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 5)
    public void negativeSignup3() throws InterruptedException {
        //Verify that user cannot signup with a wrong email field
        //Clear username field
        driver.findElement(By.xpath("user_username")).clear();
        //Input username in the username field
        driver.findElement(By.id("user_username")).sendKeys("lroyne");
        //Clear email field
        driver.findElement(By.xpath("user_username")).clear();
        // Input a wrong email
        driver.findElement(By.id("user_email")).sendKeys("lrau@mail,com");
        //Input a password
        driver.findElement(By.id("user_password")).sendKeys("beyrtnie");
        //Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority =6)
    public void Negativesignup() throws InterruptedException {
        driver.findElement(By.id("user_username")).sendKeys("catrr");
        driver.findElement(By.id("user_email")).sendKeys("aryr@mailinator.com");
        driver.findElement(By.id("user_password")).sendKeys("ir");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }



    @Test(priority = 7)
    public void blankSignup() throws InterruptedException {
        driver.findElement(By.id("user_username")).sendKeys(" ");
        driver.findElement(By.id("user_email")).sendKeys(" ");
        driver.findElement(By.id("user_password")).sendKeys(" ");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }


    @Test(priority =8 )
    public void verifyitem() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        String expectedurl = "https://selenium-blog.herokuapp.com/signup";
        String actualurl = driver.getCurrentUrl();
        if (actualurl.contains(expectedurl))
            System.out.println("correct webpage");
        else
            System.out.println("wrong webpage");
        Thread.sleep(5000);
    }



    @AfterTest
    public void closebrowser(){
        driver.quit();
    }
}