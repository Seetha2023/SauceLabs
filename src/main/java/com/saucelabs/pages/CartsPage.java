package com.saucelabs.pages;

import com.saucelabs.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class CartsPage extends TestBase {
    @FindBy(xpath="//div[contains(text(),'Swag')]")
    WebElement pageTitle;

    @FindBy(xpath="//select")
    WebElement selectSortDropdown;

    @FindBy(className="inventory_item_name")
    List<WebElement> itemsName;

    public CartsPage()
    {
        PageFactory.initElements(driver,this);
    }
    public String getPageTitle()
    {
        return pageTitle.getText();
    }

    public void sortItems(String selectSortOption) {
        selectSortDropdown.click();
        Select sortDropdown = new Select(selectSortDropdown);
        sortDropdown.selectByValue(selectSortOption);
    }

    public List<String> getProductsByDisplayOrder()
    {
        List<String> itemsNameList = new ArrayList<>();
        for(WebElement element : itemsName)
             itemsNameList.add(element.getText());
        return itemsNameList;
    }

    public void sortByName(String sortCategory, String sortType)
    {

    }
}
