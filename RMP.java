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

public class RMP {
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
		      driver.findElement(By.id("searchBox")).sendKeys("RMP");
		      Thread.sleep(2000L);
		      
		      driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/form/div/div[1]/div/button")).click();
		      Thread.sleep(2000);
		      driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr[3]/td[1]/a/span")).click();
		      
	  }

  @Test
  public void Attributes() throws InterruptedException {
	  
	      if(driver.getPageSource().contains("Attributes"))
		  
		  {	  System.out.println();
		  	  System.out.println("Attributes is present on the template as well as on the webpage"); 
		  	  System.out.println();
		      List<String> Attributes = new ArrayList<String>();
		      Attributes.add("Title");
		      Attributes.add("Originator");
		      Attributes.add("Specification Sub Type");
		      Attributes.add("Business Area");
		      Attributes.add("Segment");
		      Attributes.add("Owner");
		      Attributes.add("Expiration Date");
		      Attributes.add("Manufacturing Status");
		      Attributes.add("Class");
		      Attributes.add("Base Unit Of Measure");
		      Attributes.add("Shipping Information");
		      Attributes.add("Storage Conditions");
		      Attributes.add("Comments");
		      Attributes.add("Description");
		      Attributes.add("Last Update User");
		      Attributes.add("Revision");
		      Attributes.add("Product Category Platform");
		      Attributes.add("Structured Release Criteria Required");
		      Attributes.add("Release Date");
		      Attributes.add("Previous Revision Obsolete Date");
		      Attributes.add("Reason for Change");
		      Attributes.add("Sub Class");
		      Attributes.add("Local Description");
		      Attributes.add("Shelf Life");
		      Attributes.add("Storage Temperature Limits(%)");
		      Attributes.add("Obsolete Date");
		      Attributes.add("Type");
		      Attributes.add("Produced by Formula");
		      Attributes.add("Originated");
		      Attributes.add("Franchise");
		      Attributes.add("Phase");
		      Attributes.add("Effective Date");
		      Attributes.add("Material Certifications");
		      Attributes.add("Has Art");
		      Attributes.add("Reported Function");
		      Attributes.add("Other Names");
		      Attributes.add("Shipping Hazard Classification");
		      Attributes.add("Storage Humidity Limits");
		      Attributes.add("Obsolete Comment");
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
		              if (++count < lit.size()) {
		                  continue;
		              }
		              System.out.println("descr not found");
		              org.testng.Assert.assertFalse(true);
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
  public void Profile() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  if(driver.getPageSource().contains("Profile/Identification"))
	  {
		  System.out.println();
		  System.out.println("Profile/Identification is present on the template as well as on the webpage");
		  System.out.println();
	      List<String> Profile = new ArrayList<String>();
	      Profile.add("INCI Name");
	      Profile.add("Empirical Formula");
	      Profile.add("CISPro #");
	      Profile.add("Preferred Material");
	      Profile.add("Material Restriction");
	      Profile.add("Chemical Name");
	      Profile.add("Color Index");
	      Profile.add("Experimental Number");
	      Profile.add("Material Usage Guidance");
	      Profile.add("Material Restriction Comment");
	      
	      WebElement el=driver.findElement(By.id("One"));
	      List<WebElement> li = el.findElements(By.id("pageheaders"));
	      for (String s1 : Profile) {
	          int count = 0;
	          for (WebElement e : li) {
	              String s2 = e.getText();
	              String ss=s2.substring(0, s2.length()-1);
	              if (s1.equalsIgnoreCase(ss)) {
	            	  SoftAssert sa=new SoftAssert();
	                  sa.assertEquals(s1, ss);
	                  System.out.println(s1+ " is present on the template as well as on the webpage");
	                  break;
	              }
	              
	              else {
	            	  count+=1;
	              
		              if (count >= li.size()) {
		            	  System.out.println("descr not found");;
		              }
	              
	              continue;
	              }
	          }
	      }
	  }
  
	  else {
		  System.out.println();
		  System.out.println("Profile/Identification is present in template but missing in webpage");
		  System.out.println();
  }
}
	  
	  

  @Test
  public void Physical_Properties() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
		  if(driver.getPageSource().contains("Physical Properties"))
		  {
			  System.out.println();
			  System.out.println("Physical Properties is present on the template as well as on the webpage");
			  System.out.println();
		      List<String> Properties = new ArrayList<String>();
		      Properties.add("Appearance:");
		      Properties.add("Specific Gravity:");
		      Properties.add("Boiling Point - °C:");
		      Properties.add("Form:");
		      Properties.add("Grade");
		      Properties.add("Autoignition Temp - °C:");
		      Properties.add("Color:");
		      Properties.add("Melting Point - °C:");
		      Properties.add("Viscosity - centipoise:");
		      Properties.add("Vapor Pressure - Pascal:");
		      Properties.add("Aqueous Solubility - %:");
		      Properties.add("Flash Point - °C:");
		      
		      WebElement el=driver.findElement(By.id("Two"));
		      List<WebElement> li = el.findElements(By.id("pageheaders"));
		      for (String s1 : Properties) {
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
	  
		  else{
			  System.out.println();
			  System.out.println("Physical Properties is present in template but missing in webpage");
			  System.out.println();
	  }
  }
  
  @Test
  public void Perfume_Properties() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
		  if(driver.getPageSource().contains("Physical Properties"))
			  System.out.println();
	  
		  else {
			  System.out.println();
			  System.out.println("Perfume Properties is present in template but missing in webpage");
			  System.out.println();
	  }
  }
  

  @Test
  public void Chemical_Properties() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
		  if(driver.getPageSource().contains("Chemical/Molecular Properties"))
		  {
			  System.out.println();
			  System.out.println("Chemical/Molecular Properties is present on the template as well as on the webpage");
			  System.out.println();
		      List<String> Properties = new ArrayList<String>();
		      Properties.add("HLB Value:");
		      Properties.add("Hydrophilic Index (HI):");
		      Properties.add("pH:");
		      Properties.add("IU's per gram:");
		      Properties.add("Animal Derived:");
		      Properties.add("Saponification Value:");
		      Properties.add("Hydroxl Value:");
		      Properties.add("Reactivity:");
		      Properties.add("Alkanity(%):");
		      
		      WebElement el=driver.findElement(By.id("Four"));
		      List<WebElement> li = el.findElements(By.id("pageheaders"));
		      for (String s1 : Properties) {
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
			  System.out.println("Chemical/Molecular Properties is present in template but missing in webpage");
			  System.out.println();
	  }
  }
  
  @Test
  public void Detergent_Properties() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
		  if(driver.getPageSource().contains("Physical Properties"))
			  System.out.println();
	  
	  
		  else {
			  System.out.println();
			  System.out.println("Detergent Surfactant Properties is present in template but missing in webpage");
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
		      Wt_Chara.add("Name");
		      Wt_Chara.add("Type");
		      Wt_Chara.add("Gross Weight");
		      Wt_Chara.add("Weight UoM");
		      Wt_Chara.add("Comments");
		      
		      WebElement table=driver.findElement(By.id("Six"));
		      List<WebElement> row = table.findElements(By.tagName("tr"));
		      for (String s1 : Wt_Chara) {
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
			  System.out.println("Weight Characteristic is present in template but missing in webpage");
			  System.out.println();
	  }
  }
  
  @Test
  public void Chemical_Classification() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
		  if(driver.getPageSource().contains("Chemical Classification"))
			  System.out.println();
	  
	  
		  else {
			  System.out.println();
			  System.out.println("Chemical Classification is present in template but missing in webpage");
			  System.out.println();
	  }
  }
  
  @Test
  public void Stability_document() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  if(driver.getPageSource().contains("Stability Document"))
		  System.out.println();
	  
	  else
	  {
		  System.out.println();
		  System.out.println("Stability Document is present in template but missing in webpage");
		  System.out.println();
	  }
  }
  
  @Test
  public void Materials_comp() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  try {
		  if(driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div/div[6]/div[1]/div")).isDisplayed())
		  {
			  System.out.println();
			  System.out.println("Materials & Composition is present on the template as well as on the webpage");
			  System.out.println();
		      List<String> materials_comp = new ArrayList<String>();
		      materials_comp.add("Name(N) Type(T)");
		      materials_comp.add("Title");
		      materials_comp.add("Min Quantity(Min) Dry % (w/w)(Dry) Max Quantity(Max) Quantity UofM(UoM)");
		      materials_comp.add("QS/Target(QS),Usage Flags(UF)");
		      materials_comp.add("Applications/Functions");
		      materials_comp.add("Is Impurity");
		      materials_comp.add("CAS Number(CAS) State Revision (SR)");
		      materials_comp.add("Description");
		      
		      WebElement table=driver.findElement(By.id("Nine"));
		      List<WebElement> row = table.findElements(By.tagName("tr"));
		      for (String s1 : materials_comp) {
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
	  }
		  catch(Exception e){
			  System.out.println();
			  System.out.println("Materials & Composition is present in template but missing in webpage");
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
		      
		      WebElement el=driver.findElement(By.id("TwentyTwo"));
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
  public void Starting_Materials() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  if(driver.getPageSource().contains("Starting_Materials"))
		  System.out.println();
	  
	  else
	  {
		  System.out.println();
		  System.out.println("Starting_Materials is present in template but missing in webpage");
		  System.out.println();
	  }
  }
		 
  @Test
  public void Alternates() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  if(driver.getPageSource().contains("Alternates"))
		  System.out.println();
	  
	  else
	  {
		  System.out.println();
		  System.out.println("Alternates is present in template but missing in webpage");
		  System.out.println();
	  }
  }
  @Test
  public void Reference_document() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  if(driver.getPageSource().contains("Reference Document"))
		  System.out.println();
	  
	  else
	  {
		  System.out.println();
		  System.out.println("Reference Document is present in template but missing in webpage");
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
  public void Performance_Characteristic() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  if(driver.getPageSource().contains("Performance Characteristic"))
		  System.out.println();
	  
	  else
	  {
		  System.out.println();
		  System.out.println("Performance Characteristic is present in template but missing in webpage");
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
  public void Certifications() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  if(driver.getPageSource().contains("Certifications"))
		  System.out.println();
	  
	  else
	  {
		  System.out.println();
		  System.out.println("Certifications is present in template but missing in webpage");
		  System.out.println();
	  }
  }
  @Test
  public void Lifecycle() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  if(driver.getPageSource().contains("Lifecycle/Approval Powerview"))
		  System.out.println();
	  
	  else
	  {
		  System.out.println();
		  System.out.println("Lifecycle/Approval Powerview is present in template but missing in webpage");
		  System.out.println();
	  }
  }
  @Test
  public void IP_Classes() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  if(driver.getPageSource().contains("IP Classes"))
		  System.out.println();
	  
	  else
	  {
		  System.out.println();
		  System.out.println("IP Classes is present in template but missing in webpage");
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
  public void Producing_Formula() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  if(driver.getPageSource().contains("Producing Formula"))
		  System.out.println();
	  
	  else
	  {
		  System.out.println();
		  System.out.println("Producing Formula is present in template but missing in webpage");
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
  public void RD_Sites() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  if(driver.getPageSource().contains("R&D Sites"))
		  System.out.println();
	  
	  else
	  {
		  System.out.println();
		  System.out.println("R&D Sites is present in template but missing in webpage");
		  System.out.println();
	  }
  }
  @Test
  public void Organizations() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  if(driver.getPageSource().contains("Organizations Document"))
		  System.out.println();
	  
	  else
	  {
		  System.out.println();
		  System.out.println("Organizations is present in template but missing in webpage");
		  System.out.println();
	  }
  }
  @Test
  public void Sites() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  if(driver.getPageSource().contains("Sites"))
		  System.out.println();
	  
	  else
	  {
		  System.out.println();
		  System.out.println("Sites is present in template but missing in webpage");
		  System.out.println();
	  }
  }
   
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
}




