package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class HomepageValidationStepTest extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    SoftAssert softAssert=new SoftAssert();

    public HomepageValidationStepTest(BaseUtilities base) {
        this.base = base;
    }


    @When("verifying all the links")
    public void verifying_all_the_links() {
        System.out.println("Verifying the Element on the Page");
        _home=new Home(base._driver);
    }
    @Then("All the elements should placed appropriately")
    public void all_the_elements_should_placed_appropriately() throws IOException, InterruptedException {

        softAssert.assertEquals(_home.getHeader(),"Homepage | Magnum Brasil");
        //_home.getScreenShot();
        softAssert.assertTrue(_home.IsLogoImageDisplayed());
        softAssert.assertTrue(_home.IsCopyRightExist());

    }
}
