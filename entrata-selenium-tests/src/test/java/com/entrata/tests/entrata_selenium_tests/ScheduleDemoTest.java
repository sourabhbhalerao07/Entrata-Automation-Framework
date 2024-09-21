package com.entrata.tests.entrata_selenium_tests;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.EntrataHomePage;
import PageObjects.ScheduleDempPage;
import TestComponents.BaseTest;

public class ScheduleDemoTest extends BaseTest {
	
	
	@Test
	public void scheduleDemoTest() throws IOException
	{
		ScheduleDempPage scheduleDemoPage = entrataHomePage.ScheduleDemo();
		scheduleDemoPage.fillDetails();
		
		
		
		
		
	}

}
