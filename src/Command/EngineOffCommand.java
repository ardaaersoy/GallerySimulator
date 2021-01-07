package Command;

import Main.Vehicle;

public class EngineOffCommand implements CommandInterface {

    Vehicle vehicle;

    public EngineOffCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.engineOff();
    }
}
