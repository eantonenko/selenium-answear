package parentTest;

import Pages.*;

import libs.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

public class ParentTest {
    WebDriver driver;

    public LoginPage loginPage;
    public HomePage homePage;
    public RecoverPassPage recoverPassPage;
    public ItemsListPage itemsListPage;
    public ItemDetailsPage itemDetailsPage;
    public CartPage cartPage;
    public ParentPage parentPage;
    public IzbranoePage izbranoePage;
    public OrderAdressPage orderAdressPage;
    public OrderDostavkaPage orderDostavkaPage;
    private Utils utils = new Utils();
    private boolean isTestPass = false;
    private String pathToScreenShot;

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() {
        File fileFF = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        pathToScreenShot = "..\\target\\screenshot\\" + this.getClass().getPackage().getName() + "\\" + this.getClass().getSimpleName()
                + this.testName.getMethodName() + ".jpg";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        options.addArguments("-incognito");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        recoverPassPage = new RecoverPassPage(driver);
        itemsListPage = new ItemsListPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        cartPage = new CartPage(driver);
        parentPage = new ParentPage(driver);
        izbranoePage = new IzbranoePage(driver);
        orderAdressPage = new OrderAdressPage(driver);
        orderDostavkaPage = new OrderDostavkaPage(driver);


    }

    @After
    public void tearDown() {

        if (!isTestPass) {
          utils.screenShot(pathToScreenShot, driver);
        }
        driver.quit();
    }

    protected void checkAcceptanceCriteria(String message, boolean actual, boolean expected){
        if (actual != expected){
            utils.screenShot(pathToScreenShot, driver);

        }
        Assert.assertThat(message, actual, is (expected));
        isTestPass = true;
    }
}
