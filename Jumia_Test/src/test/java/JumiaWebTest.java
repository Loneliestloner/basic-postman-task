import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class JumiaWebTest {

    //Import The Selenium Driver
    private WebDriver driver;

    @Test
    public void setup() throws InterruptedException {
        //Locate Where The Chrome Driver Is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        //Open Chrome Browser
        driver = new ChromeDriver();

        //Input Your jumia Url
        driver.get("https://www.jumia.com.ng/");
        Thread.sleep(3000);

        //Maximmize The Page
        driver.manage().window().maximize();

        //Click On The account Button
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();

        //Click On The Signup Button
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();

        //Locate The Create An Account Via Email
        driver.findElement(By.xpath("//*[@id=\"jm\"]/main/div/div[2]/div/a[1]/span")).click();
        Thread.sleep(500);

        //Locate The First Name Field And Input Your First Name
        driver.findElement(By.xpath("//*[@id=\"fi-firstName\"]")).sendKeys("kodakblack");
        Thread.sleep(500);

        //Locate The Last Name Field And Input Your Last Name
        driver.findElement(By.xpath("//*[@id=\"fi-lastName\"]")).sendKeys("sniper");
        Thread.sleep(500);

        //Locate The Email Field and Input Your Email
        driver.findElement(By.xpath("//*[@id=\"fi-email\"]")).sendKeys("sniper@mailinator.com");
        Thread.sleep(500);

        //Locate The Password Field and Input Password
        driver.findElement(By.xpath("//*[@id=\"fi-password\"]")).sendKeys("kodackblackis3");
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

        //Click On Logout
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/form")).click();
    }
    @AfterTest
    public void closebrowser(){
        //Quit The Browser
        driver.quit();
    }

}