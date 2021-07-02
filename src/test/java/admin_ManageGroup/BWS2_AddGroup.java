package admin_ManageGroup;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS2_AddGroup extends BaseClass {


	@Test
	public static void AddGroup() throws Throwable {

		Thread.sleep(4000);
		ExtentReportName("Add Group");
		GetWebElementandClick("ManageGroup");
		LogInfo("Manage Group is clicked");
		
		GetWebElementandClick("NewGroup");
		LogInfo("New Group is clicked");
		Thread.sleep(3000);

		TypeDataInTheElement("GroupTitle", AdminExcel(1, 1, "Add Group"));
		LogInfo("Group Title is clicked and value entered as :" + AdminExcel(1, 1, "Add Group"));
		Thread.sleep(3000);
		
		TypeDataInTheElement("SearchUser", AdminExcel(1, 2, "Add Group"));
		LogInfo("Search User is clicked and value entered as :" + AdminExcel(1, 2, "Add Group"));

		Thread.sleep(3000);
		Select("Active User");
		LogInfo("User is selected");


		GetWebElementandClick("GroupSave");
		LogInfo("Group save is clicked");
		
		Thread.sleep(3000);

		WebElement GroupCreatedSuccessfully =	GetWebElement("GroupCreatedSuccessfully");
		if(GroupCreatedSuccessfully.isDisplayed()) {
			ConditionPass("Group created successfully");
			LogInfo("Group created successfully\"");
		}

		else {
			ConditionFail("Group not created");
			LogInfo("Group not created");
		}

	}

}