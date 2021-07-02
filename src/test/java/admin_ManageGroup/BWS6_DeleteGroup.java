package admin_ManageGroup;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS6_DeleteGroup extends BaseClass {

	@Test
	public static void DeleteGroup() throws Throwable {
		

			Thread.sleep(3000);
		ExtentReportName("Delete Group");

		List("DeleteGroup");
		LogInfo("Group name is searching");

		DeleteFromList("DeleteGroup1", "DeleteGroup2", "DeleteGroup3", "DeleteGroup4", AdminExcel(1, 1, "Delete Group"));
		LogInfo("Group name is searched");

		GetWebElementandClick("DeleteGroupYes");
		LogInfo("Delete yes is clicked");

		WebElement GroupDeletedSuccessfully =	GetWebElement("GroupDeletedSuccessfully");

		Thread.sleep(3000);

		if(GroupDeletedSuccessfully.isDisplayed()) {
			ConditionPass("Group deleted successfully");
			LogInfo("Group deleted successfully");
		}else {
			ConditionFail("Group not deleted");
			LogInfo("Group not deleted");
		}
	}
}
