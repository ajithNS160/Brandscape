package client_Profile;

import org.testng.annotations.Test;

import baseClass.BaseClass;

public class PWA1_ClientProfile extends BaseClass{


	@Test
	public static void Profile() throws Throwable {

		Thread.sleep(6000);
		ExtentReportName("Profile");

		GetWebElementandClick("PWAMenu");
		GetWebElementandClick("PWAProfile");


		String PWAUserEmail = 	GetText("PWAUserEmail");

		if (PWAUserEmail.equalsIgnoreCase("")) {
			ConditionPass("Profile Matched");
			LogInfo("Profile Matched");
		}else {
			ConditionFail("Profile not Matched");
			LogInfo("Profile not Matched");
		}
		
		Thread.sleep(3000);
		GetWebElementandClick("PWABackProfile");
		
	}
	
	
}
