package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
	public WebDriver ldriver;
	WaitHelper waithelper;
	
	
	
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper = new WaitHelper(ldriver);
		
	}
	
	By txtEmail = By.xpath("//input[@id='SearchEmail']");
	By txtFirstName = By.xpath("//input[@id='SearchFirstName']");
	By txtLastName = By.xpath("//input[@id='SearchLastName']");
	By txtCompany = By.xpath("//input[@id='SearchCompany']");
	By btnSearch = By.xpath("//button[@id='search-customers']");
	
	@FindBy(how = How.XPATH, using ="//table[@id='customers-grid']")
	WebElement table;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;
	
	
	public void setEmail(String email) throws InterruptedException {
		
//		waithelper.waitForElement(txtEmail, 30);
		Thread.sleep(3000);
		ldriver.findElement(txtEmail).clear();
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	
	public void setFirstName(String fname) throws InterruptedException {
		
		Thread.sleep(3000);
		ldriver.findElement(txtFirstName).clear();
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setLastName(String lname) throws InterruptedException {
		
		Thread.sleep(3000);
		ldriver.findElement(txtLastName).clear();
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	
	public void clickSearch() throws InterruptedException {
		ldriver.findElement(btnSearch).click();
		Thread.sleep(5000);
	}
	
	public int getNoOfRows() {
		return(tableRows.size());
	}
	
	public int getNoOfColumns() {
		return(tableColumns.size());
	}
	
	
	public boolean searchCustomerByEmail(String email) {
		boolean flag =false;
		for (int i=1;i<=getNoOfRows();i++)
		{
			String emailid =table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailid);
			if(emailid.equals(email)) {
				flag = true;
			}
		}
		return flag;
	}
	
	public boolean searchCustomerByName(String Name) {
		boolean flag = false;
		
		for(int i=1;i<=getNoOfRows();i++)
		{
			String name =table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[\"+i+\"]/td[3]")).getText();
			
			String names[] = name.split(" "); //separating first name and last name
			if(names[0].equals("Victoria") && names[1].equals("Terces"))
			{
				flag = true;
			}
		}
		return flag;
	}
	

}



