package Pages;


import Utility.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class Home{

    //private RemoteWebDriver _driver;
    //private BaseUtilities base;
    private Helper _helper;
    private String filePath="config.xml";

    public Home(RemoteWebDriver _driver) {
        PageFactory.initElements(_driver,this);
    }

    @FindBy(xpath = "//header")
    WebElement header;


    public List<String> getLinktext(){
        List<String> linkTxt=new ArrayList<String>();
        List<WebElement> links=header.findElements(By.tagName("li"));
        for (WebElement var : links)
        {
            System.out.println(var.getText() );//+" "+url);
            linkTxt.add(var.findElement(By.tagName("a")).getAttribute("href"));
        }
        return linkTxt;
    }




}
