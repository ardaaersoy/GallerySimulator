
package Main;

import Adapter.Motorcycle;
import Command.DoorCloseCommand;
import Command.DoorOpenCommand;
import Command.EngineOffCommand;
import Command.EngineOnCommand;
import Command.RemoteControl;

import static Main.GallerySimulator.id;
import static Main.GallerySimulator.vci;
import static Main.GallerySimulator.vehicleCatalog;

import Singleton.SingletonGallery;
import Vehicles.Bus;
import Vehicles.Car;
import Vehicles.Truck;

import java.util.Scanner;


public class GallerySys {

    public static Scanner scanner = new Scanner(System.in);

    public static void addVehicles() {
        Vehicle car = new Car(id++, "BWM", "520d", 2020);
        Vehicle car1 = new Car(id++, "Volvo", "S900", 2020);
        Vehicle car2 = new Car(id++, "Audi", "A8", 2020);

        Vehicle bus = new Bus(id++, "Setra", "S 415", 2020);
        Vehicle bus1 = new Bus(id++, "Mercedes", "Travego", 2020);
        Vehicle bus2 = new Bus(id++, "Neoplan", "Tourliner", 2020);

        Vehicle truck = new Truck(id++, "MAN", "TGS", 2020);
        Vehicle truck1 = new Truck(id++, "Scania", "G", 2020);
        Vehicle truck2 = new Truck(id++, "Ford Trucks", "Cargo", 2020);

        Motorcycle motor1 = new Motorcycle(id++, "Honda", "CBR 125 R", 2020, 15000, "Az yakar çok kaçar.");
        Motorcycle motor2 = new Motorcycle(id++, "Kawasaki", "Ninja ZX-10R", 2020, 15000, "Az yakar çok kaçar.");
        Motorcycle motor3 = new Motorcycle(id++, "Yamaha", "YZF R25", 2020, 15000, "Az yakar çok kaçar.");

        vehicleCatalog.addItem(car);
        vehicleCatalog.addItem(car1);
        vehicleCatalog.addItem(car2);

        vehicleCatalog.addItem(bus);
        vehicleCatalog.addItem(bus1);
        vehicleCatalog.addItem(bus2);

        vehicleCatalog.addItem(truck);
        vehicleCatalog.addItem(truck1);
        vehicleCatalog.addItem(truck2);

        vehicleCatalog.addItem(motor1);
        vehicleCatalog.addItem(motor2);
        vehicleCatalog.addItem(motor3);

        vci = vehicleCatalog;

        SingletonGallery.getInstance().setCatalog(vci);
    }

    public static int vehicleCatalogMenu() {
        int catalogMenu;
        System.out.println("\n--------Welcome to ERCOL Vehicle Gallery---------------");
        System.out.println("\n-------------\n1. Automobile\n2. Truck\n3. Bus\n4. Motorcycle\n5. Exit\n-------------\nPlease select the vehicle type you want to display.");
        catalogMenu = scanner.nextInt();
        while (catalogMenu < 1 || catalogMenu > 5) {
            System.out.println("Invalid. Please re-enter your choice:");
            catalogMenu = scanner.nextInt();
        }
        switch (catalogMenu) {
            case 1: {
                SingletonGallery.getInstance().printSingleCatalog(vci, "Car");
            }
            break;
            case 2: {
                SingletonGallery.getInstance().printSingleCatalog(vci, "Truck");
            }
            break;
            case 3: {
                SingletonGallery.getInstance().printSingleCatalog(vci, "Bus");
            }
            break;
            case 4: {
                SingletonGallery.getInstance().printSingleCatalog(vci, "Motorcycle");
            }
            case 5:
                break;
        }

        return catalogMenu;
    }

    public static int chooseVehicle() {
        System.out.println("\nPlease enter the id of vehicle you want to buy.");
        int selectedVehicleId = scanner.nextInt();
        boolean flag = false;
        if (!vehicleCatalog.exist(selectedVehicleId)) {
            while (!flag) {
                System.out.println("Wrong ID!!!! Please enter correct id.");
                selectedVehicleId = scanner.nextInt();
                if (vehicleCatalog.exist(selectedVehicleId)) {
                    flag = true;
                }
            }
        }

        return selectedVehicleId;
    }

    public static int chooseMoficiationType() {
        System.out.println("\n\n1. Rims\n2. Glass Ceiling\n3. Exhaust\n4. Nothing");
        System.out.println("\nWhat do you want to add your vehicle?");
        int modificationSelection = scanner.nextInt();
        while (modificationSelection < 1 || modificationSelection > 4) {
            System.out.println("Wrong Selection!!!! Please enter correct modification type.");
            modificationSelection = scanner.nextInt();
        }

        return modificationSelection;
    }

    public static RemoteControl setRemoteControl(Vehicle vehicle) {
        RemoteControl remoteControl = new RemoteControl();
        DoorCloseCommand dcc = new DoorCloseCommand(vehicle);
        DoorOpenCommand doc = new DoorOpenCommand(vehicle);
        EngineOnCommand eonc = new EngineOnCommand(vehicle);
        EngineOffCommand eoffc = new EngineOffCommand(vehicle);

        remoteControl.setCommand(0, doc, dcc);
        remoteControl.setCommand(1, eonc, eoffc);

        return remoteControl;
    }

    public static int selectCommand() {
        System.out.println("\n\n1. Open Door\n2. Close Door\n3. Engine On\n4. Engine Off\n5. Exit");
        System.out.println("\nWhat do you want next?");
        int commandSelection = scanner.nextInt();
        while (commandSelection < 1 || commandSelection > 5) {
            System.out.println("Wrong Selection!!!! Please enter correct command type.");
            commandSelection = scanner.nextInt();
        }

        return commandSelection;
    }
}
