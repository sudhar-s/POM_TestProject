package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest
{
	@BeforeClass
	public void clickRegisterLinkTest()
	{
		 registerpage = homepage.doClickRegisterLink();	
	}
	
	@Test(priority=1)
	public String titleTest()
	{
		String title = registerpage.getPageTitle();
		System.out.println("--< Page Title is : " + title);
		return title;
	}
	
	@Test(priority=2)
	public void pageHeadersTest()
	{
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(registerpage.isHeaderPageHeaderVisible());
		sa.assertTrue(registerpage.isHeaderPersonalDetailsHeaderVisible());
		sa.assertTrue(registerpage.isHeaderYourPasswordHeaderVisible());
		sa.assertTrue(registerpage.isHeaderNewsLetterHeaderVisible());
		sa.assertAll();
	}
	
	@Test(priority=3)
	public void pageLabelsTest()
	{
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(registerpage.isLabelFirstNameLabelVisible());
		sa.assertTrue(registerpage.isLabelLastNameLabelVisible());
		sa.assertTrue(registerpage.isLabelEmailLabelVisible());
		sa.assertTrue(registerpage.isLabelTelephoneLabelVisible());
		sa.assertTrue(registerpage.isLabelPasswordLabelVisible());
		sa.assertTrue(registerpage.isLabelConfirmPasswordLabelVisible());
		sa.assertTrue(registerpage.isLabelPrivacyPolicyDisplayed());
		sa.assertAll();
	}
	
	@Test(priority=4)
	public void pageFieldsTest()
	{
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(registerpage.isTextBoxFirstNameTextBoxVisible());
		sa.assertTrue(registerpage.isTextBoxLastNameTextBoxVisible());
		sa.assertTrue(registerpage.isTextBoxEmailTextBoxVisible());
		sa.assertTrue(registerpage.isTextBoxTelephoneTextBoxVisible());
		sa.assertTrue(registerpage.isTextBoxPasswordTextBoxVisible());
		sa.assertTrue(registerpage.isTextBoxConfirmPasswordTextBoxVisible());
		sa.assertTrue(registerpage.isRadioButtonYesRadioButtonVisible());
		sa.assertTrue(registerpage.isRadioButtonNoRadioButtonVisible());
		sa.assertTrue(registerpage.isCheckBoxPrivacyPolicyCheckBoxVisible());
		sa.assertTrue(registerpage.isButtonContinueButtonDisplayed());
		sa.assertAll();
	}
	
	@Test(priority=5)
	public void radioButtonsTest()
	{
		List<String> radioButtonsLabel = registerpage.isLabelRadioButtonsLabelVisible();
		System.out.println("--< Radio button labels :");
		for(int i=0; i<radioButtonsLabel.size(); i++)
		{
			String text = radioButtonsLabel.get(i);
			System.out.println(text);
			if(text.equals("Yes")||text.equals("No"))
				Assert.assertTrue(true);
			else
				System.out.println("Radio Button label not found");
		}
		//radioButtonsLabel.forEach(s -> System.out.println(s));
		System.out.println("--< >--");
	}
	
	@Test(priority=6)
	public void rightSideLinksTest()
	{
		List<String> rightSidelinks = registerpage.getRightSideLinks();
		System.out.println("--< Links at right side:");
		rightSidelinks.forEach(s -> System.out.println(s));
		System.out.println("--< >--");
	}
	
	@DataProvider
	public Object[][] getRegisterData()
	{
		Object[][] testData = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return testData;
	}
	
	@Test(dataProvider = "getRegisterData", enabled = true)
	public void accountRegistrationTest(String fn, String ln, String subscribe)
	{
		Assert.assertTrue(registerpage.accountRegistration(fn, ln, subscribe));
		System.out.println("");
	}
	
	/*@Test(enabled = false)
	public void registration()
	{
		Assert.assertTrue(registerpage.accountRegistration("adfe", "aue", "6443658", "reqw123", "yes"));
	}*/
}
