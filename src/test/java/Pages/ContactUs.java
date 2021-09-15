package Pages;

import Utility.Helper;
import gherkin.lexer.He;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class ContactUs extends Helper {
    private RemoteWebDriver driver;

    public ContactUs(RemoteWebDriver _driver) {

        PageFactory.initElements(_driver,this);
        driver=_driver;
    }

    @FindBy(css = "#contactUs-inquiryType[name='enquirySubj']")
    WebElement selectSubject;

    @FindBy(css = "#contactUs-inquiryType[name='enquiryType']")
    WebElement selectReason;

    @FindBy(css = "#givenNameContainer")
    WebElement txtName;
    @FindBy(css = "#familyNameContainer")
    WebElement txtLastName;
    @FindBy(css = "#emailContainer")
    WebElement txtEmail;
    @FindBy(css = "#commentsContainer")
    WebElement txtComments;

    @FindBy(css = "#contact-legalAgeConfirmationContainer")
    WebElement chkAgeConfirm;

    @FindBy(css = "#submitButton[type='submit']")
    WebElement btnSubmit;

    @FindBy(css = "svg#star.loadingIcon")
    WebElement lblLoading;

    @FindBy(css = "div.clearfix.component.formElementV2")
    WebElement lblConform;


    @FindBy(xpath = "//div[@class='clearfix component formElementV2']//span")
    WebElement lblConformMsg;

    @FindBy(css = "#firstName_Err>p")
    WebElement lblfirstnameErr;

    @FindBy(css = "#lastName_Err>p")
    WebElement lblLastnameErr;

    @FindBy(css = "#email_Err>p")
    WebElement lblemailErr;

    @FindBy(css = "#commentError>p")
    WebElement lblCommentErr;

    @FindBy(css = "#legalAgeConfirmation_Err>p")
    WebElement lbllegalConfErr;

    @FindBy(xpath="//p[@class='small']/a[2]")
    WebElement lnkTermsOfUse;

    @FindBy(xpath="//p[@class='small']/a[1]")
    WebElement lnkPrivacyNotice;

    @FindBy(xpath="//p[@class='small']/a[3]")
    WebElement lnkCookiesNotice;
    @FindBy(css="p.small")
    WebElement lblBottom;

    public boolean isNameErrorDisplay(){
        return lblfirstnameErr.isDisplayed();
    }
    public boolean isLegalAgeErrorDisplay(){
        return lbllegalConfErr.isDisplayed();
    }
    public boolean isLastNameErrorDisplay(){
        return lblLastnameErr.isDisplayed();
    }
    public boolean isEmailErrorDisplay(){
        return lblemailErr.isDisplayed();
    }
    public boolean isCommentErrorDisplay(){
        return lblCommentErr.isDisplayed();
    }
    public void SelectReason(String reason){
        Helper.selectFromDDn(reason,selectReason);
    }

    public void SelectSubject(String subject){
        Helper.selectFromDDn(subject,selectSubject);
    }

    public void enterNameEmailAndComments(String name,String lastName, String email, String Comments) throws InterruptedException {
        Helper.scrollDownPage(driver,1);
        txtName.findElement(By.tagName("input")).sendKeys(name);
        txtLastName.findElement(By.tagName("input")).sendKeys(lastName);
        txtEmail.findElement(By.tagName("input")).sendKeys(email);
        if(!Comments.trim().isEmpty())
            txtComments.findElement(By.tagName("textarea")).sendKeys(Comments);
        Helper.scrollUpPage(driver,1);
        Helper.downKeyOnPage(driver,2);
        if(Comments.trim().isEmpty()) {
            btnSubmit.submit();
        }
        else {
            Helper.click(driver, chkAgeConfirm.findElement(By.tagName("input")));
            Helper.click(driver, btnSubmit);
        }
        while (driver.findElements(By.cssSelector("svg#star.loadingIcon")).size()>0){}
        Thread.sleep(1000);

    }

    public boolean VerifySuccessContactUS(){
       return lblConform.isDisplayed();
    }

    public String getMessage(){
        return lblConform.getText();
    }

    public RemoteWebDriver navTermsOfUse() throws InterruptedException {

        Helper.scrollDownPage(driver,3);
        //Helper.click(driver,lnkTermsOfUse);
        WebElement element=lblBottom.findElement(By.cssSelector("a:nth-of-type(2)"));
        while (!element.isDisplayed()){
            Helper.downKeyOnPage(driver,1);
        }
        Helper.click(driver,element);
        //lnkTermsOfUse.click();
        Thread.sleep(5000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return driver;
    }
    public boolean IsNavigateTermsOfUse(RemoteWebDriver driver) {
        System.out.println(driver.getCurrentUrl());
        System.out.println("https://www.unilever.com.br/legal/");
        return driver.getCurrentUrl().contains("https://www.unilever.com.br/legal/");
    }

    public RemoteWebDriver navPrivacyNotice() throws InterruptedException {
//        Helper.click(driver,lnkPrivacyNotice);
        Helper.scrollDownPage(driver,3);
        WebElement element=lblBottom.findElement(By.cssSelector("a:nth-of-type(1)"));
        while (!element.isDisplayed()){
            Helper.downKeyOnPage(driver,2);
        }
        Helper.click(driver,element);
        //lnkPrivacyNotice.click();
        Thread.sleep(2000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return driver;
    }
    public boolean IsNavigatePrivacyNotice(RemoteWebDriver driver) {
        System.out.println(driver.getCurrentUrl());
        System.out.println("https://www.unilevernotices.com/brazil/portuguese/privacy-notice/notice.html");
        return driver.getCurrentUrl().contains("https://www.unilevernotices.com/brazil/portuguese/privacy-notice/notice.html");
    }

    public RemoteWebDriver navCookiesNotice() throws InterruptedException {
        Helper.scrollDownPage(driver,3);
        //Helper.click(driver,lnkCookiesNotice);
        //lnkCookiesNotice.click();
        WebElement element=lblBottom.findElement(By.cssSelector("a:nth-of-type(3)"));
        while (!element.isDisplayed()){
            Helper.downKeyOnPage(driver,1);
        }
        Helper.click(driver,element);
        Thread.sleep(2000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return driver;
    }
    public boolean IsNavigateCookiesNotice(RemoteWebDriver driver) {
        System.out.println(driver.getCurrentUrl());
        System.out.println("https://www.unilevernotices.com/brazil/portuguese/cookie-notice/notice.html");
        return driver.getCurrentUrl().contains("https://www.unilevernotices.com/brazil/portuguese/cookie-notice/notice.html");
    }
}
