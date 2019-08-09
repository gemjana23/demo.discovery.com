package com.pageobjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class HomePage {
	WebDriver driver;
	String VideoTitle, VideoDescription = "";
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2//div[contains(text(),'Shows You Might Like')]")
	public WebElement recommendedVid;
	
	@FindBy(xpath="//div//img[@class='showTileSquare__showLogoImage']")
	public List<WebElement> recommendedList;

	@FindBy(xpath="(//*[@class='showTileSquare__action']//span)[1]")
	public WebElement addAndRemoveFavValidate;
	
	@FindBy(xpath="(//*[@class='my-favorites-button-container']//span)[1]")
	public WebElement addAndRemoveFav1;
	
	@FindBy(xpath="(//*[@class='showTileSquare__action']//span)[3]")
	public WebElement addAndRemoveFav2;
	
	@FindBy(xpath="(//*[@class='showTileSquare__title']//div)[1]")
	public WebElement getTitle1;
	
	@FindBy(xpath="(//*[@class='showTileSquare__title']//div)[2]")
	public WebElement getTitle2;
	
	@FindBy(xpath="(//*[@class='showTileSquare__description']//div)[1]")
	public WebElement getDesc1;
	
	@FindBy(xpath="(//*[@class='showTileSquare__description']//div)[2]")
	public WebElement getDesc2;
	
	@FindBy(xpath="(//*[@class='o-Header__a-NavLink'])[7]")
	public WebElement iconMenu;
	
	@FindBy(xpath="//a[contains(text(),'My Videos')]")
	public WebElement myVid;
	
	
	public void validateURL()
	{
		String PageTitle = driver.getTitle();
		if (PageTitle.contains("Discovery"))
		Reporter.log("URL is launched",true);
		else
		Reporter.log("URL is not launched",true);	
	}
	
	public void navigateToRecomenndedVid()
	{
		Actions act = new Actions(driver);
		
		act.pause(java.time.Duration.ofSeconds(2)).moveToElement(iconMenu).click().pause(java.time.Duration.ofSeconds(1)).moveToElement(myVid).click().build().perform();
		
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
	    WebDriverWait wait=new WebDriverWait(driver,20);
	    WebElement element = wait.until(ExpectedConditions.visibilityOf(recommendedVid));
	    boolean status = element.isDisplayed();
	    if(status)
		//Assert.assertEquals(true, recommendedVid.isDisplayed());
		Reporter.log("Recommended Videos are Displayed", true);
	    
	    act.moveToElement(addAndRemoveFav1).perform();
		List<WebElement> RecommendedvideoList = driver.findElements(By.xpath("//div//img[@class='showTileSquare__showLogoImage']"));
		
		Reporter.log("List of Recommended Videos are : " +RecommendedvideoList.size(),true);

	}
	
	public void addToFavourite()
	{
		String checkAlreadyAdded = addAndRemoveFavValidate.getText();
		Assert.assertEquals(true, checkAlreadyAdded.contains("Add to Favorites"));
		if(true)
		{
			addAndRemoveFav1.click();
			Reporter.log("Video added to favourite List..", true);
			
			VideoTitle = getTitle1.getText();
			VideoDescription = getDesc1.getText();
			Reporter.log("Video Title :" +VideoTitle,true);
			Reporter.log("Video Description :" +VideoDescription,true);
		}
	}
}
