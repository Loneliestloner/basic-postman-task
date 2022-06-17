import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JumiaWebTest {

    //Import The Selenium Driver
    private WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        //Locate Where The Chrome Driver Is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        //Open Chrome Browser
        driver = new ChromeDriver();

        //Input Your jumia Url
        driver.get("https://www.jumia.com.ng/");
        Thread.sleep(3000);

        //Test 1 Verify Jumia Url
        String expectedurl = "https://www.jumia.com.ng/";
        String actualurl = driver.getCurrentUrl();
        if (actualurl.contains(expectedurl))
            System.out.println("Current Url is:" + expectedurl);
        else
            System.out.println("Wrong Url");

        //Maximmize The Page
        driver.manage().window().maximize();

        //Click On The account Button
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();

        //Click On The Signup Button
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();

        //Locate The Create An Account Via Email
        driver.findElement(By.xpath("//*[@id=\"jm\"]/main/div/div[2]/div/a[1]/span")).click();
        Thread.sleep(500);
    }

    @Test(priority = 0)
    public class testMe {
        public void GetPageTitle() throws InterruptedException {
            //Test 2 Verify The Page Title
            System.out.println("Page Title is:" + driver.getTitle());
            Thread.sleep(2000);
        }

        @Test(priority = 1)
        public void signup() throws InterruptedException {
            //Verify That a User Can Signup Successful With The Right Signup Details
            //Locate The First Name Field And Input Your First Name
            driver.findElement(By.xpath("//*[@id=\"fi-firstName\"]")).sendKeys("eriktan");
            Thread.sleep(500);

            //Locate The Last Name Field And Input Your Last Name
            driver.findElement(By.xpath("//*[@id=\"fi-lastName\"]")).sendKeys("hanny");
            Thread.sleep(500);

            //Locate The Email Field and Input Your Email
            driver.findElement(By.xpath("//*[@id=\"fi-email\"]")).sendKeys("hanny@mailinator.com");
            Thread.sleep(500);

            //Locate The Password Field and Input Password
            driver.findElement(By.xpath("//*[@id=\"fi-password\"]")).sendKeys("Ayoungthug4");
            Thread.sleep(500);

            //Click on The Accept Terms And Conditions Button
            driver.findElement(By.xpath("//*[@id=\"fi-password\"]")).click();
            Thread.sleep(3000);


            //Click On Create Account Button
            driver.findElement(By.xpath("//*[@id=\"authForm\"]/div[7]")).submit();

            //Wait For Success Message
            Thread.sleep(5000);

            //Click On The Account Button
            driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
            Thread.sleep(5000);
        }
        @Test(priority = 2)
        public void logout(){
            //Verify That The Logout Functionality Works
            //Click On Logout
            driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/form")).click();
        }

        @Test(priority = 3)
        public void invalidemail() throws InterruptedException {
            //Click On The account Button
            driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();


            //Click On The Signup Button
            driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();

            //Locate The Create An Account Via Email
            driver.findElement(By.xpath("//*[@id=\"jm\"]/main/div/div[2]/div/a[1]/span")).click();
            Thread.sleep(500);

            //Input A Valid First Name
            driver.findElement(By.xpath("//*[@id=\"fi-firstName\"]")).sendKeys("kidominat");
            Thread.sleep(500);

            //Input a Valid Last Name
            driver.findElement(By.xpath("//*[@id=\"fi-lastName\"]")).sendKeys("zuriat");
            Thread.sleep(500);

            //Input An Invalid Email adress
            driver.findElement(By.xpath("//*[@id=\"fi-email\"]")).sendKeys("snipet.com");
            Thread.sleep(500);

            //Locate The Password Field and Input Password
            driver.findElement(By.xpath("//*[@id=\"fi-password\"]")).sendKeys("Estheris31");
            Thread.sleep(500);

            //Click on The Accept Terms And Conditions Button
            driver.findElement(By.xpath("//*[@id=\"fi-password\"]")).click();
            Thread.sleep(3000);


            //Click On Create Account Button
            driver.findElement(By.xpath("//*[@id=\"authForm\"]/div[7]")).submit();

            //Wait For Success Message
            Thread.sleep(5000);

        }
        @Test(priority = 4)
        public void invalidsignupwithallfieldsblank() throws InterruptedException {
            //Click On The account Button
            driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();


            //Click On The Signup Button
            driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();

            //Locate The Create An Account Via Email
            driver.findElement(By.xpath("//*[@id=\"jm\"]/main/div/div[2]/div/a[1]/span")).click();
            Thread.sleep(500);

            //Input A Valid First Name
            driver.findElement(By.xpath("//*[@id=\"fi-firstName\"]")).sendKeys("");
            Thread.sleep(500);

            //Input a Valid Last Name
            driver.findElement(By.xpath("//*[@id=\"fi-lastName\"]")).sendKeys("");
            Thread.sleep(500);

            //Input An Invalid Email adress
            driver.findElement(By.xpath("//*[@id=\"fi-email\"]")).sendKeys("");
            Thread.sleep(500);

            //Locate The Password Field and Input Password
            driver.findElement(By.xpath("//*[@id=\"fi-password\"]")).sendKeys("");
            Thread.sleep(500);

            //Click on The Accept Terms And Conditions Button
            driver.findElement(By.xpath("//*[@id=\"fi-password\"]")).click();
            Thread.sleep(3000);


            //Click On Create Account Button
            driver.findElement(By.xpath("//*[@id=\"authForm\"]/div[7]")).submit();

            //Wait For Success Message
            Thread.sleep(5000);
        }

        @AfterTest
        public void closebrowser() {
            //Quit The Browser
            driver.quit();
        }

    }
}