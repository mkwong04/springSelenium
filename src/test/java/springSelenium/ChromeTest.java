package springSelenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import springSelenium.common.BaseTest;
import springSelenium.pages.YahooHomePage;
import springSelenium.steps.YahooHomePageSteps;


class ChromeTest extends BaseTest{


	@Lazy
	@Autowired
	public YahooHomePage yahooHomePage;
	
	@Lazy
	@Autowired
	public YahooHomePageSteps yahooHomePageSteps;
	
	
	@Test
	public void testYahooPageSearch() {
		assertTrue(yahooHomePageSteps.performYahooSearch("chrome").searchResultsReturned(),"Search error");
		
	}

}
