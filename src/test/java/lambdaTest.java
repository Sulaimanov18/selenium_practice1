import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class lambdaTest {


    WebDriver driver;

    @BeforeMethod
    public void setDriver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void inputFormSubmit() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/");
        WebElement inputBoxButton = driver.findElement(By.xpath("//a[@href='https://www.lambdatest.com/selenium-playground/input-form-demo']"));
        inputBoxButton.click();
        WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
        name.sendKeys("Tim");
        WebElement email = driver.findElement(By.id("inputEmail4"));
        email.sendKeys("suafds@mgmail.com");
        WebElement password = driver.findElement(By.id("inputPassword4"));
        password.sendKeys("Timanaza08!");
        WebElement company = driver.findElement(By.id("company"));
        company.sendKeys("TimEntertainment");
        WebElement website = driver.findElement(By.id("websitename"));
        website.sendKeys("time.com");
        WebElement Country = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(Country);
        select.selectByVisibleText("United States");
        WebElement  city = driver.findElement(By.id("inputCity"));
        city.sendKeys("Chicago");
        WebElement address  = driver.findElement(By.xpath("//input[@id='inputAddress1']"));
        address.sendKeys("12 n albany");
        WebElement address2  = driver.findElement(By.xpath("//input[@id='inputAddress2']"));
        address2.sendKeys(" fasd f");
        WebElement state  = driver.findElement(By.xpath("//input[@id='inputState']"));
        state.sendKeys("Illinois");
        WebElement  zipcode = driver.findElement(By.xpath("//input[@id='inputZip']"));
        zipcode.sendKeys("60634");
        WebElement submit = driver.findElement(By.xpath("//button[@class='btn btn-dark selenium_btn bg-black text-white hover:bg-lambda-900 py-5 px-10 rounded']"));
        JavascriptExecutor executor = ( JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",submit);
        WebElement validate = driver.findElement(By.xpath("//p[.='Thanks for contacting us, we will get back to you shortly.']"));
        Assert.assertTrue(validate.isDisplayed());


        }


















    }
}