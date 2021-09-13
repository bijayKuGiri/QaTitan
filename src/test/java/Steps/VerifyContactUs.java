package Steps;

import Base.BaseUtilities;
import Pages.ContactUs;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class VerifyContactUs extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    private ContactUs _contact;
    SoftAssert softAssert=new SoftAssert();
    private RemoteWebDriver _driver;

    public VerifyContactUs(BaseUtilities base) {
        this.base = base;
        _driver=base._driver;
    }
    @When("navigate to contact us page and fill the details")
    public void navigateToContactUsPageAndFillTheDetails() throws InterruptedException {
        _home=new Home(base._driver);
        _contact=_home.navContactUs();
        Thread.sleep(5000);

        _contact.SelectReason("Question");
        Thread.sleep(5000);
        _contact.SelectSubject("Business");
        Thread.sleep(5000);
        _contact.enterNameEmailAndComments("Test","Uniliver","test@gmail.com","Testiing purpose");
    }

    @Then("user should able to send the details")
    public void userShouldAbleToSendTheDetails() {
        System.out.println("Then Section");
        Assert.assertTrue(_contact.VerifyLnkContactUS());
    }
}
