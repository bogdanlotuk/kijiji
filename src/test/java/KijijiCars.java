import base.BaseTest;
import base.Page;
import base.RetryTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import static base.Constants.NAME_WEBSITE;

public class KijijiCars extends BaseTest {

    @Test(retryAnalyzer = RetryTest.class)
    public void KijijiCars() throws FileNotFoundException {
        ArrayList<String> queryList = new ArrayList<>(Arrays.asList(
                "Honda", "Mitsubishi"
        ));
        NAME_WEBSITE = "kijijiCars";
        constants.setConstants(NAME_WEBSITE);
        constants.setConstants(NAME_WEBSITE);
        System.out.println("--> Starting KijijiCars <--");
        Page page = new Page();
        Page.locationName = "Calgary";
        Page.carMinPrice = "10000";
        Page.carMaxPrice = "15000";
        Page.carMinYear = "2012";
        Page.carMaxMileage = "180000";
        Page.carType = "SUV, Crossover";
        page.homePage();
        page.setGlobalFilter();
        page.setCarType();
        page.setMaxMileage();
        page.setCarYear();
        page.setPrice();
        for(String query : queryList) {
            Page.carBrand = query;
            page.setCarBrand();
            page.getLinksFromLists();
            page.setCarBrand();
        }
        page.writeCsvFile();
    }
}