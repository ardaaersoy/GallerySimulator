package Iterator;

import Vehicles.Car;

import java.util.Iterator;

public class CarIterator implements Iterator {

    Car[] carList;
    private int position = 0;

    public CarIterator(Car[] carList) {
        this.carList = carList;
    }

    @Override
    public boolean hasNext() {
        if (position < carList.length) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return carList[position++];
        }
        return null;
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("You can't remove the car.");
        }
        if (carList[position - 1] != null) {
            for (int i = position - 1; i < (carList.length - 1); i++) {
                carList[i] = carList[i + 1];
            }
            carList[carList.length - 1] = null;
        }
    }
}
