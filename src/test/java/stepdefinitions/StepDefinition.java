package stepdefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AddNewCustomerPage;
import pageObject.AdminPage;
import utilities.ReadConfig;

public class StepDefinition extends Base{
	
	//@Before will be executed before every scenario
	@Before
	public void setUp() throws Exception {
		System.out.println("SetUp method execution");
		readConfig = new ReadConfig();//create object of ReadConfig java class
		String browser = readConfig.getBrowser();// value = browser (chrome/firefox)
		
		if(browser.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(1000);

		}else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(1000);


		}else if(browser.equalsIgnoreCase("IE")) {
			driver=new InternetExplorerDriver();
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(1000);

		}
	}

	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() throws Exception {
		//driver = new ChromeDriver();

		//create object of AdminPage class
		ad = new AdminPage(driver);
		Thread.sleep(2000);
	    
	}

	@When("User open url {string}")
	public void user_open_url(String url) throws Exception {
		driver.get(url);
	    Thread.sleep(2000);
	}

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) throws Exception {
		ad.setUsername(email);
		Thread.sleep(2000);
		ad.setPassword(password);
		Thread.sleep(2000);
	    
	}

	@When("User click on Login button")
	public void user_click_on_login_button() throws Exception {
		ad.clickOnLogin();
		Thread.sleep(2000);
	    
	}
	@Then("User verify page title should be {string}")
	public void user_verify_page_title_should_be(String title) throws Exception {
		Assert.assertEquals(driver.getTitle(), title);
		Thread.sleep(2000);
	   
	}

	//@Then("Close browser")
	////public void close_browser() throws Exception {
	    //driver.close();
	    //Thread.sleep(2000);
	//}
	
	//add new customer
	
			/*@Then("User can view Dashboard")
			public void user_can_view_dashboard() throws InterruptedException {
				addCust=new AddNewCustomerPage(driver);
				   Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
				    Thread.sleep(2000);
			}*/

			@When("User click on customer menu")
			public void user_click_on_customer_menu() throws Exception {
				addCust=new AddNewCustomerPage(driver); 
				addCust.ClickOnCustomersMenu();
				    Thread.sleep(2000);
			}

			@When("User click on customer menu item")
			public void user_click_on_customer_menu_item() throws InterruptedException {
				 addCust.ClickOnCustomersMenuItem();
				    Thread.sleep(2000);
			}

			@When("User click on new add button")
			public void user_click_on_new_add_button() throws Exception {
				addCust.ClickOnBtnAddNew();
			    Thread.sleep(2000);
			}

			@Then("User can view add new customer page")
			public void user_can_view_add_new_customer_page() throws Exception {
				 Thread.sleep(2000);
			       Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
			}

			@When("User enter customer info as {string} and {string} and {string} and {string} and {string} and {string} and {string}")
			public void User_enter_customer_info_as_and_and_and_and_and_and(String newEmail, String NewPassword, String firstName, String lastName, String gender, String compName, String adminComment) throws Exception {
				 addCust.SetEmail(newEmail);
				  addCust.SetPassword(NewPassword);
				  addCust.SetFirstName(firstName);
				  addCust.SetLastName(lastName);
				  addCust.SetGender(gender);
				  addCust.SetDob("6/13/1988");
				  addCust.enterManagerOfVendor("Vendor 1");
				  addCust.SetCompany(compName);
				  addCust.SetAdminComment(adminComment);
				    Thread.sleep(2000);
			}

			@When("User click on save button")
			public void User_click_on_save_button() {
				   addCust.ClickOnSave();
			}

			@Then("User can view confirmation message {string}")
			public void User_can_view_confirmation_message(String string) throws Exception {
				 Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
				    Thread.sleep(2000);
			}
			
			@Then("close browser")
			public void close_browser() throws Exception {
			driver.close();
			Thread.sleep(2000);
			}
	
	@After
	public void teadDown(Scenario sc) throws Exception {
		System.out.println("Tead down method execute after each test case scenario");
		
		if(sc.isFailed()==true) {
			String filewithpath = "C:\\Users\\rjprabha\\eclipse-workspace\\10JulyCucumberMavenProject\\sceenShot\\failedScreenShot.png";
			//convert WebDriver object into Screenshot
			TakesScreenshot scrshot = ((TakesScreenshot)driver);
			//call getScreebshotAs() to store image file
			File scrFile = scrshot.getScreenshotAs(OutputType.FILE);
			File destFile = new File(filewithpath);
			FileUtils.copyFile(scrFile, destFile);
			
		}
		Thread.sleep(2000);
		driver.quit();
	}
}
