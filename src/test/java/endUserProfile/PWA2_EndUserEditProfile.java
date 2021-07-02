package endUserProfile;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class PWA2_EndUserEditProfile extends BaseClass {

	
	@Test
	public static void EditProfile() throws Throwable {
		
		Thread.sleep(5000);
		
		ExtentReportName("Edit Profile");

		GetWebElementandClick("PWAMenu");
		GetWebElementandClick("PWAProfile");
		GetWebElementandClick("PwaEditProfile");
		WebElement PwaEditProfileName =  GetWebElement("PwaEditProfileName");
		PwaEditProfileName.clear();
		TypeInput(PwaEditProfileName, "edited");
		GetWebElementandClick("PwaSaveUser");
		Thread.sleep(3000);
		
WebElement PwaEditSuccessfull=		GetWebElement("PwaEditSuccessfull");
		if(PwaEditSuccessfull.isDisplayed()) {
			PwaEditSuccessfull.click();
			ConditionPass("Profile edited successfully");
			LogInfo("Profile edited successfully");
		}else{
			ConditionFail("Profile not edited");
			LogInfo("Profile not edited");
		}
		
		GetWebElementandClick("PWABackProfile");
		
		
		
		
	}
}
