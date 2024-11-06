// Command interface jo execute aur undo methods declare karta hai

import Slip7.Command;
import Slip7.RemoteControl;

interface Command {
    void execute(); // Action ko perform karne ke liye

    void undo(); // Previous action ko undo karne ke liye
}

// CeilingFan class jo fan ke speeds ko define karta hai
class CeilingFan {
    public static final int OFF = 0;
    public static final int LOW = 1;
    public static final int MEDIUM = 2;
    public static final int HIGH = 3;

    private int speed;

    public CeilingFan() {
        speed = OFF; // Initial speed OFF hai
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        String speedString = switch (speed) {
            case HIGH -> "HIGH";
            case MEDIUM -> "MEDIUM";
            case LOW -> "LOW";
            default -> "OFF";
        };
        System.out.println("Ceiling Fan speed is set to " + speedString);
    }

    public int getSpeed() {
        return speed; // Current speed ko return karta hai
    }
}

// FanSpeedCommand class jo speed set aur undo karne ka kaam karti hai
class FanSpeedCommand implements Command {
    private CeilingFan fan;
    private int prevSpeed;
    private int newSpeed;

    public FanSpeedCommand(CeilingFan fan, int newSpeed) {
        this.fan = fan;
        this.newSpeed = newSpeed;
    }

    // execute() method jo new speed ko set karta hai
    @Override
    public void execute() {
        prevSpeed = fan.getSpeed(); // Current speed ko store karte hain
        fan.setSpeed(newSpeed); // New speed ko set karte hain
    }

    // undo() method jo previous speed pe wapas le jata hai
    @Override
    public void undo() {
        fan.setSpeed(prevSpeed); // Fan ko previous speed pe reset karte hain
    }
}

// RemoteControl class jo commands ko store aur execute karti hai
class RemoteControl {
    private Command[] onCommands;
    private Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[4]; // Array to store commands for different speeds
    }

    // Slot mein speed command set karta hai
    public void setCommand(int slot, Command command) {
        onCommands[slot] = command;
    }

    // Button press hone pe specific speed command ko execute karta hai
    public void pressButton(int slot) {
        if (onCommands[slot] != null) {
            onCommands[slot].execute();
            undoCommand = onCommands[slot]; // Undo ke liye command ko store karte hain
        }
    }

    // Undo button press hone pe last command ko undo karta hai
    public void pressUndoButton() {
        if (undoCommand != null) {
            undoCommand.undo();
        }
    }
}

// Client code jo setup aur test karta hai fan aur remote ko
public class CeilingFanTest {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl(); // Remote control ka object
        CeilingFan fan = new CeilingFan(); // CeilingFan ka object

        // Commands banate hain har speed ke liye
        Command fanLow = new FanSpeedCommand(fan, CeilingFan.LOW);
        Command fanMedium = new FanSpeedCommand(fan, CeilingFan.MEDIUM);
        Command fanHigh = new FanSpeedCommand(fan, CeilingFan.HIGH);

        // Remote ke slots mein commands ko set karte hain
        remote.setCommand(0, fanLow);
        remote.setCommand(1, fanMedium);
        remote.setCommand(2, fanHigh);

        // Test fan speeds aur undo
        System.out.println("Setting fan to LOW:");
        remote.pressButton(0); // Fan LOW hona chahiye

        System.out.println("Setting fan to MEDIUM:");
        remote.pressButton(1); // Fan MEDIUM hona chahiye

        System.out.println("Undo last action:");
        remote.pressUndoButton(); // Wapas LOW pe hona chahiye

        System.out.println("Setting fan to HIGH:");
        remote.pressButton(2); // Fan HIGH hona chahiye

        System.out.println("Undo last action:");
        remote.pressUndoButton(); // Wapas MEDIUM pe hona chahiye
    }
}
