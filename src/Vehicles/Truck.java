package Vehicles;

import Main.Vehicle;

public class Truck extends Vehicle {

    public Truck(int id, String brand, String model, int year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price();
        this.description = getDescription();
    }

    @Override
    public int price() {
        return 100000;
    }

    @Override
    public String getDescription() {
        return "Truck";
    }

    @Override
    public String toString() {
        return "\nTruck\n------------" + super.toString();
    }
}
