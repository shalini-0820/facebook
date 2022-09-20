package login;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFlowStepDifinition {
	
	public static WebDriver driver;

@Given("user is  on homepage")
public void user_is_on_homepage() {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\Shalini\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://www.facebook.com/");
}
@When("user enters username and Password as {string} and {string}")
public void user_enters_username_and_password(String userName,String pwd) {
	driver.findElement(By.id("email")).sendKeys(userName);
	driver.findElement(By.id("pass")).sendKeys(pwd);
	
}
@When("clicks login")
public void clicks_login() {
	driver.findElement(By.name("login")).click();
}
@Then("profile information is displayed")
public void success_message_is_displayed() {
	assertNotNull(driver.findElement(By.linkText("Shalini Onteddu")));
//	driver.close();
}
@Then("invalid credentials message is displayed")
public void invalid_credentials_message_is_displayed() {
	assertNotNull(driver.findElement(By.linkText("The email or mobile number you entered isn’t connected to an account.")));
}
}
