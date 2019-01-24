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

    @Before  //анатация. метод/данные , junit
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
    }

    @Test
    public void validLogIn() {
        webDriver.manage().window().maximize();  // драйвер сделай окошко максимальтым
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  //implicitlyWait - неявное ожидание  / 30 - секунд
        webDriver.get("http://v3.test.itpmgroup.com");  //открой нам этот Урл...

        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("Student");

        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("909090");

        webDriver.findElement(By.tagName("button")).click();

        Assert.assertTrue("Avatar is not present", isAvatarPresent());  //если всё ок - просто проходит дальше, если проло - то мессадж
    }

    @After  //выполняется в любом случаи, не зависит от +/- результата.
    public void tearDown() {
        webDriver.quit(); //закрывает полность брайзер, close - закрівает только вкладку
    }

    private boolean isAvatarPresent() {
        try {
            return webDriver.findElement(
                    By.xpath(".//section//div//img[@alt='Student']"))
                //    By.xpath(".//*[@class='pull-left image']//img[@class='img-circle']"))
                    .isDisplayed();   //есть ли аватар (показан)
        } catch (Exception e) {
            return false;
        }
    }
}
