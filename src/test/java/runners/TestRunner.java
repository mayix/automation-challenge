package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D://GitHub//automation-challenge//src//test//resources//testCases//microsoft//TC_Microsoft_ProductPrice_Validation.feature",
        glue = "stepDefinitions"
)
public class TestRunner {
}
