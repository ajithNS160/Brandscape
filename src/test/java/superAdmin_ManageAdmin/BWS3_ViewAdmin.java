package superAdmin_ManageAdmin;

import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS3_ViewAdmin extends BaseClass {

	@Test
	public static void ViewAdmin() throws Throwable {
		Thread.sleep(4000);
		ExtentReportName("View Admin");

		List("AdminMail");
		LogInfo("Searching admin email from the list");

		ViewFromList("ViewAdmin1", "ViewAdmin2", SuperAdminExcel(1, 1, "View Admin"));
		LogInfo("Added admin is found and viewed");

	}


}