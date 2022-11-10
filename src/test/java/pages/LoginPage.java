package pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    private static WebDriver driver;
    String userName = "userName";
    String passWord = "password";
    String submit = "submit";
    public final static int TIMEOUT = 10;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
    }
    @Given("User is on Guru99Login page {string}")
    public void loginTest(String url){
        driver.get(url);
    }
    @When("User enters username as {string} and password as {string}")
    public void inputValue(String username, String password){
        driver.findElement(By.name(userName)).sendKeys(username);
        driver.findElement(By.name(passWord)).sendKeys(password);
        driver.findElement(By.name(submit)).click();
    }
    @Then("User should be able to login successfully and new page open")
    public void verifyLogin(){
        String headingHomePage = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(headingHomePage,"Login Successfully");
    }
    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage){
        String actualErrorMessage = driver.findElement(By.xpath("//span")).getText();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
