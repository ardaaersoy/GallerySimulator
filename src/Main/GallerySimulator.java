package Main;

import Adapter.Motorcycle;
import Adapter.MotorcycleAdapter;
import Command.RemoteControl;
import Decorator.Modifications.Exhaust;
import Decorator.Modifications.GlassCeiling;
import Decorator.Modifications.Rim;
import Iterator.VehicleCatalog;
import Singleton.SingletonGallery;
import Vehicles.Car;

import java.util.Scanner;

import Iterator.VehicleCreateIterator;

public class GallerySimulator {

    public static VehicleCatalog vehicleCatalog = new VehicleCatalog();
    public static VehicleCreateIterator vci;
    public static int id = 1;
    public static Vehicle selectedVehicle;
    public static Motorcycle selectedMotorcycle;
    public static int selectedVehicleId;
    public static RemoteControl remoteControl;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GallerySys.addVehicles();

        int catalogMenu = GallerySys.vehicleCatalogMenu();

        selectedVehicleId = GallerySys.chooseVehicle();

        if (catalogMenu != 4) {
            selectedVehicle = vehicleCatalog.getItem(selectedVehicleId);

            System.out.println(selectedVehicle.toString());
            if (catalogMenu == 1) {
                Car c = (Car) selectedVehicle;
                c.accelerate();
                c.honk();
                c.modificationFeature();
            }

            int modificationSelection = GallerySys.chooseMoficiationType();

            while (modificationSelection != 4) {
                switch (modificationSelection) {
                    case 1: {
                        selectedVehicle = new Rim(selectedVehicle);
                        System.out.println(selectedVehicle.getDescription());
                        selectedVehicle.price();
                        break;
                    }
                    case 2: {
                        selectedVehicle = new GlassCeiling(selectedVehicle);
                        System.out.println(selectedVehicle.getDescription());
                        selectedVehicle.price();
                        break;
                    }
                    case 3: {
                        selectedVehicle = new Exhaust(selectedVehicle);
                        System.out.println(selectedVehicle.getDescription());
                        selectedVehicle.price();
                        break;
                    }
                }
                modificationSelection = GallerySys.chooseMoficiationType();
            }

            vehicleCatalog.updateDescription(selectedVehicleId, selectedVehicle.getDescription());
            vehicleCatalog.updatePrice(selectedVehicleId, selectedVehicle.price());
            System.out.println("Your modified vehicle is\n---------------\n" + selectedVehicle.toString());

            SingletonGallery.getInstance().remoteController();
            System.out.println("\nWe completed your order. This is vehicle you want:" + selectedVehicle.toString() + "\nPrice you need to pay is: " + selectedVehicle.price());

        } else {
            selectedMotorcycle = vehicleCatalog.getMotorcycle(selectedVehicleId);
            if (selectedMotorcycle != null) {
                System.out.println(selectedMotorcycle.toString());
                MotorcycleAdapter adapter = new MotorcycleAdapter(selectedMotorcycle);
                adapter.accelerate();
                adapter.honk();
                adapter.modificationFeature();
                System.out.println("\nWe completed your order. This is vehicle you want:" + selectedMotorcycle.toString() + "\nPrice you need to pay is: " + selectedMotorcycle.getPrice());

            } else {
                System.out.println("There is no motorcycle try again");
            }
        }
    }
}
