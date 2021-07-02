package superAdmin_ManageAdmin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS4_EditAdmin extends BaseClass{

	@Test


	public static void EditAdmin() throws Throwable {
		ExtentReportName("Edit Admin");

		List("AdminEdit");
		LogInfo("Searching admin email from the list");

		EditFromList("AdminEdit1", "AdminEdit2", "AdminEdit3", "AdminEdit4", SuperAdminExcel(1, 1, "Edit Admin"));
		LogInfo("Edit button is clicked");

		GetWebElement("AdminNameEdit").clear();
		LogInfo("Admin name is clicked and values are cleared");

		TypeDataInTheElement("AdminNameEdit", SuperAdminExcel(1, 2, "Edit Admin"));
		LogInfo("Admin name is edited");

		TryandClick("AdminSave");
		LogInfo("Save button is clicked");


		WebElement AdminEditSave =	GetWebElement("AdminEditSave");

		Thread.sleep(3000);

		if(AdminEditSave.isDisplayed()) {
			ConditionPass("Admin edited successfully");
			LogInfo("Admin edited successfully");
		}else {
			ConditionFail("Admin not edited");
			LogInfo("Admin not edited");
		}

	}

}
