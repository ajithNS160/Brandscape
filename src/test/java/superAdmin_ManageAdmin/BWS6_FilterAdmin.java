package superAdmin_ManageAdmin;

import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS6_FilterAdmin extends BaseClass {


@Test
public static void FilterAdmin () throws Throwable {


	

		Thread.sleep(4000);
		ExtentReportName("Filter Admin");
		GetWebElementandClick("ManageProject");
		GetWebElementandClick("FilterButton");

		LogInfo("Filter button is clicked");

		List("FilterSearch");
		LogInfo("Project name is searching");

		ViewAndClick("FilterSearch1", "FilterSearch2", SuperAdminExcel(1, 1, "Filter Admin"));
		LogInfo("Project name is searched"); 

		GetWebElementandClick("Filter");
		LogInfo("Project name is filtered");

		GetWebElementandClick("FilterButton");
		Thread.sleep(2000);

		List("FilteredAdmin");
		LogInfo("Search admin from filtered list");

		ViewFromList("FilteredAdmin1", "FilteredAdmin2", SuperAdminExcel(1, 2, "Filter Admin"));
		LogInfo("Admin is found and viewed");


		GetWebElementandClick("FilterButton");

		LogInfo("Filter button is clicked");

		GetWebElementandClick("ClearFilter");
		LogInfo("Filtered is cleared");

		GetWebElementandClick("FilterButton");



	}
}