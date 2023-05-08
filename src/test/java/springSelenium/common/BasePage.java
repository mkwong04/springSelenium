package springSelenium.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;

/**
 * 
 * base class for all page to simplify and common access method
 *
 */
public abstract class BasePage {

	// use autowired to inject the Webdriver
	@Autowired
	protected WebDriver webDriver;

	@Autowired
	protected WebDriverWait wait;

	// after constructor of this class is called, use the PageFactory to initialize
	// current page object
	@PostConstruct
	private void init() {
		PageFactory.initElements(this.webDriver, this);
	}

	/******************** common methods start *******************/

	/**
	 * wait for WebElement present and visible or By.Locator element located present
	 * 
	 * @param <T>
	 * @param elementOrByLocator
	 */
	public <T> void waitElement(T elementOrByLocator) {
		// if it is a By Locator
		if (isByLocator(elementOrByLocator)) {
			wait.until(ExpectedConditions.presenceOfElementLocated((By) elementOrByLocator));
		}
		// WebElement
		else {
			wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrByLocator));
		}
	}

	/**
     * wait for WebElement(s) present and visible or By.Locator element(s) located present 
     * @param <T>
     * @param elementOrByLocator
     */
    public <T> void waitElements(T elementOrByLocator) {
    	//if it is a By Locator 
        if (isByLocator(elementOrByLocator)) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) elementOrByLocator));
        } 
        //WebElement
        else {
            wait.until(ExpectedConditions.visibilityOfAllElements((WebElement) elementOrByLocator));
        }
    }
    
    /**
     * 
     * @param <T>
     * @param elementOrByLocator
     * @param text
     */
	public <T> void enterText(T elementOrByLocator, String text){
    	//ensure element present
		waitElement(elementOrByLocator);
		//if it is a By Locator 
		if (isByLocator(elementOrByLocator)) {
			webDriver.findElement((By) elementOrByLocator)
					 .sendKeys(text);
		} else {
			((WebElement) elementOrByLocator).sendKeys(text);
		}
    }
    
	/**
	 * 
	 * @param <T>
	 * @param elementOrByLocator
	 */
	public <T> void click(T elementOrByLocator) {
		//ensure element present
		waitElement(elementOrByLocator);
		//if it is a By Locator 
		if (isByLocator(elementOrByLocator)) {
			webDriver.findElement((By) elementOrByLocator)
					  .click();
		} else {
			((WebElement) elementOrByLocator).click();
		}
	}
    /******************** common methods end *******************/
	
	
	/******** private method ********/
	/**
	 * check if is of By locator
	 * @param elementOrByLocator
	 * @return
	 */
	private boolean isByLocator(Object elementOrByLocator) {
		return elementOrByLocator
	            .getClass()
	            .getName()
	            .contains("By");
	}
}
