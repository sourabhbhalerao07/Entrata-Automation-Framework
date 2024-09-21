package com.entrata.tests.entrata_selenium_tests;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.EntrataHomePage;
import PageObjects.ScheduleDempPage;
import TestComponents.BaseTest;

public class ValidateLinksFromProductsDropdown extends BaseTest {
	
	
	
	@Test
	public void validatelink() throws IOException
	{
		EntrataHomePage entrataHomePage = new EntrataHomePage(driver);
		entrataHomePage.validateAccountingLinks();
    }

}
