import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.text.Element;
import java.time.Duration;
import java.util.List;

public class Test1 extends Base{
    private WebDriver driver;
    private final long pageLoadTimeout = 30;

    @BeforeMethod
    public void beforeMethod(){
        driver = initializeDriver();
    }

    @Test
    public void testHelloWorld(){
        driver.get("https://rpp.pe/");
    }

    @Test
    public void testLoginIPlan() throws InterruptedException {
        driver.get("https://cpq-portal-beesion-dev.apps.ocp01.iplan.com.ar/");
        new WebDriverWait(driver, pageLoadTimeout).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        WebElement userName = driver.findElement(new By.ById("username"));
        userName.sendKeys("mcorazza");
        WebElement password = driver.findElement(new By.ById("password"));
        password.sendKeys("mcorazza");
        WebElement btnLogin = driver.findElement(new By.ById("kc-login"));
        btnLogin.click();
        System.out.println("Login exitoso...");

        WebElement fistResult = new WebDriverWait(driver,
                30).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='blz-cac-menu-btn-icon']")));
        fistResult.click();

        WebElement secondResult = new WebDriverWait(driver,
                30).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='text' and text()='FPC']")));

        Actions action1 = new Actions(driver);
        action1.moveToElement(secondResult).click().perform();
        System.out.println("Actions...");

        WebElement productos = driver.findElement(By.xpath("//span[text()='Products']"));

        System.out.println("Productos");
        action1.moveToElement(productos).click().perform();
        System.out.println("Productos bien...");


        WebElement trespuntos = driver.findElement(By.xpath("//span[@class='blz-link' and text()='Internet Liv']//parent::div//parent::div"));
        WebElement algo = trespuntos.findElement(By.xpath("//div[@class='blz-icon-default']"));
        algo.click();

        secondResult = new WebDriverWait(driver,
                30).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Open Base Project']")));
        action1 = new Actions(driver);
        action1.moveToElement(secondResult).click().perform();
        Thread.sleep(20000);
    }

    @AfterMethod
    public void afterMethod(){
        new WebDriverWait(driver, pageLoadTimeout).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.quit();
    }
}
