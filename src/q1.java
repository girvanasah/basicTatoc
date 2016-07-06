
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class q1 
{
public static void main(String []aa )
{
	WebDriver dw= new FirefoxDriver();
	dw.get("http://10.0.1.86/");
	dw.findElement(By.linkText("/tatoc")).click();
	dw.findElement(By.xpath("html/body/div[1]/div[2]/a[1]")).click();
	
	//prob 1
	dw.findElement(By.cssSelector(".greenbox")).click();

	//prob2
	dw.switchTo().frame("main");
	String ans= dw.findElement(By.cssSelector("#answer")).getAttribute("class");
	dw.switchTo().frame("child");
	String ans1= dw.findElement(By.cssSelector("#answer")).getAttribute("class");
	dw.switchTo().defaultContent();
	dw.switchTo().frame("main");
	while(!ans.equals(ans1))
	{
	dw.findElement(By.linkText("Repaint Box 2")).click();
	dw.switchTo().defaultContent();
	dw.switchTo().frame("main");
	dw.switchTo().frame("child");
	ans1= dw.findElement(By.cssSelector("#answer")).getAttribute("class");
	dw.switchTo().defaultContent();
	dw.switchTo().frame("main");
	}
	dw.switchTo().defaultContent();
	dw.switchTo().frame("main");
	dw.findElement(By.linkText("Proceed")).click();
	
	//prob3
	WebElement source = dw.findElement(By.cssSelector("#dragbox"));
	WebElement dest = dw.findElement(By.cssSelector("#dropbox"));
	Actions action = new Actions(dw);
	action.dragAndDrop(source, dest).build().perform();
	dw.findElement(By.linkText("Proceed")).click();
	
	//prob4
	dw.findElement(By.xpath("html/body/div[1]/div[2]/a[1]")).click();	
	String handle = dw.getWindowHandle();
	for(String webhand: dw.getWindowHandles())
	{
		dw.switchTo().window(webhand);
	}
	dw.findElement(By.cssSelector("#name")).sendKeys("Girvanasah Chaurasia");
	dw.findElement(By.cssSelector("#submit")).click();
	dw.switchTo().window(handle);
	dw.findElement(By.linkText("Proceed")).click();
	
	//prob5
	dw.findElement(By.linkText("Generate Token")).click();
	String s = dw.findElement(By.cssSelector("#token")).getText();
	System.out.println(s);
	Cookie name = new Cookie("Token", s.substring(7));
	dw.manage().addCookie(name);
	dw.findElement(By.linkText("Proceed")).click();
	try{
		Thread.sleep(10000);
	} catch (InterruptedException e) {
			e.printStackTrace();
	}
	dw.close();
}
}
