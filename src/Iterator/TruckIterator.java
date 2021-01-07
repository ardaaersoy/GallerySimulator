package Iterator;

import Vehicles.Truck;

import java.util.ArrayList;
import java.util.Iterator;

public class TruckIterator implements Iterator {

    ArrayList<Truck> truckList;
    int position = 0;

    public TruckIterator(ArrayList<Truck> truckList) {
        this.truckList = truckList;
    }

    @Override
    public boolean hasNext() {
        if (position < truckList.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return truckList.get(position++);
        }
        return null;
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("You can't remove the car.");
        } else {
            truckList.remove(position);
        }
    }
}
