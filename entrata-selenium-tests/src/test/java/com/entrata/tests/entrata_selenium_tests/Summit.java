package com.entrata.tests.entrata_selenium_tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import AbstractComponents.Utilities;
import PageObjects.EntrataHomePage;
import PageObjects.ScheduleDempPage;
import TestComponents.BaseTest;

public class Summit extends BaseTest {
	
	String title = "Entrata Summit 2024 | The Best Week in Multifamily Sept 23-26";
   
	@Test
	public void scheduleDemoTest() throws IOException
	{
		Utilities utilities = new Utilities(driver);
		EntrataHomePage entrataHomePage = new EntrataHomePage(driver);
		entrataHomePage.clickOnSummit();
		String Actualtitle = utilities.getTitle();
		Assert.assertEquals(Actualtitle, title);
		
		
		
	}

}
