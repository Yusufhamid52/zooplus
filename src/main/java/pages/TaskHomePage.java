package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TaskHomePage {
	
	@FindBy(id = "com.example.android.architecture.blueprints.master.mock:id/add_task_fab")
	private MobileElement addTaskButton;
	
	@FindBy(id = "com.example.android.architecture.blueprints.master.mock:id/add_task_title_edit_text")
	private MobileElement addTaskTitle;
	
	@FindBy(id = "com.example.android.architecture.blueprints.master.mock:id/add_task_description_edit_text")
	private MobileElement addTaskDescription;
	
	@FindBy(id = "com.example.android.architecture.blueprints.master.mock:id/save_task_fab")
	private MobileElement saveTaskButton;
	
	@FindBy(id = "com.example.android.architecture.blueprints.master.mock:id/filtering_text")
	private MobileElement verifyAllTasksTitle;
	
	@FindBy(id = "com.example.android.architecture.blueprints.master.mock:id/complete_checkbox")
	private MobileElement checkBoxCompleteTask;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation drawer']")
	private MobileElement hamburgerMenuButton;
	
	@FindBy(id = "com.example.android.architecture.blueprints.master.mock:id/design_menu_item_text")
	private MobileElement statisticsTab;
	
	@FindBy(id = "com.example.android.architecture.blueprints.master.mock:id/stats_active_text")
	private MobileElement activeTasksText;
	
	@FindBy(id = "com.example.android.architecture.blueprints.master.mock:id/stats_completed_text")
	private MobileElement completedTasksText;
	
	@FindBy(id = "com.example.android.architecture.blueprints.master.mock:id/tasks_fragment_dest")
	private MobileElement tasksListTab;
	
	@FindBy(id = "//android.widget.ImageView[@content-desc='More options']")
	private MobileElement threeDotMenu;
	
	@FindBy(id = "com.example.android.architecture.blueprints.master.mock:id/title")
	private MobileElement clearCompletedLink;
	
	public TaskHomePage(WebDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickAddToDoTask() {
		addTaskButton.click();
	}
	
	public void addTaskTitle(String title) {
		addTaskTitle.sendKeys(title);
	}
	
	public void addTaskDescription(String description) {
		addTaskDescription.sendKeys(description);
	}
	
	public void clickSaveTask() {
		saveTaskButton.click();
	}
	
	public boolean verifyTaskIsAdded() {
		return verifyAllTasksTitle.isDisplayed();
	}
	
	public void clickTaskCompletedCheckbox() {
		checkBoxCompleteTask.click();
	}
	
	public void clickHamburgerMenu() {
		hamburgerMenuButton.click();
	}
	
	public void goToStatiticsTab() {
		statisticsTab.click();
	}
	
	public void goToTasksListTab() {
		tasksListTab.click();
	}
	
	public void clickThreeDotMenu() {
		threeDotMenu.click();
	}
	
	public String getActiveTasksStatictics() {
		return activeTasksText.getText();
	}
	
	public String getCompletedTasksStatistics() {
		return completedTasksText.getText();
	}
	
	public void clickClearCompletedLink() {
		clearCompletedLink.click();
	}

}
