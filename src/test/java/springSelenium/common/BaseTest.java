package springSelenium.common;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;

import springSelenium.Application;

/**
 * 
 * Base test class contains
 * a) autowired of application context
 * b) quiting of Webdriver at each of test case
 * 
 */
@SpringBootTest(classes = Application.class)
public abstract class BaseTest {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Lazy
	@Autowired
    public ApplicationContext applicationContext;
	
	/**
	 * reserved for setup for each @Test
	 */
	@BeforeEach
	public void setUp() {
		
	}
	
	/**
	 * properly quit the webdriver after each @Test
	 */
    @AfterEach
    public void tearDown() {
        this.applicationContext
            .getBean(WebDriver.class)
            .quit();
    }
}
