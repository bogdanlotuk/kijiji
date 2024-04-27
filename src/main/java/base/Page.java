package base;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static base.Constants.*;


public class Page {
    public static String locationName;
    public static String carMinPrice;
    public static String carMaxPrice;
    public static String carMinYear;
    public static String carMaxMileage;
    public static ArrayList<String> linksFromList = new ArrayList<>();
    public static ArrayList<Car> CarsWithUrl = new ArrayList<>();
    public SelenideElement globalFilter = $x(GLOBAL_FILTER);
    public SelenideElement globalFilterValue = $x(GLOBAL_FILTER_VALUE);
    public SelenideElement globalFilterValueCategory = $x(GLOBAL_FILTER_VALUE_CATEGORY);
    public SelenideElement buttonSearch = $x(BUTTON_SEARCH);
    public SelenideElement priceMin = $x(PRICE_MIN_ELEMENT);
    public SelenideElement priceMax = $x(PRICE_MAX_ELEMENT);
    public SelenideElement buttonNextPage = $x(NEXT_PAGE_ELEMENT);
    public static String carName;
    public static String carBrand;
    public static String carPrice;
    public static String carLocation;
    public static String carDate;
    public static String carMileage;
    public static String carUrl;

    public void homePage(){
        open(BASE_URL);
        sleep(10000);

        if($x("//div[@class='location-wrapper']//a[text()='Alberta']").exists()){
            $x("//div[@class='location-wrapper']//a[text()='Alberta']").click();
            $x("//div[@class='location-wrapper']//a[text()='Calgary']").click();
            sleep(5000);
            $x("//a[@id='LocUpdate']").click();
        }
    }

    public void setGlobalFilter(){
        sleep(10000);
        waitForElement(globalFilter);
        globalFilter.hover().click();
        sleep(5000);
        waitForElement(globalFilterValue);
        globalFilterValue.hover().click();

        waitForElement(buttonSearch);
        buttonSearch.click();

        sleep(5000);

        waitForElement(globalFilterValueCategory);
        globalFilterValueCategory.hover().click();
    }

    public void setMaxMileage(){
        waitForElement($x("//*[@id='accordion__heading-carmileageinkms']"));
//        sleep(5000);
        $x("//*[@id='accordion__heading-carmileageinkms']").click();
//        sleep(2000);
        waitForElement($x("//*[@id='carmileageinkms_max']"));
        $x("//*[@id='carmileageinkms_max']").sendKeys(carMaxMileage);
//        sleep(2000);
        $x("//button[@aria-label='Apply Kilometers']").scrollIntoView(true).hover().click();
        sleep(5000);
    }

    public void setPrice() {
//        sleep(5000);
        waitForElement(priceMin);
        priceMin.sendKeys(carMinPrice);
        waitForElement(priceMax);
//        sleep(5000);
        priceMax.sendKeys(carMaxPrice);
//        sleep(5000);
        $x(BUTTON_PRICE_ELEMENT).click();
        sleep(5000);
    }

    public void setCarBrand() {
        $x("//label[text()='" + carBrand + "']").scrollIntoView(true).click();
        sleep(10000);
    }

    public void setCarType() {
        waitForElement($x("//label[text()='SUV, Crossover']"));
        $x("//label[text()='SUV, Crossover']").scrollIntoView(true).click();
        sleep(5000);
    }

    public void setCarYear() {
        waitForElement($x("//input[@id='caryear_min']"));
        $x("//input[@id='caryear_min']").sendKeys(carMinYear);
        sleep(2000);
        $x("//button[@aria-label='Apply Year']").scrollIntoView(true).hover().click();
        sleep(5000);
    }

    public void waitForElement(SelenideElement element){
        if (element.exists()) {
            element.shouldBe(Condition.visible, Duration.ofSeconds(10));
        } else {
            sleep(5000);
            if (element.exists()) {
                element.shouldBe(Condition.visible, Duration.ofSeconds(10));
                System.out.println(element + " is visible after 5000 ms");
            } else {
                sleep(5000);
                if (element.isDisplayed()) {
                    System.out.println(element + " is visible after 10000 ms");
                } else {
                    System.out.println(element + " isn't existed!!!");
                }
            }
        }
    }

    public void getLinksFromLists(){
        System.out.println("Start of getLinksFromLists");

        waitForElement($x(LIST_CAR_ITEM));

        if((!$$x(LIST_CAR_ITEM).isEmpty())) {
            sleep(1000);

            List<SelenideElement> itemsFromList = $$x(LIST_CAR_ITEM);
            for (SelenideElement item : itemsFromList) {

                item.hover();

                waitForElement(item.find(By.cssSelector(CAR_NAME_ELEMENT)));
                if(item.find(By.cssSelector(CAR_NAME_ELEMENT)).exists()) {
                    carName = item.find(By.cssSelector(CAR_NAME_ELEMENT)).getText().replaceAll(",", " / ").replaceAll("\\s+", " ");
                }

                waitForElement(item.find(By.cssSelector(CAR_PRICE_ELEMENT)));
                if(item.find(By.cssSelector(CAR_PRICE_ELEMENT)).exists()) {
                    carPrice = item.find(By.cssSelector(CAR_PRICE_ELEMENT)).getText().replaceAll(",", "").replaceAll("\\D", "").replaceAll("\\s+", " ");
                }

                waitForElement(item.find(By.cssSelector(CAR_LOCATION_ELEMENT)));
                if(item.find(By.cssSelector(CAR_LOCATION_ELEMENT)).exists()) {
                    carLocation = item.find(By.cssSelector(CAR_LOCATION_ELEMENT)).getText().replaceAll(",", "").replaceAll("\\s+", " ");
                }

                waitForElement(item.find(By.cssSelector(CAR_DATE_ELEMENT)));
                if(item.find(By.cssSelector(CAR_DATE_ELEMENT)).exists()){
                carDate = item.find(By.cssSelector(CAR_DATE_ELEMENT)).getText().replaceAll(",","").replaceAll("\\s+"," ");
                }

                waitForElement(item.find(By.cssSelector(CAR_MILEAGE_ELEMENT)));
                if(item.find(By.cssSelector(CAR_MILEAGE_ELEMENT)).exists()) {
                    carMileage = item.find(By.cssSelector(CAR_MILEAGE_ELEMENT)).getText().replaceAll(",","").replaceAll("\\D", "").replaceAll("\\s+"," ");
                }

                waitForElement(item.find(By.cssSelector(CAR_URL_ELEMENT)));
                if(item.find(By.cssSelector(CAR_URL_ELEMENT)).exists()) {
                    carUrl = item.find(By.cssSelector(CAR_URL_ELEMENT)).attr("href");
                }

                Car car = new Car(carName, carBrand, carPrice, carLocation, carDate, carMileage, carUrl);
                CarsWithUrl.add(car);

                System.out.println(carName);
                System.out.println(carPrice);
                System.out.println(carLocation);
                System.out.println(carDate);
                System.out.println(carMileage);
                System.out.println(carUrl);
                System.out.println("------------------");
                carName = "Empty";
                carPrice = "Empty";
                carLocation = "Empty";
                carDate = "Empty";
                carMileage = "Empty";
                carUrl = "Empty";

            }

            if(buttonNextPage.exists()){
                buttonNextPage.hover().click();
                sleep(10000);
                getLinksFromLists();
            } else {
                System.out.println("getLinksFromLists ends");
            }
        }

    }

    public void writeCsvFile() throws FileNotFoundException {
        CarsWithUrl.add(0, FIRST_LINE);
        Date date = new Date();
        Format formatter = new SimpleDateFormat("yyyy-MM-dd__HH-mm-ss");
        String dateString = formatter.format(date);

        File csvFile = new File("results/" + dateString + "__" + locationName.replaceAll(", ", "_") + "__" + NAME_WEBSITE + ".csv");
        PrintWriter out = new PrintWriter(csvFile);

        for(Car car : CarsWithUrl){
            out.printf("%s, %s, %s, %s, %s, %s, %s\n", car.getCarName(), car.getCarBrand(), car.getCarPrice(), car.getCarLocation(), car.getCarDate(), car.getCarMileage(), car.getCarUrl());
        }

        out.close();
    }

}
