package admin_ManageGroup;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS5_SearchGroup  extends BaseClass{

	
	@Test
	public static void SearchGroup() throws Throwable {
		
		ExtentReportName("Search Group");
		Thread.sleep(4000);
		GetWebElementandClick("ManageGroup");
		Thread.sleep(4000);  
		TypeDataInTheElement("SearchGroup", AdminExcel(1, 1, "Search Group"));
		

		List("GroupName");
		LogInfo("Searching Group name from the list");
		Thread.sleep(3000);
		ViewFromList("GroupName1", "GroupName2", AdminExcel(1, 1, "Search Group"));
		LogInfo("Search Group is found and viewed");
		
		


		Thread.sleep(10000);
		WebElement CancelSearch =  GetWebElementandClick("CancelGroupSearch");
		if(CancelSearch.isDisplayed()) {
			CancelSearch.click();
		}else {
			ConditionFail("Not displayed");
		}
	}
}

