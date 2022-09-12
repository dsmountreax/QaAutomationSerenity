package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Prueba {
    private WebDriver firefoxDriver;

    @Before
    public void abrirDriver()
    {
        // encontrar archivo exe de geckodriver
        System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");

        //creamos opciones sobre nueestro driver
        FirefoxOptions options= new FirefoxOptions();
        //options.setCapability("marionette",false); // navegador por defect

        //nueva instancia de Firefoxdriver
        firefoxDriver=new FirefoxDriver(options);

        //definimos tiempo de espera hasta que esperamos un timeout
        firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        firefoxDriver.manage().window().maximize();

    }

    @Test
    public void hacer_una_compra() throws InterruptedException {

        firefoxDriver.get("http://automationpractice.com/index.php");
        WebElement buttonLogin=firefoxDriver.findElement(By.cssSelector(".login"));
        buttonLogin.click();

        WebElement inputEmail=firefoxDriver.findElement(By.cssSelector("#email"));
        inputEmail.sendKeys("dsmountreax@gmail.com");
        WebElement inputPassword = firefoxDriver.findElement(By.cssSelector("#passwd"));
        inputPassword.sendKeys("Password");
        WebElement buttonSubmitLogin= firefoxDriver.findElement(By.cssSelector("#SubmitLogin"));
        buttonSubmitLogin.click();

        WebElement tabTshirt= firefoxDriver.findElement(By.cssSelector(".sf-menu>li:nth-child(3)>a"));
        tabTshirt.click();
        // crear accion

        Actions accion = new Actions(firefoxDriver);

        // encontrar imagen del producto
        WebElement imageTshirt=firefoxDriver.findElement(By.cssSelector("img[title$='T-shirts']"));
        WebElement buttonAddToCart=firefoxDriver.findElement(By.xpath("//span[text()='Add to cart']"));

        //accion.moveToElement(imageTshirt).moveToElement(buttonAddToCart).click().build().perform();
        /*JavascriptExecutor js = (JavascriptExecutor) firefoxDriver;
        js.executeScript("window.scrollBy(0,600)");
        accion.moveToElement(imageTshirt).build().perform();
        buttonAddToCart.click();
        // pendiente de prueba
        WebElement botonDeCompra1 =firefoxDriver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
        botonDeCompra1.click();

        WebElement botonDecompra2= firefoxDriver.findElement(By.xpath("//p//*[contains(text(),'Proceed to checkout')]"));
        botonDecompra2.click();
        WebElement botonDeCompra3= firefoxDriver.findElement(By.xpath("//button/span[contains(text(),'Proceed to checkout')]"));
        botonDeCompra3.click();*/
        // Calse 13 minuto 3.


    }

    @After
    public void cerrar_driver()
    {
        firefoxDriver.quit();
    }
}
