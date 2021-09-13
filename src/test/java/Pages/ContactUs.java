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

    public void SelectReason(String reason){
        Helper.selectFromDDn(reason,selectReason);
    }

    public void SelectSubject(String subject){
        Helper.selectFromDDn(subject,selectSubject);
    }

    public void enterNameEmailAndComments(String name,String lastName, String email, String Comments){
        txtName.findElement(By.tagName("input")).sendKeys(name);
        txtLastName.findElement(By.tagName("input")).sendKeys(lastName);
        txtEmail.findElement(By.tagName("input")).sendKeys(email);
        txtComments.findElement(By.tagName("textarea")).sendKeys(Comments);
        Helper.click(driver,chkAgeConfirm.findElement(By.tagName("input")));
        Helper.click(driver,btnSubmit);

    }

    public boolean VerifyLnkContactUS(){
        Home home=new Home(driver);
        return home.contactUs.isDisplayed();
    }
}
