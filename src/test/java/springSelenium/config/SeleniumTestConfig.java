package springSelenium.config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
public class SeleniumTestConfig {
	
	//wait time out, default 30 seconds
	@Value("${wait.timeout:30}")
	private int waitTimeOut;
	
	@Bean
	public WebDriver chromeDriver() {
		//to overcome chrome v111 not support the default http client
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		return new ChromeDriver();
	}
	
	@Bean 
	public WebDriverWait webDriverWait(WebDriver webDriver) {
		return new WebDriverWait(webDriver, Duration.ofMillis(this.waitTimeOut));
	}

}
