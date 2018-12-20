package designPattern;

import java.util.ArrayList;
import java.util.List;

public class CommandPatternExample{
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver();
        TurnOnLightCommand turnOnLightCommand = new TurnOnLightCommand(receiver);
        TurnOffLightCommand turnOffLightCommand = new TurnOffLightCommand(receiver);
        invoker.addCommand(turnOnLightCommand);
        invoker.addCommand(turnOffLightCommand);

        invoker.executeCommand();
        invoker.undoCommand();
    }
}

class Invoker{
    List<Command> commandList;

    public Invoker() {
        this.commandList = new ArrayList<>();
    }
    void executeCommand(){
        commandList.get(commandList.size() -1).execute();
    }

    public void addCommand(Command command) {
        commandList.add(command);
    }
    public void undoCommand(){
        commandList.remove(commandList.size() - 1);
        executeCommand();
    }
}

interface Command{
    void execute();
}

class TurnOnLightCommand implements Command{
    private Receiver receiver;
    public TurnOnLightCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.turnOnLight();
    }

}

class TurnOffLightCommand implements Command{
    private Receiver receiver;
    public TurnOffLightCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.turnOffLight();
    }
}

class Receiver{
    public void turnOnLight() {
        System.out.println("Turn on Light");
        // Many detailed code here, the invoker knows nothing about the command and the receiver.
        // He just wants something to be done by some receiver
    }
    public void turnOffLight() {
        System.out.println("Turn off Light");
    }
}