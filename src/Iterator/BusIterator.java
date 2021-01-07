package Iterator;

import Vehicles.Bus;

import java.util.ArrayList;
import java.util.Iterator;

public class BusIterator implements Iterator {

    ArrayList<Bus> busList;
    int position = 0;

    public BusIterator(ArrayList<Bus> busList) {
        this.busList = busList;
    }

    @Override
    public boolean hasNext() {
        if (position < busList.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return busList.get(position++);
        }
        return null;
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("You can't remove the car.");
        } else {
            busList.remove(position);
        }
    }
}
