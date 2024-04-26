import base.BaseTest;
import base.Constants;
import base.Page;
import base.RetryTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import static base.Constants.NAME_WEBSITE;

public class KijijiCars extends BaseTest {

//    @Test(retryAnalyzer = RetryTest.class)
    @Test
    public void KijijiCars() throws FileNotFoundException {
        ArrayList<String> queryList = new ArrayList<>(Arrays.asList(
                "Chevrolet", "Ford", "GMC", "Honda", "Hyundai", "Kia",
                "Mazda", "Mitsubishi", "Nissan", "Toyota"
        ));
//        constants = new Constants();
        NAME_WEBSITE = "kijijiCars";
        constants.setConstants(NAME_WEBSITE);
        System.out.println("--> Starting KijijiCars <--");
        Page page = new Page();
        Page.locationName = "Calgary";
        page.homePage();
        page.setGlobalFilter();
        page.setCarType();
        page.setPrice();
        page.setMaxMileage();
        for(String query : queryList) {
            Page.carBrand = query;
            page.setCarBrand();
//            page.setValues();
            page.getLinksFromLists();
            page.setCarBrand();
        }
        page.writeCsvFile();
    }
}