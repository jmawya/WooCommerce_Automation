package StepDef;

import base.config;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class loginStep extends config {
    Faker f=new Faker();
    @Given("I am at wordpress homepage")
    public void iAmAtWordpressHomepage() {
        String exp="WordPress.com: Build a Site, Sell Your Stuff, Start a Blog & More";
        String act=driver.getTitle();
        Assert.assertEquals(act, exp);
    }

    @And("I click on login link")
    public void iClickOnLoginLink() {

        driver.findElement(By.xpath("//*[@id=\"wpcom-home\"]/div[1]/nav/ul[2]/li[1]/a")).click();
    }

    @And("I enter the valid Email")
    public void iEnterTheValidEmail() {
        driver.findElement(By.xpath("//*[@id=\"usernameOrEmail\"]")).sendKeys("jmawya305@gmail.com");
    }

    @And("click on continue enter")
    public void clickOnEnter() {
        driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div[2]/div/form/div[1]/div[2]/button")).click();
    }

    @And("I enter valid password")
    public void iEnterValidPassword() {

        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Test12345@API");
    }

    @When("I click on login Button")
    public void iClickOnLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div[2]/div/form/div[1]/div[2]/button")).click();
    }

    @Then("I am able to successfully log in")
    public void iAmAbleToSuccessfullyLogIn() {
        String exp="My Home";
        String act=driver.findElement(By.xpath("//*[@id=\"primary\"]/main/div[1]/header/div/div/header/div/h1")).getText();
        Assert.assertEquals(act, exp);
    }

    @And("I click on plugins link")
    public void iClickOnPluginsLink() {
        driver.findElement(By.cssSelector("span[data-e2e-sidebar='Plugins']")).click();
    }

    @And("I type WP Dark Mode in search edit box from plugin page")
    public void iTypeWPDarkModeInSearchEditBoxFromPluginPage() {
        driver.findElement(By.xpath("//*[@id=\"search-component-search-0\"]")).sendKeys("WP Dark Mode");
    }


    @And("I click on search icon from plugin page")
    public void iClickOnSearchIconFromPluginPage() {
        driver.findElement(By.cssSelector("button[aria-label='Open Search']")).click();
    }

    @And("I am able to see WP Dark Mode in search result page")
    public void iAmAbleToSeeWPDarkModeInSearchResultPage() {
        String exp="Search Results";
        String act=driver.findElement(By.cssSelector("div[class='plugins-results-header__title']")).getText();
        Assert.assertEquals(act, exp);
    }

    @And("I click on wp dark mode item from search result page")
    public void iClickOnWpDarkModeItemFromSearchResultPage() {
        driver.findElement(By.xpath("//*[@id=\"primary\"]/main/div/div[3]/div[2]/div[2]/li[1]/a/div[1]/div[1]/div[2]")).click();
    }

    @And("I click on Upgrade and active button")
    public void iClickOnUpgradeAndActiveButton() {
        driver.findElement(By.xpath("//*[@id=\"primary\"]/main/div[1]/div/div[3]/div[1]/div[1]/div[2]/button")).click();
    }

    @And("I click on new button")
    public void iClickOnNewButton() {

        driver.findElement(By.cssSelector("button[class='button is-primary']")).click();
    }

    @And("I enter postalcode and click on continue")
    public void iEnterPostalcode() {
        driver.findElement(By.xpath("//*[@id=\"contact-postal-code\"]")).sendKeys("1206");

        driver.findElement(By.xpath("//*[@id=\"primary\"]/div/div/div[2]/div[2]/div/div/div[2]/div/button")).click();
    }

    @And("I enter valid card number")
    public void iEnterValidCardNumber() {
        List<WebElement> na=driver.findElements(By.tagName("iframe"));
        System.out.println(na.size());
       driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("input[placeholder='1234 1234 1234 1234']")).sendKeys("4111111111111111");

    }

    @And("I enter card holder name")
    public void iEnterCardHolderName() {

        driver.findElement(By.xpath("//*[@id=\"cardholder-name\"]")).sendKeys("Jannatul Mawya");


    }

    @And("I enter card expire date")
    public void iEnterCardExpireDate() {
        List<WebElement> d=driver.findElements(By.tagName("iframe"));
        System.out.println(d.size());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.findElement(By.cssSelector("input[placeholder='MM / YY']")).sendKeys("12/27");
    }

    @And("I enter security code")
    public void iEnterSecurityCode() {

        List<WebElement> d=driver.findElements(By.tagName("iframe"));
        System.out.println(d.size());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);
        driver.findElement(By.cssSelector("input[placeholder='CVC']")).sendKeys("185");
    }

    @And("I click on pay now button")
    public void iClickOnPayNowButton() {
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@id=\"primary\"]/div/div/div[2]/div[2]/div/div/div[6]/div[2]/button")).click();
    }
}
