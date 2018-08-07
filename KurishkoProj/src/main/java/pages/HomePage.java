package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage  extends  ParentPage{
    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }
    public boolean isAvatarPresent() {
        try {
            return webDriver.findElement(By.xpath(".//*[@class='pull-left image']//img[@class='img-circle']")).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }
    public boolean isSubmitButtonPresent(){
        try{
            return webDriver.findElement(By.xpath(".//button[@type='submit']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
