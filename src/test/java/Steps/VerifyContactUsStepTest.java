package Steps;

import Base.BaseUtilities;
import Pages.ContactUs;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

class VerifyContactUsStepTest extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    private ContactUs _contact;
    SoftAssert softAssert=new SoftAssert();
    private RemoteWebDriver _driver;

    public VerifyContactUsStepTest(BaseUtilities base) {
        this.base = base;
        _driver=base._driver;
    }


//    @When("navigate to contact us page and fill the details")
//    public void navigate_to_contact_us_page_and_fill_the_details() throws InterruptedException {
//        _home=new Home(base._driver);
//        _contact=_home.navContactUs();
//        Thread.sleep(5000);
//
//        _contact.SelectReason("Question");
//        _contact.SelectSubject("Product");
//;    }
//    @Then("user should able to send the details")
//    public void user_should_able_to_send_the_details() {
//        System.out.println("Then Section");
//    }
}
