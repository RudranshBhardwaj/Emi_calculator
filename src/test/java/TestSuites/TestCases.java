package TestSuites;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import Pages.HomeLoanDetialsPage;
import Pages.EMICalculatorPage;
import Pages.LoanCalculatorPage;

public class TestCases extends Base {

	//Calculator cw = new Calculator();
	EMICalculatorPage emicalculator=new EMICalculatorPage();
	LoanCalculatorPage loancalculator=new LoanCalculatorPage();
	HomeLoanDetialsPage homeloan=new HomeLoanDetialsPage();


	@BeforeTest
	public void invokeBrowser() throws IOException {
		logger = report.createTest("Executing Test Cases");

		invokesBrowser(getPropertyFiles("browserName"));
		openURL(getPropertyFiles("websiteURLKey"));
		reportPass("Browser is Invoked");
	}

	@Test(priority = 1)
	public void emicalc() throws InterruptedException {

		emicalculator.emi();
		reportPass("Interest and principal amounts are retrieved");
		
	}

	@Test(priority = 2)
	public void homeloan() throws IOException, InterruptedException {
	
		homeloan.home();
		reportPass("Home loan structured is obtained and stored in excel");
		
	}

	
	@Test(priority = 3)
	public void loancalc() throws InterruptedException, IOException {
		loancalculator.loan();
		reportPass("Loan Calcutaor fields are checked and amount changed is obtained");
	}

	@AfterTest
	public void closeBrowser() {
		endReport();
		driver.quit();
	}

}