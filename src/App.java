import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.codec.socksx.v5.Socks5PasswordAuthRequest;

public class App {
    public static void main(String[] args) throws Exception {
        // 1. Go to Eco-time
        WebDriver driver = new ChromeDriver();
        driver.get("http://ecotimecampus.ucsd.edu/");
    
        // 2. Enter in user credentials
        driver.findElement(By.id("ssousername")).sendKeys(""); // add username
        driver.findElement(By.id("ssopassword")).sendKeys(""); // add password

        // 3. Click "Login"
        driver.findElement(By.xpath("//*[contains(text(), 'Login')]")).click();

        // [MANUAL REQUIRED] Tap 'Yes' on phone for 2FA. Set up wait period.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement topFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("frmTop")));

        // 4. Switch to the frame "frmTop"
        driver.switchTo().frame(topFrame);

        // 5. Select "Employee Tasks"
        By employeeTasks = By.xpath("//*[@id='row_0']/td[2]/table/tbody/tr/td[1]/a");
        wait.until(ExpectedConditions.presenceOfElementLocated(employeeTasks)).click();

        // 6. Select "Timesheet"
        By timesheet = By.xpath("//*[@id='row_1']/td/table/tbody/tr/td[2]/a/span");
        wait.until(ExpectedConditions.presenceOfElementLocated(timesheet)).click();

        // 7. Switch to default content, then to the frame "frmBottom"
        driver.switchTo().defaultContent();
        WebElement botFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("frmBottom")));
        driver.switchTo().frame(botFrame);

        // 8. Click on the a tag that contains user input param "MM/DD" - doesn't work. WIP
        driver.findElement(By.xpath("//a[contains(.,'12/01')]")).click();

        // 9. Enter in the time in and time out, according to user settings
        //driver.findElement(By.name("cbInHrs1")).sendKeys("6");

        System.out.println("no dice");
    }
}