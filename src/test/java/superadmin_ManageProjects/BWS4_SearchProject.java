package superadmin_ManageProjects;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS4_SearchProject extends BaseClass {


	@Test()
	public static void SearchProject() throws Throwable {

	


	
		ExtentReportName("Search Project");
		Thread.sleep(4000);
		GetWebElementandClick("ManageProject");
		Thread.sleep(4000);  
		TypeDataInTheElement("SearchProject", SuperAdminExcel(1, 1, "Search Project"));

		List("SearchProjectName");
		LogInfo("Searching admin email from the list");
		Thread.sleep(3000);
		ViewFromList("SearchProjectName1", "SearchProjectName2", SuperAdminExcel(1, 1, "Search Project"));
		LogInfo("Search admin is found and viewed");
		
		


		Thread.sleep(10000);
		WebElement CancelSearch =  GetWebElementandClick("CancelProjectSearch");
		if(CancelSearch.isDisplayed()) {
			CancelSearch.click();
		}else {
			ConditionFail("Not displayed");
		}
	}}
