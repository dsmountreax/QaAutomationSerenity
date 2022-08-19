package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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

    }

    @Test
    public void hacer_una_busqueda(){



        //abrimos la pagina
        firefoxDriver.get("https://www.google.com");

        // Encontrar e interactuar con elementos
        // ingresar texto en el buscador
        firefoxDriver.findElement(By.cssSelector("[name='q']")).sendKeys("Cantidad de Paises en America");
        //presionamos la tecla enter
        firefoxDriver.findElement(By.cssSelector("[name='q']")).sendKeys(Keys.ENTER);
        // Hacer click
        firefoxDriver.findElement(By.xpath("//h3[text()='Datos de todos los países de América - DatosMundial']")).click();

        WebElement subtitulo= firefoxDriver.findElement(By.cssSelector(".floater"));

        System.out.println(subtitulo.getText());
        Assert.assertTrue(subtitulo.getText().contains("57"));

    }

    @After
    public void cerrar_driver()
    {
        firefoxDriver.quit();
    }
}
