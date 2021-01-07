package Command;

import Main.Vehicle;

public class EngineOnCommand implements CommandInterface {

    Vehicle vehicle;

    public EngineOnCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.engineOn();
    }
}
