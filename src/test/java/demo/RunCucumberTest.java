package demo;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/feature/source.feature"}, glue = "pages")
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
