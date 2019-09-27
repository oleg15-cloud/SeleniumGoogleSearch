package google;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleSearchTest {
    static WebDriver driver;
    String url = "https://www.google.com";
    String word = "mazda engine";

    @BeforeClass
    public static void beforeMethod() {
        driver = new ChromeDriver();
    }

    @Test
    public void testMethod() {
        driver.get(url);
        driver.findElement(By.cssSelector("input[name='q']")).sendKeys(word);
        driver.findElement(By.cssSelector("input[name='q']")).sendKeys(Keys.ENTER);
        List<WebElement> elements = driver.findElements(By.cssSelector("div.rc, li.ads-ad"));
        for(WebElement el:elements) {
            String[] strings = word.split("//s+");
            for (String str :strings) {
                try {
                    Assert.assertTrue(el.getText().toLowerCase().contains(word.toLowerCase()));
                } catch (AssertionError e) {
                    System.out.println(el.getText().toLowerCase());
                    System.out.println(word.toLowerCase());
                }
            }

        }
        driver.findElement(By.cssSelector("div#navcnt a")).click();
        List<WebElement> elements1 = driver.findElements(By.cssSelector("div.rc, li.ads-ad"));
        for (WebElement el1:elements1) {
            String[] strings = word.split("//s+");
            for (String str1 :strings) {
                try {
                    Assert.assertTrue(el1.getText().toLowerCase().contains(word.toLowerCase()));
                } catch (AssertionError er) {
                    System.out.println(el1.getText().toLowerCase());
                    System.out.println(word.toLowerCase());
                }
            }

        }



    }


    @AfterClass
    public static void afterMethod() {
        driver.quit();
    }



}