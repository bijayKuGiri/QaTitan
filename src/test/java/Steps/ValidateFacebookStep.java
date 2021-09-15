package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ValidateFacebookStep extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    private RemoteWebDriver _driver;
    public ValidateFacebookStep(BaseUtilities base) {

        this.base = base;
        _driver= base._driver;
    }
    @When("i try to click on facebook link")
    public void i_try_to_click_on_facebook_link() throws InterruptedException {
        _home=new Home(_driver);
        _driver = _home.navFacebook();
    }
    @Then("the page should redirect to facebook page")
    public void the_page_should_redirect_to_facebook_page() {
        Assert.assertTrue(_home.IsNavigateFacebook(_driver));
    }
}
