package admin_ManageUser;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS4_EditUser extends BaseClass
{


	@Test
	public static void EditUser() throws Throwable {

		ExtentReportName("Edit User");

		List("EditUser");
		LogInfo("Searching user email from the list");

		EditFromList("EditUser1", "EditUser2", "EditUser3", "EditUser4", AdminExcel(1, 1, "Edit User"));
		LogInfo("Edit button is clicked");

		GetWebElement("UserNameEdit").clear();
		LogInfo("User name is clicked and values are cleared");

		TypeDataInTheElement("UserNameEdit", AdminExcel(1, 2, "Edit User"));
		LogInfo("User name is edited");

		TryandClick("UserSave");
		LogInfo("Save button is clicked");


		WebElement UserEditSave =	GetWebElement("UserEditSave");

		Thread.sleep(3000);

		if(UserEditSave.isDisplayed()) {
			ConditionPass("User edited successfully");
			LogInfo("User edited successfully");
		}else {
			ConditionFail("User not edited");
			LogInfo("User not edited");
		}

	}
}
