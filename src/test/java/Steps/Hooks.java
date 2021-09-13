package Steps;

import Base.BaseUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class Hooks extends BaseUtilities {

    private BaseUtilities utils;
    private RemoteWebDriver _driver;

    public Hooks(BaseUtilities baseUtilities){
        utils=baseUtilities;
    }

    @After
    public void TearDown(){
        if(_driver!=null){
            _driver.quit();
        }
        System.out.println("Tear down process done");
    }

    @Before
    public void Initialize(){
        System.out.println("Initialise process Start");
        SelectBrowser(Browsertype.CHROME);
        utils._driver=_driver;
    }

    public void SelectBrowser(Browsertype browser){

        if(browser==Browsertype.CHROME) {
            System.setProperty("webdriver.chrome.silentOutput","true");
            System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("enable-automation");
            //options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-extensions");
            options.addArguments("--dns-prefetch-disable");
            options.addArguments("--disable-gpu");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            _driver = new ChromeDriver(options);
            _driver.manage().window().maximize();
        }
        else if(browser==Browsertype.EDGE) {
            System.out.println("Initialise Edge Browser");
        }
        else if(browser==Browsertype.FIREFOX) {
            System.out.println("Initialise Firefox Browser");
        }
        else{
            Assert.fail("Please Select a Browser");
        }

    }


}

enum Browsertype{
    CHROME,
    FIREFOX,
    EDGE
}
