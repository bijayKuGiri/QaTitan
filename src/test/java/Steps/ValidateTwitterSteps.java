package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ValidateTwitterSteps extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    private RemoteWebDriver _driver;
    public ValidateTwitterSteps(BaseUtilities base) {

        this.base = base;
        _driver= base._driver;
    }
    @When("i try to click on twitter link")
    public void i_try_to_click_on_twitter_link() throws InterruptedException {
        _home=new Home(_driver);
        _driver = _home.navTwitter();
    }
    @Then("the page should redirect to Twitter page")
    public void the_page_should_redirect_to_twitter_page() {
        Assert.assertTrue(_home.IsNavigateTwitter(_driver));
    }
}
