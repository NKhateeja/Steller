package com.banking.StaffModule.ViewAccount;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ViewActiveAccountTest {

	public static void main(String[] args) {
		//Open the browser
				System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
				WebDriver driver=new ChromeDriver();
						
				//maximizing the browser
				driver.manage().window().maximize();
						
				//1.navigating to the application
				String url="http://rmgtestingserver/domain/Online_Banking_System/";
				driver.get(url);
						
				//2.click on open account button
				driver.findElement(By.xpath("//a[.='Open Account']")).click();
						
				//3.verifying online account opening form is displaying 
				String url1 = driver.getCurrentUrl();
				//System.out.println(url);
				if(url1.contains("customer_reg_form"))
						System.out.println("online account opening form is displaying");
				else
						System.out.println("online account opening form is not displaying");
						
				//Entering account holder name in Name text field
				driver.findElement(By.name("name")).sendKeys("Happe C");
						
						//selecting male from gender dropdown
						WebElement gender = driver.findElement(By.name("gender"));
						gender.click();
						Select s=new Select(gender);
						s.selectByVisibleText("Male");
						
						//Enter mobile number in Mobile no text field
						driver.findElement(By.name("mobile")).sendKeys("9876543210");
						
						//Enter emailid in Email id text field
						driver.findElement(By.name("email")).sendKeys("HappyS@gmail.com");
						
						//Enter Landline no in Landline no text field
						driver.findElement(By.name("landline")).sendKeys("254698");
						
						////Enter DateofBirth no in DateofBirth no text field
						WebElement DOB = driver.findElement(By.name("dob"));
						DOB.click();
						DOB.sendKeys("01");
						DOB.sendKeys("01");
						DOB.sendKeys("2000");
						
						//Enter PAN no in PAN Number text field
						driver.findElement(By.name("pan_no")).sendKeys("PAN123455");
						
						//Enter citizenship number in Citizenship Number text field
						driver.findElement(By.name("citizenship")).sendKeys("5879621");
						
						//Enter home address in Home Address text field
						driver.findElement(By.name("homeaddrs")).sendKeys("#234");
						
						//Enter office address in Office Address text field
						driver.findElement(By.name("officeaddrs")).sendKeys("#254/8,5th floor,San Diego,Florida, US");
						
						//selecting state Florida from state dropdown
						WebElement state = driver.findElement(By.name("state"));
						state.click();
						Select s1=new Select(state);
						s1.selectByVisibleText("Florida");
						
						//Selecting City San Diego from city dropdown
						WebElement city = driver.findElement(By.name("city"));
						city.click();
						Select s2=new Select(city);
						s2.selectByVisibleText("San Diego");
						
						//Enter PinCode number in PinCode text field
						driver.findElement(By.name("pin")).sendKeys("536987");
						
						//Enter Area name in area text field
						driver.findElement(By.name("arealoc")).sendKeys("Area");
						
						//Enter Nominee name as Riya in Nominee Text field
						driver.findElement(By.name("nominee_name")).sendKeys("Riya");
						
						//Enter Nominee Account number in Nominee Account no text filed
						driver.findElement(By.name("nominee_ac_no")).sendKeys("123654797135");
						
						//Selecting Account type as savings from Account Type dropdown
						WebElement AcType = driver.findElement(By.name("acctype"));
						AcType.click();
						Select s3=new Select(AcType);
						s3.selectByVisibleText("Saving");
						
						//click on submitt button
						driver.findElement(By.name("submit")).click();
						
						//verifying confirmation window is displayed or not
						String url2 = driver.getCurrentUrl();
						//System.out.println(url2);
						if(url2.contains("cust_regfrm_confirm"))
						
							System.out.println("Confirmation window is displayed");
						else
							System.out.println("Confirmation window is not displayed");
						
						//click on confirm btn
						driver.findElement(By.xpath("//input[@value='Confirm']")).click();
						
						//verifying popup is displayed or not
						Alert a = driver.switchTo().alert();
						
						//Getting the text of popup
						String text = a.getText();
						if(text.contains("Application submitted successfully"))
							System.out.println("Application submitted successfully popup is displayed");
						System.out.println();
						
						//Printing the text on the consloe
						//System.out.println("The text of popup is"+"\n"+text);
						
						//clicking the ok button on alert popup
						a.accept();
						
						//converting a string into array
						String alltext[]=text.split(" ");
						//fetching application number
						String Appno=alltext[5].substring(0, 9);
						System.out.println("Application number is "+Appno);
						
						//Verify User home page is displayed or nor
						String url4 = driver.getCurrentUrl();
						//System.out.println(url4);
						if(url4.contains("index"))
							System.out.println("User home page is displayed");
				
						//click on staff login link
						driver.findElement(By.xpath("//a[.='Staff Login']")).click();
						
						//verifying staff login page is displayed or not
						String staffurl = driver.getCurrentUrl();
						if(staffurl.contains("staff_login"))
							System.out.println("Staff login page is displayed");
						else
							System.out.println("Staff login page is not displayed");
						
						
						//Enter staff id as "210001" in staff ID text field
						driver.findElement(By.name("staff_id")).sendKeys("210001");
						
						//Enter password as "password" in password text field
						driver.findElement(By.name("password")).sendKeys("password");
						
						//click on login button
						driver.findElement(By.name("staff_login-btn")).click();
						
						
						//verify whether home page is displayed or not
						String homeurl = driver.getCurrentUrl();
						if(homeurl.contains("staff_profile"))
							System.out.println("Staff home page is displayed");
						else 
							System.out.println("Staff home page is not dislplayed");
						
						//click on approve pending account button
						driver.findElement(By.name("apprvac")).click();
						
						//Enter the application number in Application Number text field
						driver.findElement(By.name("application_no")).sendKeys(Appno);
						
						//click on search button
						driver.findElement(By.name("search_application")).click();
						
						//verify application details displayed or not
						boolean b = driver.findElement(By.xpath("//td[.='"+Appno+"']")).isDisplayed();
						if(b)
						{
							System.out.println("Application details are displayed");
						}
						else
							System.out.println("Application details are not displayed");
						
						//click on approve button
						driver.findElement(By.name("approve_cust")).click();
						
						//verifying whether popup is displayed or not
						Alert a1 = driver.switchTo().alert();
						
						//Getting the text of popup
						String text1 = a1.getText();
						if(text1.contains("Account Created Successfully"))
							System.out.println("Account Created Successfully popup is displayed");
						System.out.println();
						
						//clicking the ok button on alert popup
						a.accept();
						
						//converting a string into array
						String alltext1[]=text1.split(" ");
//						for(int i=0;i<alltext1.length;i++)
//						{
//							System.out.println(i+"---->"+alltext1[i]);
//						}
						
						//Getting account number
						String AccountNumber = alltext1[4].substring(1,14);
						System.out.println(AccountNumber);
						
						//verifying whether no pending application page is displayed or not
						String NoPenAppUrl = driver.getCurrentUrl();
						if(NoPenAppUrl.contains("pending_customers"))
						{
							System.out.println("No pending application page is displayed");
						}
						else
						{
							System.out.println("No pending application page is not displayed");
						}
						
						//click on home button
						driver.findElement(By.name("home")).click();
						
						//click on view active customers button
						driver.findElement(By.name("viewdet")).click();
						
						//verifying account details displayed or not
						boolean b1 = driver.findElement(By.xpath("//td[.='"+AccountNumber+"']")).isDisplayed();
						if(b1)
							System.out.println("Account details are displayed");
						else
							System.out.println("Account details are not displayed");
						
						//click on logout button
						driver.findElement(By.name("logout_btn")).click();
						
						//verifying staff logout successfully/staff login pagin is displayed
						String loggedoutUrl = driver.getCurrentUrl();
						if(loggedoutUrl.contains("staff_login"))
							System.out.println("Logged out successfully");
						else
							System.out.println("Not logged out");
						
						//close the browser
						driver.close();
	}

}
