package demo;



import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@Listeners({ExtentITestListenerClassAdapter.class})
@CucumberOptions(
        tags = "",
        features = {"src/test/resources/feature/source.feature"},
        glue = "pages",
        plugin = {
                "pretty",
                "json:target/cucumber-report/cucumber.json",
                "html:target/cucumber-report/cucumber.html"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
