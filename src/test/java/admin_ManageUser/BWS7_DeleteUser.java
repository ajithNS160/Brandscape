package admin_ManageUser;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS7_DeleteUser extends BaseClass {



	@Test
	public static void FilterUser() throws Throwable {

		Thread.sleep(5000);
		ExtentReportName("Delete User");

		List("UserDelete");
		LogInfo("User mail is searching");

		DeleteFromList("UserDelete1", "UserDelete2", "UserDelete3", "UserDelete4", AdminExcel(1, 1, "Delete User"));
		LogInfo("User mail is searched");

		GetWebElementandClick("DeleteUserYes");
		LogInfo("Delete yes is clicked");

		WebElement UserDeletedSuccessfully =	GetWebElement("UserDeletedSuccessfully");

		Thread.sleep(3000);

		if(UserDeletedSuccessfully.isDisplayed()) {
			ConditionPass("User deleted successfully");
			LogInfo("User deleted successfully");
		}else {
			ConditionFail("User not deleted");
			LogInfo("User not deleted");
		}
	}
}