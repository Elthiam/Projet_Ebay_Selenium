import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    public class Project_Ebay {

        WebDriver driver = new ChromeDriver();

        @BeforeMethod
        public void OpenChrome() {

            driver.get("https://www.ebay.fr/");
            driver.manage().window().maximize();

            /*
            //ACCEPTER LES COOKIES UNE BONNE FOIS SUR TOUTES LES PAGES
            String AcceptCookiesID ="gdpr-banner-accept";
            WebElement AcceptCookies = driver.findElement(By.id(AcceptCookiesID));
            AcceptCookies.click();

            By AcceptCookiesIDSelector = By.id("AcceptCookiesID");
            //introduction de l'implicite wait qui comprends: durée et conditions
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOfAllElements(AcceptCookiesIDSelector));
            wait.until(ExpectedConditions.elementToBeClickable(AcceptCookiesIDSelector));
            driver.findElement(AcceptCookiesIDSelector).click();
            */

        }

        @AfterMethod
        public void CloseChrome() {
            driver.quit();
        }


        @Test
        public void Etape1 () {

            //ARRANGE
            String ExpectedResult = "Panier (1 objet)";


            //ACT
            By CategoriesButton = By.id("gh-shop-a");
            driver.findElement(CategoriesButton).click();

            By SportVacationSelector = By.cssSelector("[_sp='m570.l3778']");
            //introduction de l'implicite wait qui comprends: durée et conditions
            WebDriverWait wait1 = new WebDriverWait(driver,10);
            wait1.until(ExpectedConditions.elementToBeClickable(SportVacationSelector));
            driver.findElement(SportVacationSelector).click();

            By ItemSelector = By.cssSelector(".b-list__items_nofooter li:nth-of-type(1)");
            driver.findElement(ItemSelector).click();

            By ItemBasketSelector = By.id("isCartBtn_btn");
            driver.findElement(ItemBasketSelector).click();

            By ResultSelector = By.cssSelector("[data-test-id='main-title']");
            WebElement Result = driver.findElement(ResultSelector);


            //ASSERT
            Assert.assertEquals(Result.getText(),ExpectedResult);

        }



    }
