package springSelenium.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import springSelenium.common.BasePage;

@Lazy
@Component
public class YahooHomePage extends BasePage {
	
	@Value("${yahoo.home.url}")
	private String baseUrl;

	/*********** elements of interest ***************/
	@FindBy(id = "Header")
	private List<WebElement> headers;
	
	@FindBy(id ="ybar-sbq")
	private WebElement searchTextField;
	
	@FindBy(id="ybar-search")
	private WebElement searchButton;
	
	/*********** elements of interest end ***************/
	
	public YahooHomePage loadHomePage() {
		//default will block until page completed the load
		webDriver.get(baseUrl);
		
		return this;
	}
	
	/********* assert method ********/
	public List<WebElement> getHeaders(){
		return this.headers;
	}
	public boolean hasHeader(String id) {
		return !this.getHeaders().isEmpty();
	}
	
	public WebElement getSearchTextField() {
		return this.searchTextField;
	}
	
	public WebElement getSearchButtotn() {
		return this.searchButton;
	}
	
}
