package br.com.softdesign.tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PesquisaGoogleTest {

    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\levy.cunha\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.google.com.br");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void pesquisaGoogle() {
        // 1° forma
        WebElement campoPesquisa = driver.findElement(By.name("q"));
        campoPesquisa.sendKeys("SoftDesign");

        // 2° forma
        // driver.findElement(By.name("q")).sendKeys("SoftDesign");

        WebElement botaoPesquisa = driver.findElement(By.name("btnK"));
        botaoPesquisa.submit();

        Assert.assertEquals(driver.findElement(By.className("LC20lb"))
                .getText(), "SoftDesign: Desenvolvimento de Software, Apps, Sistemas e ...");
    }
}