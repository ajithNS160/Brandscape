package superAdmin_ManageAdmin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS7_DeleteAdmin extends BaseClass {
	@Test
	public static void DeleteAdmin() throws Throwable {
		Thread.sleep(5000);
		ExtentReportName("Delete Admin");

		List("AdminDelete");
		LogInfo("Admin name is searching");

		DeleteFromList("AdminDelete1", "AdminDelete2", "AdminDelete3", "AdminDelete4", SuperAdminExcel(1, 1, "Delete Admin"));
		LogInfo("Admin name is searched");

		GetWebElementandClick("DeleteYes");
		LogInfo("Delete yes is clicked");

		WebElement AdminDeletedSuccessfully =	GetWebElement("AdminDeletedSuccessfully");

		Thread.sleep(3000);

		if(AdminDeletedSuccessfully.isDisplayed()) {
			ConditionPass("Admin deleted successfully");
			LogInfo("Admin deleted successfully");
		}else {
			ConditionFail("Admin not deleted");
			LogInfo("Admin not deleted");
		}
	}

}
