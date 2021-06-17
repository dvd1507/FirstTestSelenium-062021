import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 extends Base{
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = initializeDriver();
    }

    @Test
    public void testHelloWorld(){
        driver.get("https://rpp.pe/");
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
