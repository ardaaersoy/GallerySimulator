package Command;

import Main.Vehicle;

public class DoorCloseCommand implements CommandInterface {

    Vehicle vehicle;

    public DoorCloseCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.closeDoor();
    }
}
