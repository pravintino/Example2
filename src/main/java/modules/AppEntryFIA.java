package modules;


import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utility.ExcelUtils;



public class AppEntryFIA {
	
	        WebDriver  driver;
	        WebDriverWait wait;
	        @BeforeSuite
	        public void beforeMethod1() throws Exception {
		    String exePath = "D:\\TINO\\Selenium PACK\\Installing Selenium\\3. Download Selenium WebDriver Java client (Chrome, IE, etc)\\Browsers\\IE\\32BIT\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", exePath);	
		    driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    wait = new WebDriverWait(driver, 30);
			 }


	
	        @Test
		    public void AuthenticationAndAccessControl() throws Exception {
	      	utility.ExcelUtils.setExcelFile("D:\\TINO\\Selenium PACK\\Selemium WorkSpace\\DOCS\\App Entry.xlsx", "AuthenticationAndAccessControl");
			driver.get("https://alip-proxy.asw.accenture.com/pruat3/en/Login.jsp");
 			wait.until(ExpectedConditions.elementToBeClickable(pageObjects.AuthenticationAndAccessControl.Signin(driver)));
 			pageObjects.AuthenticationAndAccessControl.Username(driver).sendKeys(utility.ExcelUtils.getCellData(14, 6));
			pageObjects.AuthenticationAndAccessControl.Password(driver).sendKeys(utility.ExcelUtils.getCellData(14, 7));
			pageObjects.AuthenticationAndAccessControl.Signin(driver).click();
	        }
	        @Test(dependsOnMethods={"AuthenticationAndAccessControl"})
	        public void LifeInsuranceAndAnnuityPlatform() throws Exception {
			utility.ExcelUtils.setExcelFile("D:\\TINO\\Selenium PACK\\Selemium WorkSpace\\DOCS\\App Entry.xlsx", "LifeInsuranceAndAnnuityPlatform");
			wait.until(ExpectedConditions.elementToBeClickable(pageObjects.LifeInsuranceAndAnnuityPlatformSignIn.Enter(driver)));
			pageObjects.LifeInsuranceAndAnnuityPlatformSignIn.UserID(driver).sendKeys(utility.ExcelUtils.getCellData(14, 6));
			pageObjects.LifeInsuranceAndAnnuityPlatformSignIn.Password(driver).sendKeys(utility.ExcelUtils.getCellData(14, 7));
			pageObjects.LifeInsuranceAndAnnuityPlatformSignIn.Enter(driver).click();
	        }

	        @Test(dependsOnMethods={"LifeInsuranceAndAnnuityPlatform"})
	        public void AccountWelcome() throws Exception {
	        wait.until(ExpectedConditions.elementToBeClickable(pageObjects.AccountWelcome.Applications(driver)));
			Actions action = new Actions(driver);
			WebElement Application = pageObjects.AccountWelcome.Applications(driver);
			WebElement NewApplication = pageObjects.AccountWelcome.NewApplication(driver);
			action.moveToElement(Application).perform();
			action.moveToElement(NewApplication);
			action.click();
			action.perform();
	}
	        @Test (dependsOnMethods={"AccountWelcome"})
	        public void ApplicationDefingQuestionnaire() throws Exception {
	        utility.ExcelUtils.setExcelFile("D:\\TINO\\Selenium PACK\\Selemium WorkSpace\\DOCS\\App Entry.xlsx", "ApplicationDefingQuestionnaire");
	        driver.switchTo().frame("containerIframe");
	        wait.until(ExpectedConditions.elementToBeClickable(pageObjects.ApplicationDefingQuestionnaire.Next(driver)));
	        Select oSelect = new Select(pageObjects.ApplicationDefingQuestionnaire.ProductType(driver));
	        oSelect.selectByVisibleText(utility.ExcelUtils.getCellData(14, 6));
	        Select oSelect1 = new Select(pageObjects.ApplicationDefingQuestionnaire.IssuingCarrier(driver));
	        oSelect1.selectByVisibleText(utility.ExcelUtils.getCellData(14, 7));
	        Select oSelect2 = new Select(pageObjects.ApplicationDefingQuestionnaire.ProductbyCarrier(driver));
	        oSelect2.selectByVisibleText(utility.ExcelUtils.getCellData(14, 8));
	        wait.until(ExpectedConditions.elementToBeClickable(pageObjects.ApplicationDefingQuestionnaire.ApplicationState(driver)));
	        Select oSelect3 = new Select(pageObjects.ApplicationDefingQuestionnaire.ApplicationState(driver));
	        oSelect3.selectByVisibleText(utility.ExcelUtils.getCellData(14, 9));
	        pageObjects.ApplicationDefingQuestionnaire.ApplicationReceivedDateMM(driver).sendKeys(utility.ExcelUtils.getCellData(14, 10));
	        pageObjects.ApplicationDefingQuestionnaire.ApplicationReceivedDateDD(driver).sendKeys(utility.ExcelUtils.getCellData(14, 11));
	        pageObjects.ApplicationDefingQuestionnaire.ApplicationReceivedDateYYYY(driver).sendKeys(utility.ExcelUtils.getCellData(14, 12));
	        pageObjects.ApplicationDefingQuestionnaire.ApplicationSignedDateMM(driver).sendKeys(utility.ExcelUtils.getCellData(14, 13));
	        pageObjects.ApplicationDefingQuestionnaire.ApplicationSignedDateDD(driver).sendKeys(utility.ExcelUtils.getCellData(14, 14));
	        pageObjects.ApplicationDefingQuestionnaire.ApplicationSignedDateYYYY(driver).sendKeys(utility.ExcelUtils.getCellData(14, 15));
	        Select oSelect4 = new Select(pageObjects.ApplicationDefingQuestionnaire.MarketCode(driver));
	        oSelect4.selectByVisibleText(utility.ExcelUtils.getCellData(14, 16));
	        pageObjects.ApplicationDefingQuestionnaire.Next(driver).click();
	        }
	        
	        @Test (dependsOnMethods={"ApplicationDefingQuestionnaire"})
	        public void CLTApplicaionOwnerInformationNewFIA(){
	        	
            }
}