package Steps;

import Base.BaseUtilities;
import Utility.Helper;
import Pages.Home;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



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
        Helper.NavigateToUAT(_driver);
        _home=new Home(_driver);
        System.out.println("Given");

    }
    @When("i try to get the header links")
    public void i_try_to_get_the_header_links() {
        System.out.println("When");
        linkTxt=_home.getLinktext();
    }
    @Then("All the header link should load within {int} second")
    public void all_the_header_link_should_load_within_second(Integer timeSecond) {
        SoftAssert softAssert=new SoftAssert();
        System.out.println("Then");
        for (String var : linkTxt) {
            long start = System.currentTimeMillis();
            _driver.get(var);
            long finish = System.currentTimeMillis();
            long totalTime = finish - start;
            System.out.println("The Url is "+var);
            softAssert.assertTrue((0.001*totalTime) <= timeSecond,"Page should load within " +timeSecond);
            System.out.println("Loading time is ..."+(0.001*totalTime));
        }

    }
}
