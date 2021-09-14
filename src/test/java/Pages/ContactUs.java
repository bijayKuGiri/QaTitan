package Pages;

import Utility.Helper;
import gherkin.lexer.He;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//*[@id='star']")
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

    public boolean isNameErrorDisplay(){
        return lblfirstnameErr.isDisplayed();
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
        txtComments.findElement(By.tagName("textarea")).sendKeys(Comments);
        Helper.scrollUpPage(driver,1);
        Helper.click(driver,chkAgeConfirm.findElement(By.tagName("input")));
        Helper.click(driver,btnSubmit);

//        chkAgeConfirm.findElement(By.tagName("input")).click();
//        btnSubmit.click();
        Thread.sleep(10000);
        //while (lblLoading.isDisplayed()){}

    }

    public boolean VerifySuccessContactUS(){
       return lblConform.isDisplayed();
    }

    public String getMessage(){
        return lblConform.getText();
    }
}
