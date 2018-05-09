package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountWelcome {
	
	private static WebElement Element = null;
	
	public static WebElement Applications(WebDriver driver){
		
		return Element = driver.findElement(By.cssSelector("#a_applications"));
	}
	
	public static WebElement NewApplication(WebDriver driver){
		
		return Element = driver.findElement(By.cssSelector("#a_new_application"));
	}

}