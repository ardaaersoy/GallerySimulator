package Decorator.Modifications;

import Decorator.ModifiedDecorator;
import Main.Vehicle;

public class Rim extends ModifiedDecorator {

    Vehicle vehicle;

    public Rim(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String getDescription() {
        return this.vehicle.getDescription() + " Rims added,";
    }

    @Override
    public int price() {
        return 3000 + this.vehicle.price();
    }

    @Override
    public String toString() {
        return this.vehicle + "";
    }
}
