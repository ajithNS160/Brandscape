package admin_ManageUser;

import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS3_ViewUser extends BaseClass {

	@Test
	public static void ViewUser () throws Throwable {
		
		Thread.sleep(4000);
		ExtentReportName("View User");
	

		List("AdminViewUserMail");
		LogInfo("Searching user email from the list");

		ViewFromList("AdminViewUserMail1", "AdminViewUserMail2", AdminExcel(1, 1, "View User"));
		LogInfo("Added user is found and viewed");

}
}