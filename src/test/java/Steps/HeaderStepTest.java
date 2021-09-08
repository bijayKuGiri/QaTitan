package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HeaderStepTest extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    private List<String> linkTxt=new ArrayList<String>();
    private List<String> uatlinkTxt=new ArrayList<String>();

    public HeaderStepTest(BaseUtilities base) {
        this.base = base;
    }

    @Given("^The production site is Up and Running$")
    public void theProductionSiteIsUpAndRunning() throws ParserConfigurationException, IOException, SAXException {
        _home=new Home(base._driver);
        System.out.println("Given");
        //_home.NavigateToUAT();//.NavigateToProd();
    }

    @And("^the links of the header file should be available$")
    public void theLinksOfTheHeaderFileShouldBeAvailable() {
        System.out.println("And");
//        linkTxt=_home.getLinktext();
//        _home.quit();
    }

    @When("^i try to find the header links in UAT environment$")
    public void iTryToFindTheHeaderLinksInUATEnvironment() throws ParserConfigurationException, IOException, SAXException {
        System.out.println("When");
//        _home.Initialize();
//        _home.NavigateToUAT();
//        uatlinkTxt= _home.getLinktext();
//        _home.quit();
    }

    @Then("^All the link should be same as Production Site$")
    public void allTheLinkShouldBeSameAsProductionSite() {
        System.out.println("Then");
//        Assert.assertTrue("Expected both the header link Text should be same",linkTxt.equals(uatlinkTxt));
    }
}
