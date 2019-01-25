package loginTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTestWithOutPageObject {
    WebDriver webDriver;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
    }

    @Test
    public void validLogIn(){
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.get("https://eap.gioc.kiev.ua");

        webDriver.findElement(By.name("login")).clear();
        webDriver.findElement(By.name("login")).sendKeys("admin_test");

        webDriver.findElement(By.name("password")).clear();
        webDriver.findElement(By.name("password")).sendKeys("admin_test");

        webDriver.findElement(By.xpath(".//label")).click();

        webDriver.findElement(By.xpath(".//button[@class='ant-btn sc-csuQGl bRwNtx ant-btn-primary']")).click();

       Assert.assertTrue("Avatar is not present",
                isAvatarPresent());
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

   private boolean isAvatarPresent(){
        try {
            return webDriver.findElement(
                    By.xpath(".//*[@class='sc-jlyJG ipjaKa']"))
                    .isDisplayed();
        } catch (Exception e){
                return false;
            }
        }
    }
