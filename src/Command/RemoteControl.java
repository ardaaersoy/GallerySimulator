package Command;

public class RemoteControl {
    CommandInterface[] openCommands;
    CommandInterface[] closeCommands;

    public RemoteControl() {
        this.openCommands = new CommandInterface[2];
        this.closeCommands = new CommandInterface[2];

        CommandInterface noCommand = new NoCommand();

        for (int i = 0; i < 2; i++) {
            openCommands[i] = noCommand;
            closeCommands[i] = noCommand;
        }
    }

    public void setCommand(int index, CommandInterface openCommand, CommandInterface closeCommand) {
        this.openCommands[index] = openCommand;
        this.closeCommands[index] = closeCommand;
    }

    public void openButtonWasPressed(int index) {
        this.openCommands[index].execute();
    }

    public void closeButtonWasPressed(int index) {
        this.closeCommands[index].execute();
    }

    @Override
    public String toString() {
        return "RemoteControl{" + "openCommands=" + openCommands + ", closeCommands=" + closeCommands + '}';
    }
}
