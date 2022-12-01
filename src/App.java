import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    public static void main() throws Exception {
        // 1. Go to Eco-time
        WebDriver driver = new ChromeDriver();
        driver.get("http://ecotimecampus.ucsd.edu/");
    
        // 2. Enter in user credentials
        driver.findElement(By.id("ssousername")).sendKeys(Settings.user);
        driver.findElement(By.id("ssopassword")).sendKeys(Settings.pass);

        // 3. Click "Login"
        driver.findElement(By.xpath("//*[contains(text(), 'Login')]")).click();

        // [MANUAL REQUIRED] Tap 'Yes' on phone for 2FA. Set up wait period.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Settings.waitFor2FA));
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

        // 8. Click on the a tag that contains "MM/DD"
        driver.findElement(By.partialLinkText(Settings.date)).click();

        // 9. Enter in the time in and time out
        driver.findElement(By.name("cbInHrs1")).sendKeys(Settings.inHour);
        driver.findElement(By.name("cbInMin1")).sendKeys(Settings.inMinute);
        driver.findElement(By.name("cbInAP1")).sendKeys(Settings.inAP);
        driver.findElement(By.name("cbOutHrs1")).sendKeys(Settings.outHour);
        driver.findElement(By.name("cbOutMin1")).sendKeys(Settings.outMinute);
        driver.findElement(By.name("cbOutAP1")).sendKeys(Settings.outAP);

        // 10. Enter in job code, according to user settings
        driver.findElement(By.xpath("//select[@id='cbPos1']/option[contains(text(),"+Settings.jobCode+")]")).click();

        // 11. Wait to let pay code refresh, then enter it in
        Thread.sleep(Settings.waitForSelect); // Increase value if it fails here.
        driver.findElement(By.xpath("//select[@id='cbCode1']/option[text() = '"+Settings.payCode+"']")).click();

        // 12. Click "Save" at the top right
        driver.switchTo().defaultContent();
        driver.switchTo().frame(topFrame);
        driver.findElement(By.xpath("//img[@title='Save']")).click();

        // 13. Close browser & print completion message
        driver.close();
        System.out.println("Eco-Time for " + Settings.date + " from " + Settings.inTime + " to " + Settings.outTime + " saved.");
    }
}