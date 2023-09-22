package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/Resources/Features",
        glue = {"stepdefinition","hooks"},
        monochrome = true,
        dryRun = false,
        plugin={"pretty","html:target/CucumberReports/CucumberReport.html"},
        publish = true
)
public class TestRunner {

}
