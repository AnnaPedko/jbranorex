package com.ranorex.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import org.jruby.RubyProcess;
import org.openqa.jetty.html.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.thucydides.core.pages.WebElementFacade;

import net.thucydides.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

import static ch.lambdaj.Lambda.convert;





 @DefaultUrl("http://www.ranorex.com/web-testing-examples/vip/")
public class MainPage extends PageObject {


    @FindBy (id="FirstName")
    private WebElementFacade firstName;

    @FindBy (id="LastName")
    private WebElementFacade lastName;

    @FindBy (xpath = "//td/input[@value='female']")
    private WebElementFacade radioButtonFemale;

    @FindBy(xpath = "//input[@value='male']")
    private WebElementFacade radioButtonMale;

    @FindBy (id="Add")
    private WebElementFacade buttonAdd;

    @FindBy(id="Delete")
    private WebElementFacade buttonDelete;

    @FindBy(id="Load")
    private WebElementFacade buttonLoad;

    @FindBy(id="Save")
    private WebElementFacade buttonSave;

    @FindBy(id="Clear")
    private WebElementFacade buttonClear;
    @FindBy (id="VIPs")
    private WebElementFacade tablePeoples;




    public void fillFields(String nameFirst, String nameLast){
        firstName.sendKeys(nameFirst);
        lastName.sendKeys(nameLast);
    }

    public void fillFields(String nameFirst, String nameLast,String category){

        firstName.sendKeys(nameFirst);
        lastName.sendKeys(nameLast);
        Select select;
        select = new Select(getDriver().findElement(By.id("Category")));
        select.selectByValue(category);
    }


    public void addtoBase() {
        buttonAdd.click();
    }

    public void deleteLastRaw(){

        buttonDelete.click();
    }



    public List<String> getRaw(){
        List<WebElement> results = tablePeoples.findElements(By.xpath("//tbody/tr/td"));
        return convert(results, toStrings());
    }



    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }

}