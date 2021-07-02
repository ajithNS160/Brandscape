package superadmin_ManageProjects;

import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS5_FilterProject extends BaseClass {





	@Test()
	public static void FilterProject() throws Throwable {



		Thread.sleep(4000);
		ExtentReportName("Filter Project");
		GetWebElementandClick("ManageProject");
		GetWebElementandClick("ProjectFilterButton");

		LogInfo("Filter button is clicked");

		List("ProjectStatus");
		LogInfo("Project status is searching");

		ViewAndClick("ProjectStatus1", "ProjectStatus2", SuperAdminExcel(1, 1, "Filter Project"));
		LogInfo("Project status is filtered"); 

		GetWebElementandClick("Filter");
		LogInfo("Project is filtered");

		
		Thread.sleep(3000);

		List("FilteredProject");
		LogInfo("Search project from filtered list");

		FilteredProject("FilteredProject1", "FilteredProject2", "ProjectName1", "ProjectName2", SuperAdminExcel(1, 1, "Filter Project"));
		LogInfo("Project is found and viewed");


	

		GetWebElementandClick("ClearFilter");
		LogInfo("Filtered is cleared");

	



	}
}