package Decorator.Modifications;

import Decorator.ModifiedDecorator;
import Main.Vehicle;

public class Exhaust extends ModifiedDecorator {

    Vehicle vehicle;

    public Exhaust(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String getDescription() {
        return this.vehicle.getDescription() + " Exhaust added, ";
    }

    @Override
    public int price() {
        return 2000 + this.vehicle.price();
    }

    @Override
    public String toString() {
        return this.vehicle + "";
    }
}
