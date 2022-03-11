package parent;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FilePermission;
import java.io.IOException;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testbase {
public static WebDriver driver;
public static File file;
public static Properties prop;
public static FileInputStream fs;

public testbase() throws IOException {
//	FilePermission permission = new FilePermission("\\src\\main\\java\\propertyfile", FilePermission.READ);
	file =new File(System.getProperty("user.dir")+"\\src\\main\\java\\shivam_new\\config.properties");
	fs = new FileInputStream(file);
	prop = new Properties();
	prop.load(fs);
}
//@BeforeTest
public static void launchbrowser() {
	
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
}
}
