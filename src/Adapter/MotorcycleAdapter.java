package Adapter;

import Vehicles.CarInterface;

public class MotorcycleAdapter implements CarInterface {

    Motorcycle motorcycle;

    public MotorcycleAdapter(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }

    @Override
    public void honk() {
        motorcycle.honk();
    }

    @Override
    public void accelerate() {
        for (int i = 0; i < 3; i++) {
            motorcycle.accelerate();

        }
    }

    @Override
    public void modificationFeature() {
        motorcycle.modificationFeature();
    }
}
