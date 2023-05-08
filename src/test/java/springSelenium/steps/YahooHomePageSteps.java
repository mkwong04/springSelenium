package springSelenium.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import springSelenium.pages.YahooHomePage;
import springSelenium.pages.YahooSearchResultPage;

@Lazy
@Component
public class YahooHomePageSteps {
	
	@Autowired
	public YahooHomePage yahooHomePage;
	
	@Autowired
	public YahooSearchResultPage resultPage;
	
	@Autowired
	public WebDriver webDriver;

	public YahooHomePageSteps performYahooSearch(String searchText) {
		WebElement searchTextField = yahooHomePage.loadHomePage().getSearchTextField();
		yahooHomePage.enterText(searchTextField, searchText);
		yahooHomePage.click(yahooHomePage.getSearchButtotn());
		

		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean searchResultsReturned() {
		// setup to wait for page refresh and title updated
		Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(1));

		wait.until(ExpectedConditions.titleContains("Search Results"));
		return !resultPage.getResultsDiv().isEmpty();
	}
}
