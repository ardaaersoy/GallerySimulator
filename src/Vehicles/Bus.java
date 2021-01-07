package Vehicles;

import Main.Vehicle;

public class Bus extends Vehicle {

    public Bus(int id, String brand, String model, int year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.description = getDescription();
        this.price = price();
    }

    @Override
    public int price() {
        return 80000;
    }

    @Override
    public String getDescription() {
        return "Bus";
    }

    @Override
    public String toString() {
        return "\nBus\n------------" + super.toString();
    }
}
