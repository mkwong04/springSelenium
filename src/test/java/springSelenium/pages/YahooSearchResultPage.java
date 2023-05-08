package springSelenium.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import springSelenium.common.BasePage;

@Lazy
@Component
public class YahooSearchResultPage extends BasePage {

	@FindBy(id="results")
	private List<WebElement> resultsDiv;
	
	public List<WebElement> getResultsDiv() {
		return this.resultsDiv;
	}
}
