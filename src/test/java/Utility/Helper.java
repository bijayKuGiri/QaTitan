package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Helper {

    private static String filePath="src/test/resources/config.xml";
    public static String getNodeValue(String path, String nodeName) throws ParserConfigurationException, IOException, SAXException {
        try {
            DocumentBuilderFactory dBfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dBfactory.newDocumentBuilder();
            Document document = builder.parse(new File(path));
            document.getDocumentElement().normalize();
            return document.getElementsByTagName(nodeName).item(0).getTextContent();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }

    }
    public static void NavigateToUAT(RemoteWebDriver _driver) throws ParserConfigurationException, IOException, SAXException {
        _driver.navigate().to(getNodeValue(filePath,"uat"));
        _driver.navigate().to(getNodeValue(filePath,"uatcred"));
        _driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        _driver.manage().timeouts().pageLoadTimeout  (40, TimeUnit.SECONDS);
    }

    public static void selectFromDDn(String Value, WebElement element){
        Select se = new Select(element);
        se.selectByValue(Value);
    }
    public static void click(RemoteWebDriver driver, WebElement element){
        try {
            element.findElement(By.tagName("input")).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }
    }
}
