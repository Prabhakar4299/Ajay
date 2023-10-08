package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {
WebDriver ldriver;
	
	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	By link_customers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By link_customers_menu_item = By.xpath("//p[text()=' Customers']");
	By btnAddNew = By.xpath("//a[@class='btn btn-primary']");
	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");
	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");
	By rdMale = By.xpath("//input[@id='Gender_Male']");
	By rdFemale = By.xpath("//input[@id='Gender_Female']");
	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	By txtCompany = By.xpath("//input[@id='Company']");
	By txtAdminComment = By.xpath("//textarea[@id='AdminComment']");
	By btnSave = By.xpath("//button[@name='save']");
	@FindBy(xpath="//*[@id='VendorId']")
	WebElement dropdownVendorMgr;
	//user defined method to perform operations on StepDefinition.java file
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	public void ClickOnCustomersMenu() {
		ldriver.findElement(link_customers_menu).click();
	}
	
	public void ClickOnCustomersMenuItem() {
		ldriver.findElement(link_customers_menu_item).click();
	}
	
	public void ClickOnBtnAddNew() {
		ldriver.findElement(btnAddNew).click();
	}
	
	public void SetEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void SetPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void SetFirstName(String firstName) {
		ldriver.findElement(txtFirstName).sendKeys(firstName);
	}
	
	public void SetLastName(String lastName) {
		ldriver.findElement(txtLastName).sendKeys(lastName);
	}
	
	public void SetGender(String gender) {
		if(gender.equals("Male")) {
			ldriver.findElement(rdMale).click();
		}
		else {
			ldriver.findElement(rdFemale).click();
		}
	}
	
	public void SetDob(String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	public void SetCompany(String company) {
		ldriver.findElement(txtCompany).sendKeys(company);
	}
	
	public void SetAdminComment(String adminComment) {
		ldriver.findElement(txtAdminComment).sendKeys(adminComment);
	}
	
	public void enterManagerOfVendor(String value)
	{
		Select drp=new Select(dropdownVendorMgr);
		drp.selectByVisibleText(value);
	}
	
	public void ClickOnSave() {
		ldriver.findElement(btnSave).click();
	}

}
