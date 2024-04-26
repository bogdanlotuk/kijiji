package base;

public class Car {
    private String _carName;
    private String _carBrand;
    private String _carPrice;
    private String _carLocation;
    private String _carDate;
    private String _carMileage;
    private String _carUrl;

    public Car(String carName, String carBrand, String carPrice, String carLocation, String carDate, String carMileage , String carUrl){
        _carName = carName;
        _carBrand = carBrand;
        _carPrice = carPrice;
        _carLocation = carLocation;
        _carDate = carDate;
        _carMileage = carMileage;
        _carUrl = carUrl;
    }

    public String getCarName(){
        return _carName;
    }
    public String getCarPrice(){ return _carPrice; }
    public String getCarLocation(){ return _carLocation; }
    public String getCarBrand(){ return _carBrand; }
    public String getCarDate(){ return _carDate; }
    public String getCarMileage(){ return _carMileage; }
    public String getCarUrl(){ return _carUrl; }

    public String toString(){
        return String.format("Car name: %s, brand: %s, price: %s, location: %s, date: %s, mileage: %, url: %", getCarName(), getCarBrand(), getCarPrice(), getCarLocation(), getCarDate(), getCarMileage(), getCarUrl());
    }

}
