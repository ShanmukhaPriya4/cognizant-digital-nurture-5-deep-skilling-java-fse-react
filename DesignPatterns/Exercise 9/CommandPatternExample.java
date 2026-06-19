// Command Interface
interface Command {
    void execute();
}

// Receiver Class
class Light {

    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Concrete Command - Light ON
class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete Command - Light OFF
class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Invoker Class
class RemoteControl {

    private Command command;

    // Set Command
    public void setCommand(Command command) {
        this.command = command;
    }

    // Execute Command
    public void pressButton() {
        command.execute();
    }
}

// Main Class
public class CommandPatternExample {

    public static void main(String[] args) {

        // Receiver
        Light light = new Light();

        // Commands
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // Turn ON the light
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn OFF the light
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
