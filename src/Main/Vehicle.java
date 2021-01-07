package Main;

public abstract class Vehicle {

    protected int id;
    protected String brand;
    protected String model;
    protected int year;
    public int price;
    public String description;

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public abstract int price();

    public void openDoor() {
        System.out.println("Doors are opened.");
    }

    public void closeDoor() {
        System.out.println("Doors are closed.");
    }

    public void engineOn() {
        System.out.println("Engine is on. You can hear the sound.");
    }

    public void engineOff() {
        System.out.println("Engine is off.");
    }

    @Override
    public String toString() {
        return "\nID:" + id + ", \nBrand:" + brand + ", \nModel:" + model + ", \nYear:" + year + ", \nPrice:" + price + ", \nDescription:" + description;
    }
}
