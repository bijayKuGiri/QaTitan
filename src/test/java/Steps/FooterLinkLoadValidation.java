package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Utility.Helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FooterLinkLoadValidation extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    private RemoteWebDriver _driver;
    private List<String> linkTxt=new ArrayList<String>();
    public FooterLinkLoadValidation(BaseUtilities base) {

        this.base = base;
        _driver= base._driver;
    }

    @Given("The site is Up & Running")
    public void the_site_is_up_and_running() throws ParserConfigurationException, IOException, SAXException {
        //Helper. helper=new Helper();
        Helper.NavigateToUAT(_driver);
        _home=new Home(_driver);
        System.out.println("Given");

    }
    @When("i try to get the footer links")
    public void i_try_to_get_the_footer_links() {
        System.out.println("When");
        linkTxt=_home.getfooterLinktext();
    }
    @Then("All the footer link should load within {int} second")
    public void all_the_footer_link_should_load_within_second(Integer timeSecond) {
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
