package com.pageobjects;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class MyVideosPage {
	WebDriver driver;
	String VideoFavTitle, VideoFavDescription = "";
	
	public MyVideosPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2//div[contains(text(),'Shows You Might Like')]")
	public WebElement recommendedVid;
	
	@FindBy(xpath="//h2[@class='localStorageCarousel__heading']")
	public WebElement favShowsHeading;
	
	@FindBy(xpath="(//*[@class='showTileSquare__action']//span)[1]")
	public WebElement addAndRemoveFav1;
	
	@FindBy(xpath="//div//img[@class='showTileSquare__showLogoImage']")
	public List<WebElement> favShowsList;
	
	@FindBy(xpath="(//h3/div)[1]")
	public WebElement getTitle1;
	
	@FindBy(xpath="(//*[@class='showTileSquare__title']//div)[2]")
	public WebElement getTitle2;
	
	@FindBy(xpath="((//div/text())[9])[1]")
	public WebElement getDesc1;
	
	@FindBy(xpath="(//*[@class='showTileSquare__description']//div)[2]")
	public WebElement getDesc2;

	
	public void validateFavShows()
	{
		Assert.assertEquals(true, favShowsHeading.isDisplayed());
		if(true)
			Reporter.log("There are Videos available in Favourite List..", true);
		
	    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	HomePage myVidPg = new HomePage(driver);
	
			VideoFavTitle = getTitle1.getText();
			VideoFavDescription = getDesc1.getText();
			Reporter.log("Video Title : "+VideoFavTitle ,true);
			Reporter.log("Video Description :" +VideoFavDescription,true);
	}	
	
	public void validateShowTitle()
	{
		HomePage hop = new HomePage(driver);
		Assert.assertEquals(hop.VideoTitle, VideoFavTitle);
		if(true)
			Reporter.log("Title of the Video in the FavoriteList is validated : ", true);
	}
	
	public void validateshowDesc()
	{
		HomePage hopge = new HomePage(driver);
		Assert.assertEquals(hopge.VideoDescription, VideoFavDescription);
		if(true)
			Reporter.log("Description of the Video in the FavoriteList is validated : ", true);
	}
	
	
}
