package Command;

import Main.Vehicle;

public class DoorOpenCommand implements CommandInterface {

    Vehicle vehicle;

    public DoorOpenCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.openDoor();
    }
}
