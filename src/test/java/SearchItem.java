import com.google.common.util.concurrent.AbstractScheduledService;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchItem {
    static WebDriver driver;

    @Before
    public void setChromeDriver(){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tihon\\Desktop\\Новая папка\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        }
        @Test
            public void olxSearchField(){
            driver.get("https://www.olx.ua/");
            driver.manage().window().maximize();
            WebElement searchField=driver.findElement(By.xpath("//*[@id=\"headerSearch\"]"));
            searchField.sendKeys("Шуба норковая");
            driver.findElement(By.xpath("//*[@id=\"autosuggest-div\"]/ul/li[7]/a/span")).click();
            WebElement citySearch=driver.findElement(By.xpath("//*[@id=\"cityField\"]"));
            citySearch.clear();
            citySearch.sendKeys("Одесса");
            WebDriverWait wait=new WebDriverWait(driver,10);
            WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"autosuggest-geo-ul\"]/li[5]")));
            driver.findElement(By.xpath("//*[@id=\"autosuggest-geo-ul\"]/li[5]")).click();
            driver.findElement(By.xpath("//*[@id=\"submit-searchmain\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"paramsListOpt\"]/div/div[3]/div[2]/div[2]/span")).click();
            //Assert.assertTrue("Найдено"+"объявлений",true);
            //List<WebElement>table
            WebElement firstResultInList=driver.findElement(By.xpath("//*[@id=\"offers_table\"]/tbody/tr[7]/td/table/tbody/tr[1]/td[2]/div/h3/a/strong"));
            Assert.assertTrue(firstResultInList.getText().contains("AVANTI Италия"));
           // driver.findElement(By.xpath("//input[@name='q']"));
           // WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
            //searchField.sendKeys("OLX official page");
            //List<WebElement> dropdownvalues=driver.findElements(By.xpath("//li[@role=\"presentation\"]"));
            //dropdownvalues.get(0).click();
            //Assert.assertFalse(firstResultInList.getText().contains("AAA"));
    }
    @Test
    public void olxSearchItem(){
        driver.get("https://www.olx.ua/");
        driver.manage().window().maximize();
        WebElement searchField=driver.findElement(By.xpath("//*[@id=\"headerSearch\"]"));
        searchField.sendKeys("Шуба норковая");
        driver.findElement(By.xpath("//*[@id=\"autosuggest-div\"]/ul/li[7]/a/span")).click();
        WebElement citySearch=driver.findElement(By.xpath("//*[@id=\"cityField\"]"));
        citySearch.clear();
        citySearch.sendKeys("Одесса");
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"autosuggest-geo-ul\"]/li[5]")));
        driver.findElement(By.xpath("//*[@id=\"autosuggest-geo-ul\"]/li[5]")).click();
        driver.findElement(By.xpath("//*[@id=\"submit-searchmain\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"paramsListOpt\"]/div/div[3]/div[2]/div[2]/span")).click();
        //Assert.assertTrue("Найдено"+"объявлений",true);
        //List<WebElement>table
        WebElement firstResultInList=driver.findElement(By.xpath("//*[@id=\"offers_table\"]/tbody/tr[7]/td/table/tbody/tr[1]/td[2]/div/h3/a/strong"));
        //Assert.assertTrue(firstResultInList.getText().contains("AVANTI Италия"));
        // driver.findElement(By.xpath("//input[@name='q']"));
        // WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
        //searchField.sendKeys("OLX official page");
        //List<WebElement> dropdownvalues=driver.findElements(By.xpath("//li[@role=\"presentation\"]"));
        //dropdownvalues.get(0).click();
        Assert.assertFalse(firstResultInList.getText().contains("AAA"));
    }
    @After
    public void closing(){
       driver.close();
    }
    }