// Step 1: Command Interface with execute() method
interface Command {
    void execute(); // execute method jo commands ko execute karega
}

// Step 2: Concrete Command for Light On
class LightOnCommand implements Command {
    private Light light; // Light object ko command execute karne ke liye pass karenge

    public LightOnCommand(Light light) {
        this.light = light; // constructor mein light ko initialize kar rahe hain
    }

    @Override
    public void execute() {
        light.turnOn(); // Light ko turn on karte hain
    }
}

// Step 3: Concrete Command for Light Off
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff(); // Light ko turn off karte hain
    }
}

// Step 4: Concrete Command for Garage Door Up
class GarageDoorUpCommand implements Command {
    private GarageDoor garageDoor;

    public GarageDoorUpCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up(); // Garage door ko upar karte hain
    }
}

// Step 5: Concrete Command for Stereo On with CD
class StereoOnWithCDCommand implements Command {
    private Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.onWithCD(); // Stereo ko on karte hain with CD
    }
}

// Step 6: Receiver Classes
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

class GarageDoor {
    public void up() {
        System.out.println("Garage Door is Up");
    }

    public void down() {
        System.out.println("Garage Door is Down");
    }
}

class Stereo {
    public void onWithCD() {
        System.out.println("Stereo is ON with CD");
    }

    public void off() {
        System.out.println("Stereo is OFF");
    }
}

// Step 7: Invoker Class - to call commands
class RemoteControl {
    private Command command; // Single command object to execute a command

    public void setCommand(Command command) {
        this.command = command; // Command set karna
    }

    public void pressButton() {
        command.execute(); // Command execute karwana
    }
}

// Step 8: Client Code to test Command Pattern
public class CommandPatternTest {
    public static void main(String[] args) {
        // Step 8.1: Creating receiver objects (Light, GarageDoor, Stereo)
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo();

        // Step 8.2: Creating command objects and associating with receivers
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command garageDoorUp = new GarageDoorUpCommand(garageDoor);
        Command stereoOnWithCD = new StereoOnWithCDCommand(stereo);

        // Step 8.3: Creating invoker object (RemoteControl)
        RemoteControl remoteControl = new RemoteControl();

        // Step 8.4: Testing the commands by pressing buttons
        remoteControl.setCommand(lightOn);
        remoteControl.pressButton(); // Light ON

        remoteControl.setCommand(lightOff);
        remoteControl.pressButton(); // Light OFF

        remoteControl.setCommand(garageDoorUp);
        remoteControl.pressButton(); // Garage Door UP

        remoteControl.setCommand(stereoOnWithCD);
        remoteControl.pressButton(); // Stereo ON with CD
    }
}
