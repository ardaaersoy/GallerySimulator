package Singleton;

import Adapter.Motorcycle;
import Main.Vehicle;
import Vehicles.Car;

import java.util.Iterator;

import Iterator.VehicleCreateIterator;

import static Main.GallerySimulator.remoteControl;
import static Main.GallerySimulator.selectedVehicle;

import Main.GallerySys;
import Vehicles.Bus;
import Vehicles.Truck;


public class SingletonGallery {

    VehicleCreateIterator vehicleCatalog;

    private static SingletonGallery uniqueInstance;

    private SingletonGallery() {
    }

    public static SingletonGallery getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonGallery();
        }
        return uniqueInstance;
    }

    public void setCatalog(VehicleCreateIterator vehicleCatalog) {
        this.vehicleCatalog = vehicleCatalog;
    }

    public void printItems() {
        Iterator vehicleIterator = vehicleCatalog.createIterator();
        printCatalog(vehicleIterator);
    }

    private void printCatalog(Iterator iterator) {
        while (iterator.hasNext()) {
            Vehicle vehicle = (Vehicle) iterator.next();
            System.out.println(vehicle.toString());
        }
    }

    public void printSingleCatalog(VehicleCreateIterator vehicleCatalog, String type) {
        Iterator vehicleIterator = vehicleCatalog.createIterator();
        System.out.println("\n--------------------------------");
        while (vehicleIterator.hasNext()) {
            switch (type) {
                case "Car": {
                    Object o = vehicleIterator.next();
                    if (o instanceof Car) {
                        System.out.println(o.toString());
                    }
                }
                break;
                case "Motorcycle": {
                    Object o = vehicleIterator.next();
                    if (o instanceof Motorcycle) {
                        System.out.println(o.toString());
                    }
                }
                break;
                case "Bus": {
                    Object o = vehicleIterator.next();
                    if (o instanceof Bus) {
                        System.out.println(o.toString());
                    }
                }
                break;
                case "Truck": {
                    Object o = vehicleIterator.next();
                    if (o instanceof Truck) {
                        System.out.println(o.toString());
                    }
                }
                break;
            }
        }
        System.out.println("\n--------------------------------");
    }

    public void remoteController() {
        remoteControl = GallerySys.setRemoteControl(selectedVehicle);

        int commandSelection = GallerySys.selectCommand();
        while (commandSelection != 5) {
            switch (commandSelection) {
                case 1:
                    remoteControl.openButtonWasPressed(0);
                    break;
                case 2:
                    remoteControl.closeButtonWasPressed(0);
                    break;
                case 3:
                    remoteControl.openButtonWasPressed(1);
                    break;
                case 4:
                    remoteControl.closeButtonWasPressed(1);
                    break;
            }
            commandSelection = GallerySys.selectCommand();
        }
    }
}
