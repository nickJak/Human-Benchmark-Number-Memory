import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

    public static WebDriver driver = new FirefoxDriver();

    public static void main(String[] args) throws InterruptedException {
        String username = "username";
        String password = "password";

        driver.get("https://humanbenchmark.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/a[2]")).click();
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/form/p[3]/input")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@href='/tests/number-memory']")).click();
        Thread.sleep(5000);

        String Number = "0";
        int sleepTime = 3000;
        driver.findElement(By.xpath("//*[text()='Start']")).click();
        for (int i = 0; i < 100; i++)
        {
            Number = driver.findElement(By.className("big-number")).getText();
            System.out.println(i + ". " + Number);
            Thread.sleep(sleepTime);
            driver.findElement(By.xpath("/html/body/div/div/div[4]/div[1]/div/div/div/form/div[2]/input")).sendKeys(Number + Keys.RETURN);
            driver.findElement(By.xpath("//*[text()='NEXT']")).click();
            sleepTime = sleepTime+1000;
        }
    }
}