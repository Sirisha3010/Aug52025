package pack2;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC011_Windowhandling {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();	
		driver.get("https://letcode.in/window");
		driver.findElement(By.id("home")).click();
		String pwindow=driver.getWindowHandle();
		System.out.println("parent window:"+pwindow);
		System.out.println("url is:"+driver.getCurrentUrl());
		driver.findElement(By.id("multi")).click();
		Set<String>mwindows=driver.getWindowHandles();
		for(String cwindow:mwindows)
		{
			driver.switchTo().window(cwindow);
			System.out.println("url is:"+driver.getCurrentUrl());
		}
		
		
		
		
		// TODO Auto-generated method stub

	}

}
