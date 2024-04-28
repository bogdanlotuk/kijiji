package base;

import org.jetbrains.annotations.NotNull;

public class Constants {
    public static String BASE_URL = "";
    public static String GLOBAL_FILTER = "";
    public static String GLOBAL_FILTER_VALUE = "";
    public static String GLOBAL_FILTER_VALUE_CATEGORY = "";
    public static String BUTTON_SEARCH = "";
    public static String PRICE_MIN_ELEMENT = "";
    public static String PRICE_MAX_ELEMENT = "";
    public static String BUTTON_PRICE_ELEMENT = "";
    public static String NEXT_PAGE_ELEMENT = "";
    public static String LIST_CAR_ITEM = "";
    public static String LIST_CAR_LINK = "";
    public static String CAR_NAME_ELEMENT = "";
    public static String CAR_BRAND_ELEMENT = "";
    public static String CAR_PRICE_ELEMENT = "";
    public static String CAR_LOCATION_ELEMENT = "";
    public static String CAR_DATE_ELEMENT = "";
    public static String CAR_MILEAGE_FILTER = "";
    public static String CAR_MILEAGE_FILTER_VALUE_MAX = "";
    public static String CAR_MILEAGE_FILTER_BUTTON = "";
    public static String CAR_MILEAGE_ELEMENT = "";
    public static String CAR_YEAR_MIN_ELEMENT = "";
    public static String CAR_YEAR_BUTTON = "";
    public static String CAR_URL_ELEMENT = "";
    public static String MODAL_CLOSE_BUTTON = "";
    public static String NAME_WEBSITE = "";

    public void setConstants(@NotNull String website){
        switch (website){
            case "kijijiCars":
                kijijiCars();
                break;
            default:
                break;
        }
    }

    public void kijijiCars() {
        BASE_URL = "https://www.kijiji.ca/";
        GLOBAL_FILTER = "//*[@data-id='SearchCategory' or @data-testid='category-dropdown']";
        GLOBAL_FILTER_VALUE = "//*[@id='category-dropdown-item-2']";
        GLOBAL_FILTER_VALUE_CATEGORY = "//a[contains(text(), 'Cars & Trucks')]";
        BUTTON_SEARCH = "//button[@data-testid='header-button-submit']";
        BUTTON_PRICE_ELEMENT = "//button[@aria-label='Apply Price']";
        PRICE_MIN_ELEMENT = "//input[@id='price_min']";
        PRICE_MAX_ELEMENT = "//input[@id='price_max']";
        LIST_CAR_ITEM ="//ul[@data-testid='srp-search-list']//section[@data-testid='listing-card']";
        LIST_CAR_LINK = "//a[@data-testid='listing-link']";
        CAR_NAME_ELEMENT = "h3[data-testid='listing-title']";
        CAR_BRAND_ELEMENT = "";
        CAR_PRICE_ELEMENT = "p[data-testid='autos-listing-price']";
        CAR_LOCATION_ELEMENT = "p[data-testid='listing-location']";
        CAR_DATE_ELEMENT = "p[data-testid='listing-date']";
        CAR_MILEAGE_FILTER = "//*[@id='accordion__heading-carmileageinkms']";
        CAR_MILEAGE_FILTER_VALUE_MAX = "//*[@id='accordion__heading-carmileageinkms']";
        CAR_MILEAGE_FILTER_BUTTON = "//button[@aria-label='Apply Kilometers']";
        CAR_MILEAGE_ELEMENT = "svg[viewBox='0 0 24 24']+p";
        CAR_YEAR_MIN_ELEMENT = "//input[@id='caryear_min']";
        CAR_YEAR_BUTTON = "//input[@id='caryear_min']";
        CAR_URL_ELEMENT = "a[data-testid='listing-link']";
        NEXT_PAGE_ELEMENT = "//li[@data-testid='pagination-next-link']/a[contains(text(), 'Next')]";
        MODAL_CLOSE_BUTTON = "//div[@aria-modal='true']//button[@aria-label='close']";
    }

    public static Car FIRST_LINE = new Car("CAR_NAME", "BRAND", "PRICE", "LOCATION", "DATE", "MILEAGE", "URL");
}
