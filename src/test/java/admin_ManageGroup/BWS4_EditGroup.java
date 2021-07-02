package admin_ManageGroup;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS4_EditGroup extends BaseClass {

	@Test
	public static void ViewGroup() throws Throwable {



		Thread.sleep(4000);
		ExtentReportName("Edit Group");
		GetWebElementandClick("ManageGroup");
		List("EditGroup");
		LogInfo("Searching Group email from the list");
		Thread.sleep(4000);
		EditFromList("EditGroup1", "EditGroup2", "EditGroup3", "EditGroup4", AdminExcel(1, 1, "Edit Group"));
		LogInfo("Edit button is clicked");

		GetWebElement("GroupNameEdit").clear();
		LogInfo("Group name is clicked and values are cleared");

		TypeDataInTheElement("GroupNameEdit", AdminExcel(1, 2, "Edit Group"));
		LogInfo("Group name is edited");

		TryandClick("GroupSave");
		LogInfo("Save button is clicked");


		WebElement GroupModifiedSuccessfully =	GetWebElement("GroupModifiedSuccessfully");

		Thread.sleep(3000);

		if(GroupModifiedSuccessfully.isDisplayed()) {
			ConditionPass("Group edited successfully");
			LogInfo("Group edited successfully");
		}else {
			ConditionFail("Group not edited");
			LogInfo("Group not edited");
		}

	}

}
