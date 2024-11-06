package Slip7;

// Command interface jo execute method declare karta hai
interface Command {
    void execute(); // Action perform karne ke liye
}

// Light class jo ON aur OFF actions ko define karti hai
class Light {
    public void on() {
        System.out.println("Light is ON"); // Light ko ON karta hai
    }

    public void off() {
        System.out.println("Light is OFF"); // Light ko OFF karta hai
    }
}

// LightOnCommand class jo Light ko ON karne ka kaam karti hai
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on(); // Light ko ON karta hai
    }
}

// LightOffCommand class jo Light ko OFF karne ka kaam karti hai
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off(); // Light ko OFF karta hai
    }
}

// RemoteControl class jo buttons ke liye commands ko store karta hai
class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[2];
        offCommands = new Command[2];
    }

    // On command set karta hai specific slot mein
    public void setOnCommand(int slot, Command command) {
        onCommands[slot] = command;
    }

    // Off command set karta hai specific slot mein
    public void setOffCommand(int slot, Command command) {
        offCommands[slot] = command;
    }

    // On button press hone pe execute karta hai
    public void pressOnButton(int slot) {
        if (onCommands[slot] != null) {
            onCommands[slot].execute();
        } else {
            System.out.println("No command assigned to ON button at slot " + slot);
        }
    }

    // Off button press hone pe execute karta hai
    public void pressOffButton(int slot) {
        if (offCommands[slot] != null) {
            offCommands[slot].execute();
        } else {
            System.out.println("No command assigned to OFF button at slot " + slot);
        }
    }
}

// Client class jo sab kuch configure karti hai
public class RemoteControlTest {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl(); // RemoteControl ka object banate hain
        Light livingRoomLight = new Light(); // Light ka object banate hain

        // ON aur OFF commands set karte hain Light ke liye
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Remote mein buttons set karte hain
        remote.setOnCommand(0, lightOn);
        remote.setOffCommand(0, lightOff);

        // Buttons press kar ke test karte hain
        System.out.println("Testing ON button:");
        remote.pressOnButton(0); // Light ON hona chahiye

        System.out.println("Testing OFF button:");
        remote.pressOffButton(0); // Light OFF hona chahiye
    }
}
