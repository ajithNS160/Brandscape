package admin_ManageSurvey;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS5_SearchSurvey extends BaseClass {
	
	

	@Test(priority = 5)
	public static void SearchSurvey() throws Throwable {

		ExtentReportName("Search Survey");
		Thread.sleep(4000);
		GetWebElementandClick("ManageSurvey");
		Thread.sleep(4000);  
		TypeDataInTheElement("SearchSurvey", AdminExcel(1, 1, "Search Survey"));

		List("SurveyName");
		LogInfo("Searching survey name from the list");
		Thread.sleep(3000);
		ViewFromList("SurveyName1", "SurveyName2",  AdminExcel(1, 1, "Search Survey"));
		LogInfo("Search survey is found and viewed");
		
		


		Thread.sleep(10000);
		WebElement CancelSearch =  GetWebElementandClick("CancelSurveySearch");
		if(CancelSearch.isDisplayed()) {
			CancelSearch.click();
		}else {
			ConditionFail("Not displayed");
		}
	}
	

	}
	