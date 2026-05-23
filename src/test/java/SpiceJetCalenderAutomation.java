import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SpiceJetCalenderAutomation {
	
	@Test
	public void JetTest() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-geoLocation");
		
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		By fromCityTextBoxLocator = By.xpath("//div[text() = 'From']/following-sibling::div//input");
		WebElement fromCityTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(fromCityTextBoxLocator));
		fromCityTextBox.sendKeys("Mum");
		
		By toCityTextBoxLocator = By.xpath("//div[text() = 'To']/following-sibling::div//input");
		WebElement toCityTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(toCityTextBoxLocator));
		toCityTextBox.sendKeys("Del");
		
		By calenderPickerLocator = By.xpath("//div[@data-testid = 'undefined-calendar-picker']");
		WebElement calenderPicker = wait.until(ExpectedConditions.visibilityOfElementLocated(calenderPickerLocator));
		
		By nextButtonLocator = By.xpath("(.//child::div[1]/*[@data-testid='svg-img'])[1]");
		WebElement nextButton = calenderPicker.findElement(nextButtonLocator);
		nextButton.click();
		
		LocalDate localDate = LocalDate.now();
		localDate = localDate.plusMonths(2);
		String month = localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int year = localDate.getYear();
		System.out.println(month);
		System.out.println(year);
		
		Thread.sleep(3000);
		
		By monthCalenderLocator = By.xpath("//div[@data-testid = 'undefined-month-"+month+"-"+year+"']");
		WebElement monthCalender = wait.until(ExpectedConditions.visibilityOfElementLocated(monthCalenderLocator));
		
		By dateLocator = By.xpath(".//div[contains(text(), '9')]");
		monthCalender.findElement(dateLocator).click();
		
		
	}

}
