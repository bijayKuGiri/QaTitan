package Pages;


import Utility.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;


public class Home{

    //private Helper _helper;
    //private String filePath="config.xml";
    private RemoteWebDriver driver;

    public Home(RemoteWebDriver _driver) {

        PageFactory.initElements(_driver,this);
        driver=_driver;
    }
    String active_carousel="//div[@class='cmp-carousel__content']/div[@class='cmp-carousel__item cmp-carousel__item--active']";
    @FindBy(xpath = "//header")
    WebElement header;

    @FindBy(xpath="//a[text()='© 2021 Copyright Unilever']")
    WebElement lnkCopyWrite;

    @FindBy(css="img[title='Magnum Logo']")
    WebElement logo;

    @FindBy(css="button.cmp-carousel__action.cmp-carousel__action--next>span.cmp-carousel__action-icon")
    WebElement carouselNavigateNext;

    @FindBy(css="div.cmp-carousel__content")
    WebElement carouselContent;

    public List<WebElement> getCarouselList(){
        return carouselContent
                .findElements(By.xpath("//div[@class='cmp-carousel__content']/div[contains(@id,'carousel')]"));

    }

    public void verifyRotation(List<WebElement> elements) throws InterruptedException {
        for (int i=0;i<elements.size();i++) {
            WebElement itemSelected=carouselContent.findElement(By.xpath(active_carousel));
            carouselNavigateNext.click();
            Thread.sleep(2000);
            WebElement itemSelected_Current=carouselContent.findElement(By.xpath(active_carousel));
            Assert.assertNotEquals(itemSelected,itemSelected_Current);
        }

    }

    public List<String> getLinktext(){
        List<String> linkTxt=new ArrayList<String>();
        List<WebElement> links=header.findElements(By.tagName("li"));
        for (WebElement var : links){
            linkTxt.add(var.findElement(By.tagName("a")).getAttribute("href"));
        }
        return linkTxt;
    }

    public String getHeader(){
        return driver.getTitle();
    }
    public boolean IsCopyRightExist(){
        return lnkCopyWrite.isDisplayed();
    }
    public boolean IsLogoImageDisplayed(){
        return logo.isDisplayed();
    }
    public void getScreenShot() throws InterruptedException, IOException {
        //WebElement webElement = driver.findElement(By.cssSelector("img[title='Magnum Logo']"));
        System.out.println(logo.getAttribute("src"));
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver,logo);
        ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir") +"Logo.png"));
        Thread.sleep(2000);
    }





}
