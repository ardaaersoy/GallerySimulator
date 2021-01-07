package Decorator.Modifications;

import Decorator.ModifiedDecorator;
import Main.Vehicle;

public class GlassCeiling extends ModifiedDecorator {

    Vehicle vehicle;

    public GlassCeiling(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String getDescription() {
        return vehicle.getDescription() + " Glass Ceiling added,";
    }

    @Override
    public int price() {
        return 5000 + vehicle.price();
    }

    @Override
    public String toString() {
        return vehicle + "";
    }
}
