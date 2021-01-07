package Iterator;

import Adapter.Motorcycle;
import Main.Vehicle;

import java.util.Hashtable;
import java.util.Iterator;


public class VehicleCatalog implements VehicleCreateIterator {

    Hashtable vehicleItems = new Hashtable();

    @Override
    public Iterator createIterator() {
        return vehicleItems.values().iterator();
    }

    public void addItem(Vehicle b) {
        vehicleItems.put(b.getId(), b);
    }

    public void addItem(Motorcycle c) {
        vehicleItems.put(c.getId(), c);
    }

    public Vehicle getItem(int id) {
        Object o = vehicleItems.get(id);
        if (o instanceof Vehicle) {
            return (Vehicle) o;
        }

        return null;
    }

    public Motorcycle getMotorcycle(int id) {
        Object o = vehicleItems.get(id);
        if (o instanceof Motorcycle) {
            return (Motorcycle) o;
        }

        return null;
    }

    public void updatePrice(int index, int price) {
        Vehicle v = (Vehicle) vehicleItems.get(index);
        v.setPrice(price);
    }

    public void updateDescription(int index, String description) {
        Vehicle v = (Vehicle) vehicleItems.get(index);
        v.setDescription(description);
    }

    public boolean exist(int id) {
        return vehicleItems.containsKey(id);
    }
}
