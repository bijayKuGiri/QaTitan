package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CarouselStepsTest extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    private List<WebElement> elements;

    public CarouselStepsTest(BaseUtilities base) {
        this.base = base;
    }


    @When("verifying the carousel rotation")
    public void verifyingTheCarouselRotation() {
        _home=new Home(base._driver);
        elements= _home.getCarouselList();
    }
    @Then("it should be work as expected")
    public void it_should_be_work_as_expected() throws InterruptedException {
        _home.verifyRotation(elements);
    }
}
