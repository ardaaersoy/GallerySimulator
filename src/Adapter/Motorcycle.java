package Adapter;

public class Motorcycle implements MotorcycleInterface {

    private int id;
    private String brand;
    private String model;
    private int year;
    private int price;
    private String description;

    public Motorcycle(int id, String brand, String model, int year, int price, String description) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.description = description;
    }

    @Override
    public void honk() {
        System.out.println("Motorcycle honks: Diiit Di Diiiiiit");
    }

    @Override
    public void accelerate() {
        System.out.println("0-100 km/h acceleration is 6 seconds.");
    }

    @Override
    public void modificationFeature() {
        System.out.println("You cannot modify your motorcycle");
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\nMotorcycle -->\nID:" + id + ", \nBrand:" + brand + ", \nModel:" + model + ", \nYear:" + year + ", \nPrice:" + price + ", \nDescription:" + description;
    }

    public int getPrice() {
        return price;
    }
}
