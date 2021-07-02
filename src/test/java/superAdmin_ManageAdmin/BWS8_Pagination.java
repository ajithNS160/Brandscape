package superAdmin_ManageAdmin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS8_Pagination extends BaseClass {



	@Test
	public static void Pagination() throws Throwable {


		Thread.sleep(3000);
		ExtentReportName("Pagination");

		WebElement NextButton =  GetWebElement("NextButton");

		if(NextButton.isEnabled()) {
			NextButton.click();
			LogInfo("Next button is clicked");
		}else {
			ConditionFail("Next button is not enabled thus no admin is available in next page");
			LogInfo("Next button is not enabled");
		}

		Thread.sleep(3000);
		WebElement PreviousButton =  GetWebElement("PreviousButton");
		if(PreviousButton.isEnabled()) {
			PreviousButton.click();
			LogInfo("Previous button is clicked");
		}else {
			ConditionFail("Previous button is not enabled thus superadmin is in first page only");
			LogInfo("Previous button is not enabled");
		}
	}
}
