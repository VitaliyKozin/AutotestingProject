package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait20;
    WebDriverWait webDriverWait40;


    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait20 = new WebDriverWait(webDriver, 20);
        webDriverWait40 = new WebDriverWait(webDriver, 40);
    }

    public void enterTextToElement(WebElement webElement, String text){
        try {
            webDriverWait40.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into element");
        } catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement webElement){
        try{
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(webElement));
//            webDriverWait20.until(ExpectedConditions.not(
//                    ExpectedConditions.elementToBeClickable(webElement)));

            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplay(WebElement webElement){
        try{
            boolean state = webElement.isDisplayed();
            logger.info("Element is display - > " + state );
            return state;
        }catch (Exception e){
            logger.info("Element is display - > false");
            return false;
        }
    }




    private void printErrorAndStopTest(Exception e) {

        logger.error("Cannot work with element " + e);
        Assert.fail("Cannot work with element " + e);
    }

    public void setNeededStateToCheckBox(WebElement webElement, String neededState){
        if ("check".equals(neededState) || "uncheck".equals(neededState)){
            if (webElement.isSelected() && "check".equals(neededState)){
                logger.info("CheckBox is already checked");
            } else if (webElement.isSelected() && "uncheck".equals(neededState)){
                clickOnElement(webElement);
                logger.info("CheckBox was unchecked");
            }


        }else {
            logger.error(String.format("%s - is not expected state", neededState));
            Assert.fail(String.format("%s - is not expected state", neededState));
        }
    }


}
