package client_Profile;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class PWA5_Logout extends BaseClass {


			@Test
			public static void ClientPendingSurvey() throws Throwable {

				Thread.sleep(5000);

				ExtentReportName("Logout");
				GetWebElementandClick("PwaLogout");
				
				Thread.sleep(5000);
				WebElement PWAEmail =	GetWebElement("PWAEmail");
				if(PWAEmail.isDisplayed()) {
					
					ConditionPass("Logout successfull");
					LogInfo("Logout successfull");
				}else {
					ConditionFail("Logout Failed");
					LogInfo("Logout Failed");
				}
				
				
}
}