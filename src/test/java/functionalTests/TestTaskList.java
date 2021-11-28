package functionalTests;

import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.AppiumSetUp;
import pages.TaskHomePage;

public class TestTaskList extends AppiumSetUp {
	
	private TaskHomePage taskPage;
	
	@BeforeTest
	public void startAppiumServer() throws MalformedURLException {
		initialiseAppium();
	}
	
	@BeforeMethod
	public void beforeTestMethod() {
		taskPage = new TaskHomePage(driver);
	}

	@Test
	public void verifyToDoTaskListFeature() throws MalformedURLException {
		taskPage.clickAddToDoTask();
		
	}
}
