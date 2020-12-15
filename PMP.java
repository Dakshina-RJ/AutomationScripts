package SpecReader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PMP {
private static WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\Dakshina\\Documents\\DAKSHINA\\infy\\selenum\\jars\\selenium_essentials\\chromedriver.exe");
			driver=new ChromeDriver();	
			 
			  driver.get("https://fedauthtst.pg.com/as/authorization.oauth2?response_type=code&client_id=specsanywhere-qa&scope=openid%20pingid&display_name=Spec%20Reader-Prod&redirect_uri=https://specsqaap.pg.com/login&state=/tokens/authcode");
			  Thread.sleep(1000);
			  
		      driver.findElement(By.id("username")).sendKeys("Anywheretwo.im");
		      driver.manage().timeouts().implicitlyWait(15000, TimeUnit.SECONDS);
		      driver.findElement(By.id("password")).sendKeys("Sa061920");
		      driver.manage().timeouts().implicitlyWait(15000, TimeUnit.SECONDS);
		      driver.findElement(By.id("loginButton")).click();
		      driver.manage().timeouts().implicitlyWait(15000, TimeUnit.SECONDS);
		      Thread.sleep(5000L);
	
		      driver.manage().timeouts().implicitlyWait(15000, TimeUnit.SECONDS);
		      driver.findElement(By.id("searchBox")).sendKeys("95794370");
		      Thread.sleep(2000L);
		      
		      driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/form/div/div[1]/div/button")).click();
		      Thread.sleep(2000);
		      driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr/td[1]/a/span")).click();
		      
	  }
	 @Test
	  public void Attributes() throws InterruptedException {
		  
		      if(driver.getPageSource().contains("Attributes"))
			  
			  {	  System.out.println();
			  	  System.out.println("Attributes is present on the template as well as on the webpage"); 
			  	  System.out.println();
			      List<String> Attributes = new ArrayList<String>();
			      Attributes.add("Title");
			      Attributes.add("Type");
			      Attributes.add("Description");
			      Attributes.add("Specification Sub Type");
			      Attributes.add("Revision");
			      Attributes.add("Originator");
			      Attributes.add("Last Update User");
			      Attributes.add("Originated");
			      Attributes.add("Phase");
			      Attributes.add("Owner");
			      Attributes.add("Segment");
			      Attributes.add("Structured Release Criteria Required");
			      Attributes.add("Release Date");
			      Attributes.add("Effective Date");
			      Attributes.add("Expiration Date");
			      Attributes.add("Previous Revision Obsolete Date");
			      Attributes.add("Manufacturing Status");
			      Attributes.add("Reason for Change");
			      Attributes.add("Preferred Material");
			      Attributes.add("Has Art");
			      Attributes.add("Has Multiple GTINs on Artwork");
			      Attributes.add("Brand");
			      Attributes.add("Class");
			      Attributes.add("Sub Class");
			      Attributes.add("Local Description");
			      Attributes.add("Other Names");
			      Attributes.add("Packaging Material Type");
			      Attributes.add("Legacy Environmental Class");
			      Attributes.add("Packaging Component Type");
			      Attributes.add("Packaging Size");
			      Attributes.add("Packaging Size UoM");
			      Attributes.add("Packaging Technology");
			      Attributes.add("Part Color");
			      Attributes.add("Printing Process");
			      Attributes.add("Decoration Details");
			      Attributes.add("Shipping Information");
			      Attributes.add("Labeling Information");
			      Attributes.add("Storage Conditions");
			      Attributes.add("POA Impact Confirmation");
			      Attributes.add("Storage Temperature Limits-°C");
			      Attributes.add("Storage Humidity Limits -%");
			      Attributes.add("Comments");
			      Attributes.add("Obsolete Date");
			      Attributes.add("Obsolete Comment");
			      Attributes.add("Classification");
			      Attributes.add("Reported Function");
			      Attributes.add("Base Unit Of Measure");
			      
			      List<WebElement> lit = (List<WebElement>)driver.findElements(By.id("pageheaders"));
			      for (String s : Attributes) {
			          int count = 0;
			          for (WebElement e : lit) {
			              String s2 = e.getText();
			              if (s.equalsIgnoreCase(s2)) {
			            	  SoftAssert sa=new SoftAssert();
			                  sa.assertEquals(s, s2);
			                  System.out.println(String.valueOf(s) + " is present on the template as well as on the webpage");
			                  break;
			              }
			              else {
			            	  count+=1;
			              
				              if (count > lit.size()) {
				            	  System.out.println("descr not found");;
				              }
			              
			              continue;
			          }
			      }
			      }
			  }
		  
		      else{
				  System.out.println();
				  System.out.println("Attributes is present in template but missing in webpage");
				  System.out.println();
		  }
	  }
	 @Test
	  public void Weight_Caracteristics() {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
			  if(driver.getPageSource().contains("Weight Characteristic"))
			  {
				  System.out.println();
				  System.out.println("Weight Characteristics is present on the template as well as on the webpage");
				  System.out.println();
			      List<String> Wt_Chara = new ArrayList<String>();
			     
			      Wt_Chara.add("Gross Weight");
			      Wt_Chara.add("Weight UoM");
			     
			      WebElement el=driver.findElement(By.id("One"));
			      List<WebElement> li = el.findElements(By.id("pageheaders"));
			      for (String s1 : Wt_Chara) {
			          int count = 0;
			          for (WebElement e : li) {
			              String s2 = e.getText();
			              String ss=s2.substring(0, s2.length()-1);
		        		  
			              if (s1.equalsIgnoreCase(ss)) {
			            	  SoftAssert sa=new SoftAssert();
			                  sa.assertEquals(s1, s2);
			                  System.out.println(s1+ " is present on the template as well as on the webpage");
			                  break;
			              }
			              
			              else {
			            	  count+=1;
			              
				              if (count > li.size()) {
				            	  System.out.println("descr not found");;
				              }
			              
			              continue;
			              }
			          }
			      }
			  }
		  
			  else {
				  System.out.println();
				  System.out.println("Weight Characteristics is present in template but missing in webpage");
				  System.out.println();
		  }
	  }
	 @Test
	 public void Substance_Materials() {
	 	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	  try {
	 		  if(driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div/div[3]/div[1]/div")).isDisplayed())
	 		  {
	 			  System.out.println();
	 			  System.out.println("Substance & Materials is present on the template as well as on the webpage");
	 			  System.out.println();
	 		      List<String> sub_mat = new ArrayList<String>();
	 		      List<String> sm = new ArrayList<String>();
	 		     
	 		      sub_mat.add("Quantity UoM");
	 		      sub_mat.add("Target Percentage Weight by	Weight");
	 		      sub_mat.add("Manufacturer");
	 		      sub_mat.add("Title(T) Type(TY)");
	 		      sub_mat.add("Seq");
	 		      sub_mat.add("Description");
	 		      sub_mat.add("Trade Name");
	 		      sub_mat.add("Legacy Environmental Class");
	 		      sub_mat.add("Layer/Composition Description");
	 		      sub_mat.add("Minimum Percentage Weight by	Weight");
	 		      sub_mat.add("Maximum Percentage Weight by	Weight");
	 		      sub_mat.add("Post-Consumer Recycled Content(%) Post-Industrial Recycled Content(%)(Ind)");
	 		      sub_mat.add("Comments(C) State(St)");
	 		      sub_mat.add("T");
	 		      sub_mat.add("TY");
	 		      sub_mat.add("Con");
	 		      sub_mat.add("Ind");
	 		      sub_mat.add("St");

	 		      
	 		      WebElement table=driver.findElement(By.xpath("//*[@id=\"Two\"]/div/div/table"));
	 		      List<WebElement> row = table.findElements(By.tagName("tr"));
	 		      List<WebElement> col = row.get(0).findElements(By.tagName("th"));
	         	  for(WebElement c:col) {
	         		  String s2 = c.getText();
	         		  sm.add(s2);
	         	  }
	 		      WebElement table1=driver.findElement(By.xpath("//*[@id=\"Two\"]/div/div/table/tbody"));
	 		      List<WebElement> row1 = table1.findElements(By.tagName("tr"));
	 		      List<WebElement> col1 = row1.get(0).findElements(By.className("bomFontClass"));
	 		    	 
	         	  for(WebElement c:col1) {
	         		  String s2 = c.getText();
	         		  String ss=s2.substring(0, s2.length()-1);
	        		  sm.add(ss);
	         	  }
	         	  
	 		      for (String el:sub_mat){
	 		    	  for(String e: sm) {
	 		    		  if(el.equalsIgnoreCase(e)) {
	 		    			  SoftAssert sa=new SoftAssert();
	 		                  sa.assertEquals(el, e);
	 		                  System.out.println(el+ " is present on the template as well as on the webpage");
	 		                  break;
	 		    		  }
	 		    		  continue;
	 		    	  }
	 		      }
	         	  
	 		  }
	 	  }
	 		  catch(Exception e){
	 			  System.out.println();
	 			  System.out.println("Substance & Materials is present in template but missing in webpage");
	 			  System.out.println();
	 	  }
	 }		  
	 @Test
	 public void Performance_Characteristics() {
	 	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	 if(driver.getPageSource().contains("Performance Characteristic"))
 		  {
 			  System.out.println();
 			  System.out.println("Performance Characteristic is present on the template as well as on the webpage");
 			  System.out.println();
 		      List<String> per_char = new ArrayList<String>();
 		      List<String> pc = new ArrayList<String>();
	 		     
		 		per_char.add("Chg");
		 		per_char.add("Characteristic(Ch) Characteristic Specifics(CS) Path(P)");
		 		per_char.add("Test Method(Name) Test Method Logic(TML) Test method origin(TMO) Other Test Method Number(TM) Test Method Specifics (Sp) Test Method Reference Document Name(TMRDN)");
		 		per_char.add("Sampling(SM) Subgroup(SG)");
		 		per_char.add("Lower Specification Limit (LSL)  Lower Target(LTGT) Target(TGT) Upper Target(UTGT) Upper Specification Limit(USL)");
		 		per_char.add("Unit of Measure(UoM) Report to Nearest(RTN) Report Type(RT)");
		 		per_char.add("Release Criteria(RC)");
		 		per_char.add("Action Required(AC) Criticality Factor(CR) Basis[BA]");
		 		per_char.add("Test Group(TG) Application(AP) Master Part Title(MPT)");
		 		per_char.add("Plant Testing Level(LVL) Plant Testing:Retesting(RT) Retesting:Unitof Measure(UoM)");
		 		per_char.add("CH");
		 		per_char.add("CS");
		 		per_char.add("P");
		 		per_char.add("Name");
		 		per_char.add("TML");
		 		per_char.add("TMO");
		 		per_char.add("TM");
		 		per_char.add("SP");
		 		per_char.add("TMRDN");
		 		per_char.add("SM");
		 		per_char.add("SG");
		 		per_char.add("LSL");
		 		per_char.add("LTGT");
		 		per_char.add("TGT");
		 		per_char.add("UTGT");
		 		per_char.add("USL");
		 		per_char.add("UoM");
		 		per_char.add("RTN");
		 		per_char.add("RT");
		 		per_char.add("RC");
		 		per_char.add("AC");
		 		per_char.add("CR");
		 		per_char.add("BA");
		 		per_char.add("TG");
		 		per_char.add("AP");
		 		per_char.add("MPT");
		 		per_char.add("LVL");
		 		per_char.add("RT");
		 		per_char.add("UoM");
		 		per_char.add("CH");
		 		per_char.add("CS");
		 		per_char.add("P");
		 		per_char.add("Name");
		 		per_char.add("TML");
		 		per_char.add("TMO");
		 		per_char.add("TM");
		 		per_char.add("SP");
		 		per_char.add("TMRDN");
		 		per_char.add("SM");
		 		per_char.add("SG");
		 		per_char.add("LSL");
		 		per_char.add("LTGT");
		 		per_char.add("TGT");
		 		per_char.add("UTGT");
		 		per_char.add("USL");
		 		per_char.add("UoM");
		 		per_char.add("RTN");
		 		per_char.add("RT");
		 		per_char.add("RC");
		 		per_char.add("AC");
		 		per_char.add("CR");
		 		per_char.add("BA");
		 		per_char.add("TG");
		 		per_char.add("AP");
		 		per_char.add("MPT");
		 		per_char.add("LVL");
		 		per_char.add("RT");
		 		per_char.add("UoM");

	 		      
	 		      WebElement table=driver.findElement(By.xpath("//*[@id=\"Six\"]/div/div/table"));
	 		      List<WebElement> row = table.findElements(By.tagName("tr"));
	 		      List<WebElement> col = row.get(0).findElements(By.tagName("th"));
	         	  for(WebElement c:col) {
	         		  String s2 = c.getText();
	         		  pc.add(s2);
	         	  }
	 		      WebElement table1=driver.findElement(By.xpath("//*[@id=\"Six\"]/div/div/table/tbody"));
	 		      List<WebElement> row1 = table1.findElements(By.tagName("tr"));
	 		      List<WebElement> col1 = row1.get(0).findElements(By.className("bomFontClass"));
	 		    	 
	         	  for(WebElement c:col1) {
	         		  String s2 = c.getText();
	         		  String ss=s2.substring(0, s2.length()-1);
	        		  pc.add(ss);
	         	  }

	 		      for (String el:per_char){
	 		    	  for(String e: pc) {
	 		    		  if(el.equalsIgnoreCase(e)) {
	 		    			  SoftAssert sa=new SoftAssert();
	 		                  sa.assertEquals(el, e);
	 		                  System.out.println(el+ " is present on the template as well as on the webpage");
	 		                  break;
	 		    		  }
	 		    		  continue;
	 		    	  }
	 		      }
	         	  
	 		  }
	 	  
	 	 else{
	 			  System.out.println();
	 			  System.out.println("Performance Characteristic is present in template but missing in webpage");
	 			  System.out.println();
	 	  }
	 }		  
	  	  
	 @Test
	  public void Plants() {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
			  if(driver.getPageSource().contains("Plants"))
			  {
				  System.out.println();
				  System.out.println("Plants is present on the template as well as on the webpage");
				  System.out.println();
			      List<String> pl = new ArrayList<String>();
			     
			      pl.add("Plants");
			      pl.add("Authorized");
			      pl.add("Activated");
			     
			      WebElement table=driver.findElement(By.id("Seven"));
			      List<WebElement> row = table.findElements(By.tagName("tr"));
			      for (String s1 : pl) {
			          for (WebElement r : row) {
			        	  List<WebElement> col = r.findElements(By.tagName("th"));
			        	  for(WebElement c:col) {
			        		  String s2 = c.getText();
			              if (s1.equalsIgnoreCase(s2)) {
			            	  SoftAssert sa=new SoftAssert();
			                  sa.assertEquals(s1, s2);
			                  System.out.println(s1+ " is present on the template as well as on the webpage");
			                  break;
			              }
			              continue;
			              }
			          }
			      }
			  }
		  
			  else {
				  System.out.println();
				  System.out.println("Plants is present in template but missing in webpage");
				  System.out.println();
		  }
	  }
	 @Test
	  public void Lifecycle() {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
			  if(driver.getPageSource().contains("Lifecycle/Approval Powerview"))
			  {
				  System.out.println();
				  System.out.println("Lifecycle/Approval Powerview is present on the template as well as on the webpage");
				  System.out.println();
			      List<String> lifecycle = new ArrayList<String>();
			     
			      lifecycle.add("Tasks/Signatures");
			      lifecycle.add("Name");
			      lifecycle.add("Approver");
			      lifecycle.add("Title");
			      lifecycle.add("Approval Status");
			      lifecycle.add("	Approval/Due Date");
			      lifecycle.add("Comments/Instructions");
			      
			     
			      WebElement table=driver.findElement(By.id("Ten"));
			      List<WebElement> row = table.findElements(By.tagName("tr"));
			      for (String s1 : lifecycle) {
			          for (WebElement r : row) {
			        	  List<WebElement> col = r.findElements(By.tagName("th"));
			        	  for(WebElement c:col) {
			        		  String s2 = c.getText();
			              if (s1.equalsIgnoreCase(s2)) {
			            	  SoftAssert sa=new SoftAssert();
			                  sa.assertEquals(s1, s2);
			                  System.out.println(s1+ " is present on the template as well as on the webpage");
			                  break;
			              }
			              continue;
			              }
			          }
			      }
			  }
		  
			  else {
				  System.out.println();
				  System.out.println("Lifecycle/Approval Powerview is present in template but missing in webpage");
				  System.out.println();
		  }
	  }
	 @Test
	  public void IP_Classes() {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
			  if(driver.getPageSource().contains("IP Classes"))
			  {
				  System.out.println();
				  System.out.println("IP Classes is present on the template as well as on the webpage");
				  System.out.println();
			      List<String> lifecycle = new ArrayList<String>();
			     
			      lifecycle.add("Tasks/Signatures");
			      lifecycle.add("Name");
			      lifecycle.add("Approver");
			      lifecycle.add("Title");
			      lifecycle.add("Approval Status");
			      lifecycle.add("	Approval/Due Date");
			      lifecycle.add("Comments/Instructions");
			      
			     
			      WebElement table=driver.findElement(By.id("Ten"));
			      List<WebElement> row = table.findElements(By.tagName("tr"));
			      for (String s1 : lifecycle) {
			          for (WebElement r : row) {
			        	  List<WebElement> col = r.findElements(By.tagName("th"));
			        	  for(WebElement c:col) {
			        		  String s2 = c.getText();
			              if (s1.equalsIgnoreCase(s2)) {
			            	  SoftAssert sa=new SoftAssert();
			                  sa.assertEquals(s1, s2);
			                  System.out.println(s1+ " is present on the template as well as on the webpage");
			                  break;
			              }
			              continue;
			              }
			          }
			      }
			  }
		  
			  else {
				  System.out.println();
				  System.out.println("IP Classes is present in template but missing in webpage");
				  System.out.println();
		  }
	  }
	 @Test
	  public void Ownership() {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
			  if(driver.getPageSource().contains("Ownership"))
			  {
				  System.out.println();
				  System.out.println("Ownership is present on the template as well as on the webpage");
				  System.out.println();
			      List<String> ownership = new ArrayList<String>();
			      ownership.add("Originator:");
			      ownership.add("Co-Owners:");
			      ownership.add("Last Update User:");
			      ownership.add("Segment:");
			      ownership.add("Approvers:");
			      ownership.add("Last Update Date:");
			      
			      WebElement el=driver.findElement(By.id("Thirteen"));
			      List<WebElement> li = el.findElements(By.id("pageheaders"));
			      for (String s1 : ownership) {
			          int count = 0;
			          for (WebElement e : li) {
			              String s2 = e.getText();
			              if (s1.equalsIgnoreCase(s2)) {
			            	  SoftAssert sa=new SoftAssert();
			                  sa.assertEquals(s1, s2);
			                  System.out.println(s1+ " is present on the template as well as on the webpage");
			                  break;
			              }
			              
			              else {
			            	  count+=1;
			              
				              if (count > li.size()) {
				            	  System.out.println("descr not found");;
				              }
			              
			              continue;
			              }
			          }
			      }
			  }
		  
			  else {
				  System.out.println();
				  System.out.println("Ownership is present in template but missing in webpage");
				  System.out.println();
		  }
	  }
	 @Test
	  public void Organizations() {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
			  if(driver.getPageSource().contains("Organizations"))
			  {
				  System.out.println();
				  System.out.println("Organizations is present on the template as well as on the webpage");
				  System.out.println();
			      List<String> Organizations = new ArrayList<String>();
			      Organizations.add("Primary Organization");
			      Organizations.add("Secondary Organization");
			      
			      WebElement el=driver.findElement(By.id("Fifteen"));
			      List<WebElement> li = el.findElements(By.id("pageheaders"));
			      for (String s1 : Organizations) {
			          int count = 0;
			          for (WebElement e : li) {
			              String s2 = e.getText();
			              String s3=s2.substring(0, s2.length()-1);
			              if (s1.equalsIgnoreCase(s3)) {
			            	  SoftAssert sa=new SoftAssert();
			                  sa.assertEquals(s1, s2);
			                  System.out.println(s1+ " is present on the template as well as on the webpage");
			                  break;
			              }
			              
			              else {
			            	  count+=1;
			              
				              if (count > li.size()) {
				            	  System.out.println("descr not found");;
				              }
			              
			              continue;
			              }
			          }
			      }
			  }
		  
			  else {
				  System.out.println();
				  System.out.println("Organizations is present in template but missing in webpage");
				  System.out.println();
		  }
	  }
	  @Test
	  public void Master_Specifications() {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  if(driver.getPageSource().contains("Master Specifications"))
			  System.out.println();
		  
		  else
		  {
			  System.out.println();
			  System.out.println("Master Specifications is present in template but missing in webpage");
			  System.out.println();
		  }
	  }
	  @Test
	  public void Related_Specifications() {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  if(driver.getPageSource().contains("Related Specifications"))
			  System.out.println();
		  
		  else
		  {
			  System.out.println();
			  System.out.println("Related Specifications is present in template but missing in webpage");
			  System.out.println();
		  }
	  }
	  @Test
	  public void Reference_Documents() {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  if(driver.getPageSource().contains("Reference Documents"))
			  System.out.println();
		  
		  else
		  {
			  System.out.println();
			  System.out.println("Reference Documents is present in template but missing in webpage");
			  System.out.println();
		  }
	  }
	  @Test
	  public void Security_Classes() {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  if(driver.getPageSource().contains("Security Classes"))
			  System.out.println();
		  
		  else
		  {
			  System.out.println();
			  System.out.println("Security Classes is present in template but missing in webpage");
			  System.out.println();
		  }
	  }
	  @Test
	  public void PQR_View1() {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  if(driver.getPageSource().contains("PQR VIEW Manufacturer Equivalents"))
			  System.out.println();
		  
		  else
		  {
			  System.out.println();
			  System.out.println("PQR VIEW Manufacturer Equivalents is present in template but missing in webpage");
			  System.out.println();
		  }
	  }
	  @Test
	  public void PQR_View2() {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  if(driver.getPageSource().contains("PQR VIEW Supplier Equivalents"))
			  System.out.println();
		  
		  else
		  {
			  System.out.println();
			  System.out.println("PQR VIEW Supplier Equivalents is present in template but missing in webpage");
			  System.out.println();
		  }
	  }
	  @Test
	  public void Related_ATS() {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  if(driver.getPageSource().contains("Related ATS"))
			  System.out.println();
		  
		  else
		  {
			  System.out.println();
			  System.out.println("Related ATS is present in template but missing in webpage");
			  System.out.println();
		  }
	  }
	  @Test
	  public void Files() {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  if(driver.getPageSource().contains("Files"))
			  System.out.println();
		  
		  else
		  {
			  System.out.println();
			  System.out.println("Files is present in template but missing in webpage");
			  System.out.println();
		  }
	  }	  
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }
}
