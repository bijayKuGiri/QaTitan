package Steps;

import Base.BaseUtilities;
import Pages.ContactUs;
import Pages.Home;
import Utility.Helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class VerifyTermOfUseNavSteps extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    private ContactUs _contact;
    private RemoteWebDriver _driver;
    public VerifyTermOfUseNavSteps(BaseUtilities base) {

        this.base = base;
        _driver= base._driver;
    }
    @Given("Navigate to Contact US Page")
    public void navigate_to_contact_us_page() {
        _home=new Home(base._driver);
        _contact=_home.navContactUs();
    }
    @When("i try to click on TermOfUse link")
    public void i_try_to_click_on_term_of_use_link() throws InterruptedException {
        _contact.SelectReason("Question");
        _contact.SelectSubject("Business");
        Thread.sleep(2000);
        Helper.scrollDownPage(_driver,3);
        _driver=_contact.navTermsOfUse();

    }
    @Then("the page should redirect to TermOfUse page")
    public void the_page_should_redirect_to_term_of_use_page() {
        Assert.assertTrue(_contact.IsNavigateTermsOfUse(_driver));
    }
}
