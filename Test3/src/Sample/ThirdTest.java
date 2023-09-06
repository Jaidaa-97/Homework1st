package Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;

public class ThirdTest {

	public static void main(String[] args) throws InterruptedException {
		// Set the path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");

		// Initialize the WebDriver
		WebDriver driver = new ChromeDriver();

		// Navigate to the website
		driver.get("https://www.lancome-usa.com");
		driver.manage().window().maximize();

		// Find the "X" button element
		WebElement closeButton = driver.findElement(By.cssSelector(
				" div.c-modal.h-text-align-center.m-borderless.m-autosize-large.m-image.m-dispopup.m-opened.h-fade-in > div > button"));

		// Click on the "X" button to close the modal
		closeButton.click();

		try {
			// Find the logo element by its class name
			WebElement logoElement = driver.findElement(By.className("c-logo"));

			// Check if the logo is displayed
			if (logoElement.isDisplayed()) {
				System.out.println("Logo is displayed.");
			} else {
				System.out.println("Logo is not displayed.");
			}
		} catch (NoSuchElementException e) {
			// Handle the case where the logo element with the provided class name is not
			// found
			System.out.println("Logo element with class name 'c-logo' not found.");
		}

		// Selectors for the links
		String emailSignUpSelector = "body > div.page > footer > div.l-footer__middle > div > div > div.l-footer__content-section > div.l-footer__newsletter > div";
		String myAccountSelector = "body > div.page > header > div.l-header__inner > div.l-header__main-area-wrapper > div.l-header__main-area > div.l-header__top-nav.m-right > div.l-header__top-nav-row > div.l-header__top-nav-item.m-account > div > a";
		String myBagSelector = "body > div.page > header > div.l-header__inner > div.l-header__main-area-wrapper > div.l-header__main-area > div.l-header__top-nav.m-right > div.l-header__top-nav-row > div.l-header__top-nav-item.m-minicart > div > div > div > button > span.h-show-for-sr";

		// Get the text on the "E-mail sign up" link
		WebElement emailSignUpLink = driver.findElement(By.cssSelector(emailSignUpSelector));

		// Get the text on the "My Bag" link
		WebElement myBagLink = driver.findElement(By.cssSelector(myBagSelector));
		String myBagText = myBagLink.getText();

		// Check if the "E-mail sign up" link is displayed
		if (emailSignUpLink.isDisplayed()) {
			System.out.println("E-mail sign up link is displayed.");
		} else {
			System.out.println("E-mail sign up link is not displayed.");
		}

		// Check if the "My Bag" link is displayed
		if (myBagLink.isDisplayed()) {
			System.out.println("My bag link is displayed. Text: " + myBagText);
		} else {
			System.out.println("My bag link is not displayed.");
		}
		
		// Re-locate the "My account" link after closing the modal
		WebElement myAccountLink = driver.findElement(By.cssSelector(myAccountSelector));

		// Check if the "My account" link is displayed and click it
		if (myAccountLink.isDisplayed()) {
			System.out.println("My account link is displayed.");
			myAccountLink.click();
		} else {
			System.out.println("My account link is not displayed.");
		}

		// Get the title of the login form
		WebElement loginFormTitle = driver.findElement(By.cssSelector(
				"body > div.page > div.l-account > div > div.c-tabs.m-tertiary > div.c-tabs__content.l-account__loginregistration > div.c-tabs__panel.l-account__login-content.m-active > div > div > h2.c-account__title"));
		String formTitleText = loginFormTitle.getText();

		// Verify if the title equals "SIGN IN"
		if (formTitleText.equals("SIGN IN")) {
			System.out.println("Login form title is 'SIGN IN'.");
		} else {
			System.out.println("Login form title is not 'SIGN IN'.");
		}
		
		Thread.sleep(2000);
		// Find the email and password input fields and enter valid email and password
		WebElement emailInput = driver.findElement(By.name("email"));
		emailInput.click();
		emailInput.sendKeys("qa@tester.com");

		
		WebElement passwordInput = driver.findElement(By.name("password"));
		passwordInput.click();	
		passwordInput.sendKeys("123456789@Ja");

		// Click on the Log in button
		WebElement LogInButton = driver.findElement(By.cssSelector(
				"body > div.page > div.l-account > div > div.c-tabs.m-tertiary > div.c-tabs__content.l-account__loginregistration > div.c-tabs__panel.l-account__login-content.m-active > div > div > form > div:nth-child(10) > button"));

		// Click on the Log in button
		LogInButton.click();
		
		Thread.sleep(3000);

		// Get the title of the login form
		WebElement VerifySigningIn = driver.findElement(By.cssSelector("body > section > div.page-title-wrapper > div"));
		String pageTitleText = VerifySigningIn.getText();
		

		// Verify if the title equals "Please verify you are a human"
		if (pageTitleText.equals("Please verify you are a human")) {
			System.out.println("You are logged in successfully.");
		} else {
			System.out.println("Please check your credentials.");
		}

		Thread.sleep(3000);
		
		 //Close the browser
		driver.quit();
	}
}
