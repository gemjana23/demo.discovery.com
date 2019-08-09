package com.testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.pageobjects.HomePage;
import com.pageobjects.MyVideosPage;

public class DiscoveryTest extends BaseTest
{
	
	//Script to validate that the correct URL is being Launched
	@Test(priority=0)
	public void URLValidation()
	{
		HomePage hopg = new HomePage(driver);
		hopg.validateURL();
	}
	
	//Script to validate the Recommended Videos section 
	@Test(priority=1)
	public void validateRecommendedVideos()
	{
		HomePage hopg = new HomePage(driver);
		hopg.navigateToRecomenndedVid();
	}
	
	//Script to Add videos to Favorite List and get the corresponding Videos Title and Description
	@Test(priority=2)
	public void addVideosToFavorites()
	{
		HomePage hopg = new HomePage(driver);
		hopg.addToFavourite();
	}
	
	
	//Script to perform Assertions on the Video Title and Description from MyVideos Page
	@Test(priority=3)
	public void verifyVideos()
	{
		MyVideosPage vidpg = new MyVideosPage(driver);
		vidpg.validateFavShows();
		vidpg.validateShowTitle();
		vidpg.validateshowDesc();
	}
}