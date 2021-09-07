
package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature",
        //format={"json:target/cucumber.json"},
       // plugin = {"json:resources/cucumber.json","html:resources/cucumber.html"},

        glue = "Steps",
        plugin = { "pretty","json:target/cucumber.json","html:target/cucumber.html" },
        monochrome = true
)
public class Runner {
}
//public class Runner extends AbstractTestNGCucumberTests {
//}