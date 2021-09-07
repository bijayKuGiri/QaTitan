package Steps;

import Base.BaseUtilities;
import com.unilever.Pages.Helper;
import com.unilever.Pages.Home;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkloadingSteps extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    private RemoteWebDriver _driver;
    private List<String> linkTxt=new ArrayList<String>();
    public LinkloadingSteps(BaseUtilities base) {

        this.base = base;
        _driver= base._driver;
    }

    @Given("The site is Up and Running")
    public void the_site_is_up_and_running() throws ParserConfigurationException, IOException, SAXException {
        Helper helper=new Helper();
        helper.NavigateToUAT(_driver);
        _home=new Home(_driver);
        System.out.println("Given");

    }
    @When("i try to get the header links")
    public void i_try_to_get_the_header_links() {
        System.out.println("When");
        linkTxt=_home.getLinktext();
    }
    @Then("All the header link should load within {int} second")
    public void all_the_header_link_should_load_within_second(Integer timeinSecond) {

        System.out.println("Then");
        for (String var : linkTxt) {

            _driver.get(var);



        }

    }
}
