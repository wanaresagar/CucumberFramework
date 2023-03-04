package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	
	public WebDriver driver;
	
	
	public LoginPage lp; // to access page object webelements
	
	public AddcustomerPage addCust;
	
	public SearchCustomerPage searchCustomer;
	
	public static Logger logger;
	
//	public Properties congifprop;  import Properties from java.utils
	
	//Created for generating random string for Unique email
	public static String randomstring() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	
	

}
