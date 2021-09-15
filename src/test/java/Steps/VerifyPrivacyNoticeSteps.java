package Steps;

import Base.BaseUtilities;
import Pages.ContactUs;
import Pages.Home;
import Utility.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class VerifyPrivacyNoticeSteps extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    private ContactUs _contact;
    private RemoteWebDriver _driver;
    public VerifyPrivacyNoticeSteps(BaseUtilities base) {
        this.base = base;
        _driver= base._driver;
    }

    @When("i try to click on PrivacyNotice link")
    public void iTryToClickOnPrivacyNoticeLink() throws InterruptedException {
        _contact.SelectReason("Question");
        _contact.SelectSubject("Business");
        Thread.sleep(2000);
        Helper.scrollDownPage(_driver,3);
        _driver=_contact.navPrivacyNotice();
    }

    @And("Navigate to ContactUS Page")
    public void navigateToContactUSPage() {
        _home=new Home(base._driver);
        _contact=_home.navContactUs();
    }

    @Then("the page should redirect to PrivacyNotice page")
    public void thePageShouldRedirectToPrivacyNoticePage() {
        Assert.assertTrue(_contact.IsNavigatePrivacyNotice(_driver));
    }
}
