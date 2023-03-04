package stepDefinitions;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {
	
//	@Before   -> This hook is use to execute very first in a class
//	public void setup() {
	
//	logger=logger.getLogger("nopCommerce"); //Added logger
//	PropertyConfigurator.configure("Log4j.properties"); // Added logger
//		
	    //reading properties
//		configprop = new Properties();
//	FileInputStream configpropfile = new FileInputStream("config.properties");
//	congifporop.load(congifpropfile);	
	

//		
//	String br = configprop.getProperty("browser"); //->it will store browser name from config.properties file
	
//	if(br.equals("chrome")){	//-> if browser name is chrome then it will execute this
//	System.setProperty("webdriver.chrome.driver",configprop.getProperty("chromepath") )	;
//	driver = new ChromeDriver();
//	}
	
//	else if(br.equals("firefox")) {	//-> if browser name is firefox it will execute this
//		System.setProperty("webdriver.gecko.driver",configprop.getProperty("firefoxpath") )	;
//		driver = new FirefoxDriver();
//		}	
	
//	else if(br.equals("ie")) {	//->if browser name this it will execute this
//	System.setProperty("webdriver.ie.driver",configprop.getProperty("iepath") )	;
//	driver = new InternetExplorerDriver();
//	}
	
	
//	logger.info("************Launching Browser************");
//	
//	}
//	
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		
		logger=logger.getLogger("nopCommerce"); //Added logger
		PropertyConfigurator.configure("Log4j.properties"); // Added logger
		
	System.setProperty("webdriver.chrome.driver","D:/Software Testing/chromedriver.exe" )	;
	driver = new ChromeDriver();
	logger.info("************Launching Browser************");
	
		lp = new LoginPage(driver);
	    
	}

	@When("User opnes URL {string}")
	public void user_opnes_url(String url) {
		logger.info("************Opening URL************");
		driver.get(url);
	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String uname, String pwd) {
		logger.info("************Providing Login Details************");
		lp.setUserName(uname);
		lp.setPassword(pwd);
	    
	}

	@When("Click on Login")
	public void click_on_login() {
		logger.info("************Click On Login************");
		lp.clickLogin();
	    
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsucessful")) {
			driver.close();
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(title, driver.getTitle());
		}
	    
	}

	@When("User Click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		logger.info("************Click On LogOut************");
		lp.clickLogout();
		Thread.sleep(3000);
	    
	}

	@Then("Close browser")
	public void close_browser() {
		logger.info("************Closing Browser************");
		driver.close();
	    
	}
	
	//Customers Feature stepDefinitions
	
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		
	    addCust = new AddcustomerPage(driver);
	    Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		
		Thread.sleep(3000);
		addCust.clickOnCustomerMenu();
	    
	}

	@When("Click on customer menu Item")
	public void click_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(2000);
		addCust.clickOnCustomersMenuItem();
	   
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		addCust.clickOnAddnew();
		Thread.sleep(2000);
	    
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
		
	   
	}

	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		
		logger.info("************Adding New Customer************");
		logger.info("************Providing Customer details************");
		
		String email = randomstring()+"@gmail.com";
		addCust.setEmail(email);
		
		addCust.setPassword("test123");
		
		
		//43min
//		addCust.setCustomerRoles("Guests");
		Thread.sleep(3000);
		
		addCust.setManagerofVendor("Vendor 2");
		addCust.setGender("Male");
		addCust.setFirstName("Sagar");
		addCust.setLastName("Wanare");
		addCust.setDob("11/07/2001");
		addCust.setCompanyName("Sagar Enterprise");
		addCust.setAdminContent("This is my testing project.......");
		
	    
	}

	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		logger.info("************Saving Customer Data************");
		addCust.clickOnSave();
		Thread.sleep(2000);
	   
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
		
	   
	}

	
	//steps for searching a customer by EmailId
	
	@When("Enter customer Email")
	public void enter_customer_email() throws InterruptedException {
		logger.info("************Searching a Customer by using EmailId************");
		searchCustomer = new SearchCustomerPage(driver);
		
		searchCustomer.setEmail("victoria_victoria@nopCommerce.com");
		Thread.sleep(3000);
		
	   
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCustomer.clickSearch();
		Thread.sleep(3000);
	    
	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
		boolean status =searchCustomer.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	  
	}

	
	//Search customer by Name
	
	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() throws InterruptedException {
		logger.info("************Searching Customer by Name************");
		searchCustomer = new SearchCustomerPage(driver);
		searchCustomer.setFirstName("Victoria");
		
	    
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() throws InterruptedException {
	    searchCustomer.setLastName("Terces");
	}

	@Then("User should found Name in the search table")
	public void user_should_found_name_in_the_search_table() {
		boolean status = searchCustomer.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
	    
	}

}
