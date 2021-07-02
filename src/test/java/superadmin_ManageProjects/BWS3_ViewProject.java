package superadmin_ManageProjects;

import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS3_ViewProject extends BaseClass {


	@Test()
	public static void ViewProject() throws Throwable {

	

		Thread.sleep(3000);
		ExtentReportName("View Project");
		GetWebElementandClick("ManageProject");
		

		List("ViewProject");
		LogInfo("Searching project name from the list");
	
		
		ViewFromList("ViewProject1", "ViewProject2", SuperAdminExcel(1, 1, "View Project"));
		LogInfo("Added Project is found and viewed");

		
	}


	
}