package admin_ManageUser;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS5_SearchUser extends BaseClass {
@Test
	public static void SearchUser () throws Throwable {

	ExtentReportName("Search User");
	Thread.sleep(4000);

	TypeDataInTheElement("AdminSearchUser", AdminExcel(1, 1, "Search User"));

	List("SearchUserMailID");
	LogInfo("Searching user email from the list");
	Thread.sleep(3000);
	ViewFromList("SearchUserMailID1", "SearchUserMailID2", AdminExcel(1, 1, "Search User"));
	LogInfo("Search user is found and viewed");

	Thread.sleep(3000);
	WebElement AdminCancelSearchUser =  GetWebElementandClick("AdminCancelSearchUser");
	if(AdminCancelSearchUser.isDisplayed()) {
		AdminCancelSearchUser.click();
	}else {
		ConditionFail("Not displayed");
	}
}}
