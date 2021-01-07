package Vehicles;

import Main.Vehicle;

public class Car extends Vehicle implements CarInterface {

    public Car(int id, String brand, String model, int year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.description = getDescription();
        this.price = price();
    }

    @Override
    public int price() {
        return 35000;
    }

    @Override
    public String getDescription() {
        return "Car";
    }

    @Override
    public void honk() {
        System.out.println("Car honks: Daaaaaaaat Da Da Daaaaat");
    }

    @Override
    public void accelerate() {
        System.out.println("0-100 km/h acceleration is 11 seconds.");
    }

    @Override
    public void modificationFeature() {
        System.out.println("You can modify your car");
    }

    @Override
    public String toString() {
        return "\nAutomobile\n------------ " + super.toString();
    }
}
