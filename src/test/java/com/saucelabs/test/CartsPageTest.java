package com.saucelabs.test;

import com.saucelabs.base.TestBase;
import com.saucelabs.pages.CartsPage;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class CartsPageTest extends TestBase {
    CartsPage cartsPage;
    public CartsPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setUp()
    {
        cartsPage=new CartsPage();
    }

    @Test
    public void validatePageTitle()
    {
        Assert.assertEquals(cartsPage.getPageTitle(),properties.getProperty("cartspagetitle"),"Carts Page title is not matching");
    }

    @Test
    public void validateSortByName()
    {
        List<String> originalOrder;
        originalOrder = cartsPage.getProductsByDisplayOrder();
        String sortBy = "za";
        cartsPage.sortItems(sortBy);
        List<String> sortedOrder = cartsPage.getProductsByDisplayOrder();
        System.out.println(Arrays.toString(originalOrder.toArray()));
        System.out.println(Arrays.toString(sortedOrder.toArray()));
        List<String> expectedDescOrder= originalOrder.stream()
                                        .sorted(Comparator.reverseOrder())
                                        .collect(Collectors.toList());
        Assert.assertEquals(expectedDescOrder,sortedOrder,
                "The items are not sorted in the descending order");
//        cartsPage.sortByName("AtoZ","ASC");
    }
}
