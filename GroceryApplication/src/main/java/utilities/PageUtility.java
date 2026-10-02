package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDropdownWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
	}
	
	public void selectDropdownseByIndex(WebElement element, int value) {
		Select object = new Select(element);
		object.selectByIndex(value);
	}

	public void selectDropdownByVisibleText(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByVisibleText(value);
	}
	
	//assignment
	//click and scroll  methods needs to add
	public void clickByJavaScriptExecutor(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);

	}
	
	public void scrollPage(WebDriver driver,String url)
	{
		driver.navigate().to(url);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,150)","");
		js.executeScript("window.scrollBy(0,-150)","");
		
	}
	
	public void TypeByJavaScriptExecutor(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = value;",element);

	}


}
