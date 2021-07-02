package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	static WebDriver driver;
	static java.util.List<WebElement> row;
	static String XpathFileLocation = "F:\\Brandscape\\BrandscapeAutomation\\src\\test\\java\\xPath\\try.properties";
	static String SuperAdminExcelLocation = "F:\\Brandscape\\BrandscapeAutomation\\BrandscapeExcel\\SuperAdmin.xlsx";
	static String AdminExcelLocation = "F:\\Brandscape\\BrandscapeAutomation\\BrandscapeExcel\\Admin.xlsx";
	static int a;
	static ExtentHtmlReporter htmlreporter;
	static ExtentReports extent;
	static ExtentTest extenttest;
	static int rowcount;
	static ChromeOptions options ;

	public static void LaunchURLinChromeDriver(String URL ) throws Throwable {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Work Account\\Downloads\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String url = Prop.getProperty(URL);
		driver.get(url);
	}

	public static void LaunchPWAURLinChromeDriver(String URL ) throws Throwable {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Work Account\\Downloads\\chromedriver\\chromedriver.exe");



		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String url = Prop.getProperty(URL);
		driver.get(url);


	}

	public static void AlertPopup() {
		options.addArguments("disable-notifications");
	}

	public static  void Scroll(String LoadXpath) throws Throwable {

		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath = Prop.getProperty(LoadXpath);
		WebElement elem = driver.findElement(By.xpath(Xpath));


		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", elem);


	}


	public static void LaunchURLinFirefoxDriver(String URL ) throws Throwable {

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Work Account\\Downloads\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String url = Prop.getProperty(URL);
		driver.get(url);
	}


	public static void Extentreport(String Docname, String Result, String Testedby, String ReportPath ) {
		String reportpath = ReportPath;
		String path = System.getProperty("user.dir") + reportpath ;
		htmlreporter = new ExtentHtmlReporter(path);
		htmlreporter.config().setEncoding("utf-8");
		htmlreporter.config().setDocumentTitle(Docname);
		htmlreporter.config().setReportName(Result);
		htmlreporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.setSystemInfo("Tester", Testedby);
		extent.setSystemInfo("browser", "chrome");
		extent.attachReporter(htmlreporter);
	}

	public static void ExtentReportName(String ReportName) {
		extenttest = extent.createTest(ReportName);

	}
	public static void LogInfo(String Explanation) {

		extenttest.log(Status.INFO, Explanation);
	}

	public static void flush() {
		extent.flush();
	}

	public static void TimeWait() {
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	}
	
	public static void ExplicitTimeWait(String LoadXpath) {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	WebElement sp= 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LoadXpath)));
	sp.click();
	}
	public static WebElement GetWebElement(String LoadXpath) throws Throwable {

		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);

		String Xpath = Prop.getProperty(LoadXpath);
		System.out.println(LoadXpath);
		System.out.println(Xpath);
		WebElement element = 	driver.findElement(By.xpath(Xpath));

		return element;
	}
	public static  void Select(String LoadXpath) throws Throwable {


		WebElement element = 	driver.findElement(By.xpath("//div[contains(text(),"+"'"+LoadXpath+"'"+")]"));
		element.click();


	}
	
	public static  void LinkText(String LoadXpath) throws Throwable {


		WebElement element = 	driver.findElement(By.linkText(LoadXpath));
		element.click();


	}

	public static WebElement GetElement(WebElement elem) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", elem);
		return elem;
	}

	public static WebElement GetWebElementandClick(String LoadXpath) throws Throwable {

		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath = Prop.getProperty(LoadXpath);
		WebElement elem = driver.findElement(By.xpath(Xpath));

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", elem);
		return elem;
	}

	public static String GetText(String LoadXpath) throws Throwable {
		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);

		String Xpath = Prop.getProperty(LoadXpath);
		System.out.println(LoadXpath);
		System.out.println(Xpath);
		WebElement element = 	driver.findElement(By.xpath(Xpath));
		return element.getText();
	}
	
	public static String GetText1(String LoadXpath) throws Throwable {
		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);

		String Xpath = Prop.getProperty(LoadXpath);
		System.out.println(LoadXpath);
		System.out.println(Xpath);
		WebElement element = 	driver.findElement(By.xpath(Xpath));
	String e = element.getText();
	System.err.println(e);
	return e;
	}

	public static void TakeScreenshot(String Location) throws Throwable {

		File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, new File(Location));
	}

	public static String SuperAdminExcel(int row, int col, String sheetname) throws Throwable {
		File file = new File(SuperAdminExcelLocation);
		FileInputStream fis = new FileInputStream(file);
		Workbook W = WorkbookFactory.create(fis);
		Sheet S = W.getSheet(sheetname);
		Row r = S.getRow(row);
		Cell s = r.getCell(col);
		String data = s.toString();
		return data;
	}
	public static String AdminExcel(int row, int col, String sheetname) throws Throwable {
		File file = new File(AdminExcelLocation);
		FileInputStream fis = new FileInputStream(file);
		Workbook W = WorkbookFactory.create(fis);
		Sheet S = W.getSheet(sheetname);
		Row r = S.getRow(row);
		Cell s = r.getCell(col);
		String data = s.toString();
		return data;
	}



//	public static WebElement CheckElementDisplay(String LoadXpath) throws Throwable {
//
//		Properties Prop = new Properties();
//		File Location = new File(XpathFileLocation);
//		System.out.println(XpathFileLocation);
//		FileReader File = new FileReader(Location);
//		Prop.load(File);
//		String Xpath = Prop.getProperty(LoadXpath);
//	//	Displayelement = driver.findElement(By.xpath(Xpath));
//		//return Displayelement;
//	}

	public static void ConditionPass(String Text) throws Throwable {

		System.out.println(Text);

	}

	public static void ConditionFail(String Text) throws Throwable {

		System.out.println(Text);

	}

	public static void TypeInput (WebElement Element , String Data ) {

		Element.sendKeys(Data);
	} 
	public static void TypeDataInTheElement ( String LoadXpath ,  String Data) throws Throwable {
		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath = Prop.getProperty(LoadXpath);
		WebElement Element = 	driver.findElement(By.xpath(Xpath));
		Element.sendKeys(Data);

	} 



	public static void ClickWebElement(WebElement Element) {

		Element.click();
	}



	public static void PrintOutput(String OutputText ) {
		System.out.println(OutputText);
	}
	public static void List(String LoadXpath ) throws Throwable {
		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath = Prop.getProperty(LoadXpath);


		List<WebElement> allrow= 	driver.findElements(By.xpath(Xpath)); 
		rowcount = allrow.size(); 

	}

	public static void ViewFromList(String LoadXpath1 , String LoadXpath2 , String Emails ) throws Throwable {

		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath1 = Prop.getProperty(LoadXpath1);
		String Xpath2 = Prop.getProperty(LoadXpath2);

		for (int i = 1; i<=rowcount; i++ )		{	

			WebElement row = driver.findElement(By.xpath(Xpath1 + i + Xpath2));

			String AdminEmail = row.getText();
			if(AdminEmail.equalsIgnoreCase(Emails)) {
				System.err.println(AdminEmail); 
				break; 
			}		
		}}

	public static void View(String LoadXpath1 , String LoadXpath2   ) throws Throwable {

		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath1 = Prop.getProperty(LoadXpath1);
		String Xpath2 = Prop.getProperty(LoadXpath2);


		for (int i = 1; i<=rowcount; i++ )		{	

			WebElement row = driver.findElement(By.xpath(Xpath1 + i + Xpath2));

			String Email = row.getText();
			System.err.println(Email); 
		}
	}

	public static void ViewAndClick(String LoadXpath1 , String LoadXpath2 , String Emails ) throws Throwable {

		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath1 = Prop.getProperty(LoadXpath1);
		String Xpath2 = Prop.getProperty(LoadXpath2);

		for (int i = 1; i<=rowcount; i++ )		{	

			WebElement row = driver.findElement(By.xpath(Xpath1 + i + Xpath2));

			String AdminEmail = row.getText();
			System.out.println(AdminEmail);
			if(AdminEmail.equalsIgnoreCase(Emails)) {
				row.click();
				break; 
			}		
		}}
	
	public static java.util.List<WebElement> ViewAndGetText(String LoadXpath1 , String LoadXpath2) throws Throwable {
		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath1 = Prop.getProperty(LoadXpath1);
		String Xpath2 = Prop.getProperty(LoadXpath2);

		for (int i = 1; i<=rowcount; i++ )		{	

			 row = (java.util.List<WebElement>) driver.findElement(By.xpath(Xpath1 + i + Xpath2));
		}
		return row;
	}

	public static void TryandClick(String LoadXpath ) throws Throwable {

		try {
			GetWebElementandClick(LoadXpath);
		} catch (StaleElementReferenceException e) {
			GetWebElementandClick(LoadXpath);
		}
	}
	public static void EditFromList(String LoadXpath1 , String LoadXpath2 ,String LoadXpath3 , String LoadXpath4 , String Emails  ) throws Throwable {


		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath1 = Prop.getProperty(LoadXpath1);
		String Xpath2 = Prop.getProperty(LoadXpath2);
		String Xpath3 = Prop.getProperty(LoadXpath3);
		String Xpath4 = Prop.getProperty(LoadXpath4);

		for (int i = 1; i<=rowcount; i++ )		{	

			WebElement row = driver.findElement(By.xpath(Xpath1 + i + Xpath2));
			System.out.println(row);
			String AdminEmail = row.getText();
			System.out.println(AdminEmail);
			if(AdminEmail.equalsIgnoreCase(Emails)) {
				WebElement edit = driver.findElement(By.xpath(Xpath3 + i + Xpath4));
				edit.click();

				break; 
			}
		}}

	public static void AttenLiveSurvey(String LoadXpath1 , String LoadXpath2 ,String LoadXpath3 , String LoadXpath4 , String Emails  ) throws Throwable {


		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath1 = Prop.getProperty(LoadXpath1);
		String Xpath2 = Prop.getProperty(LoadXpath2);
		String Xpath3 = Prop.getProperty(LoadXpath3);
		String Xpath4 = Prop.getProperty(LoadXpath4);

		for (int i = 1; i<=rowcount; i++ )		{	

			WebElement row = driver.findElement(By.xpath(Xpath1 + i + Xpath2));
			System.out.println(row);
			String AdminEmail = row.getText();
			System.out.println(AdminEmail);
			if(AdminEmail.equalsIgnoreCase(Emails)) {
				WebElement edit = driver.findElement(By.xpath(Xpath3 + i + Xpath4));
				edit.click();

				break; 
			}
		}}

	public static void FilteredProject (String LoadXpath1 , String LoadXpath2 ,String LoadXpath3 , String LoadXpath4 , String ProjectStatus  ) throws Throwable {


		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath1 = Prop.getProperty(LoadXpath1);
		String Xpath2 = Prop.getProperty(LoadXpath2);
		String Xpath3 = Prop.getProperty(LoadXpath3);
		String Xpath4 = Prop.getProperty(LoadXpath4);

		for (int i = 1; i<=rowcount; i++ )		{	

			WebElement row = driver.findElement(By.xpath(Xpath1 + i + Xpath2));
			System.out.println(row);
			String ProjectStatus1 = row.getText();
			System.out.println(ProjectStatus1);
			if(ProjectStatus1.equalsIgnoreCase(ProjectStatus)) {
				WebElement ProjectName = driver.findElement(By.xpath(Xpath3 + i + Xpath4));
				System.out.println(ProjectName); 
			}
		}}

	public static void DeleteFromList(String LoadXpath1 , String LoadXpath2 ,String LoadXpath3 , String LoadXpath4 , String Emails  ) throws Throwable {


		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath1 = Prop.getProperty(LoadXpath1);
		String Xpath2 = Prop.getProperty(LoadXpath2);
		String Xpath3 = Prop.getProperty(LoadXpath3);
		String Xpath4 = Prop.getProperty(LoadXpath4);

		for (int i = 1; i<=rowcount; i++ )		{	

			WebElement row = driver.findElement(By.xpath(Xpath1 + i + Xpath2));
			System.out.println(row);
			String AdminEmail = row.getText();
			System.out.println(AdminEmail);
			if(AdminEmail.equalsIgnoreCase(Emails)) {
				WebElement edit = driver.findElement(By.xpath(Xpath3 + i + Xpath4));
				edit.click();

				break; 
			}
		}}
	public static void ViewFromLists(String LoadXpath1 , String LoadXpath2) throws Throwable {

		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath1 = Prop.getProperty(LoadXpath1);
		String Xpath2 = Prop.getProperty(LoadXpath2);

		for (int i = 1; i<=rowcount; i++ )		{	

			WebElement row = driver.findElement(By.xpath(Xpath1 + i + Xpath2));
			String AdminEmail = row.getText();
			System.out.println(AdminEmail);
		}		
	}

	public static void ClickFromList(String LoadXpath2 , String LoadXpath3 , String Emails ) throws Throwable {

		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath2 = Prop.getProperty(LoadXpath2);
		String Xpath3 = Prop.getProperty(LoadXpath3);

		for (int i = 1; i<=rowcount; i++ )		{	

			WebElement row = driver.findElement(By.xpath(Xpath2 + i + Xpath3));
			String AdminEmail = row.getText();
			if(AdminEmail.equalsIgnoreCase(Emails)) {

				row.click();
				break; 
			}	System.out.println(AdminEmail); 	
		}}


	public static void DropdownList(String LoadXpath , String TypeOfStudy ) throws Throwable {
		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath = Prop.getProperty(LoadXpath);
		WebElement wh = driver.findElement(By.xpath(Xpath));
		Select w1 = new Select(wh);
		w1.selectByValue(TypeOfStudy);

	}
	public static void Year(String LoadXpath , String Emails ) throws Throwable {

		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);

		String Xpath = Prop.getProperty(LoadXpath);
		System.out.println(LoadXpath);
		System.out.println(Xpath);
		WebElement element = 	driver.findElement(By.xpath(Xpath));
		String s = 	 element.getText();
		if(s.equalsIgnoreCase(Emails)) {
			System.out.println(s);
		}else {
			element.click();
		}}

	public static void Month(String LoadXpath , String Emails ) throws Throwable {

		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);

		String Xpath = Prop.getProperty(LoadXpath);
		System.out.println(LoadXpath);
		System.out.println(Xpath);
		WebElement element = 	driver.findElement(By.xpath(Xpath));
		String s = 	 element.getText();
		if(s.equalsIgnoreCase(Emails)) {
			System.out.println(s);
		}else {
			element.click();
		}}


	public static String GetTexdt(String LoadXpath) throws Throwable {
		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);

		String Xpath = Prop.getProperty(LoadXpath);
		System.out.println(LoadXpath);
		System.out.println(Xpath);
		WebElement element = 	driver.findElement(By.xpath(Xpath));
		String s = 	 element.getText();
		System.out.println(s);
		return s;

	}
	public static  void Mouse(String LoadXpath) throws InterruptedException, Throwable {
		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath = Prop.getProperty(LoadXpath);
		System.out.println(LoadXpath);
		System.out.println(Xpath);
		WebElement searchBtn = 	driver.findElement(By.xpath(Xpath));
		  
	      Actions actionProvider = new Actions(driver);
	  
	      actionProvider.doubleClick(searchBtn).perform();
}
	
	public static void Dropdown(String LoadXpath , String Value ) throws Throwable {
		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath = Prop.getProperty(LoadXpath);
		 WebElement wh = driver.findElement(By.xpath(Xpath));
		   	Select w1 = new Select(wh);
		   	w1.selectByValue(Value);
	}
	
	
	public static  List<WebElement> Calendar(String LoadXpath , String Date ) throws Throwable {
		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath = Prop.getProperty(LoadXpath);


		List<WebElement> dates= 	driver.findElements(By.xpath(Xpath)); 
		rowcount = dates.size();
		
		for (WebElement we : dates) {

			if (we.getText().equals(Date)) {
				we.click();
				break;
}
		}
		return dates;
		}	
	
	public static  void ViewAll(String LoadXpath ) throws Throwable {
				Properties Prop = new Properties();
				File Location = new File(XpathFileLocation);
				System.out.println(XpathFileLocation);
				FileReader File = new FileReader(Location);
				Prop.load(File);
				String Xpath = Prop.getProperty(LoadXpath);


				List<WebElement> dates= 	driver.findElements(By.xpath(Xpath)); 
				rowcount = dates.size();
				System.err.println(rowcount);
				for (WebElement we : dates) {

		String UserEmail	=	we.getText();
				System.err.println(UserEmail);

		}

		
	}}



