package Slip8;

// State interface jo sabhi states ke liye common behavior define karta hai
interface State {
    void insertQuarter(); // Quarter insert karne ke liye method

    void ejectQuarter(); // Quarter nikaalne ke liye method

    void turnCrank(); // Crank ko ghumane ke liye method

    void dispense(); // Gumball dispense karne ke liye method
}

// GumballMachine class jo current state ko track karta hai
class GumballMachine {
    State noQuarterState; // State jab quarter nahi hai
    State hasQuarterState; // State jab quarter insert hai
    State soldState; // State jab gumball bech diya gaya hai
    State soldOutState; // State jab gumballs khatam ho gaye hain

    State currentState; // Current state

    int count; // Gumballs ki total count

    public GumballMachine(int numberOfGumballs) {
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);

        this.count = numberOfGumballs; // Gumballs ki initial count set karte hain
        if (numberOfGumballs > 0) {
            currentState = noQuarterState; // Agar gumballs hain, noQuarterState se shuru karte hain
        } else {
            currentState = soldOutState; // Nahi to soldOutState mein chalte hain
        }
    }

    public void setCurrentState(State state) {
        this.currentState = state; // Current state ko set karne ka method
    }

    public void insertQuarter() {
        currentState.insertQuarter(); // Current state ke hisab se quarter insert karte hain
    }

    public void ejectQuarter() {
        currentState.ejectQuarter(); // Current state ke hisab se quarter nikaalte hain
    }

    public void turnCrank() {
        currentState.turnCrank(); // Current state ke hisab se crank ghumate hain
        currentState.dispense(); // Gumball dispense karte hain
    }

    public void releaseGumball() {
        System.out.println("Gumball dispensed!"); // Gumball dispense hone par message
        if (count != 0) {
            count--; // Gumball count ko reduce karte hain
        }
    }

    public int getCount() {
        return count; // Current gumball count return karte hain
    }

    public State getCurrentState() {
        return currentState; // Current state ko return karte hain
    }
}

// NoQuarterState class jab quarter nahi hai
class NoQuarterState implements State {
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine; // GumballMachine object ko store karte hain
    }

    @Override
    public void insertQuarter() {
        System.out.println("Quarter inserted."); // Quarter insert hone par message
        gumballMachine.setCurrentState(gumballMachine.hasQuarterState); // State ko change karte hain
    }

    @Override
    public void ejectQuarter() {
        System.out.println("No quarter to eject."); // Agar quarter nahi hai to message
    }

    @Override
    public void turnCrank() {
        System.out.println("You need to insert a quarter first."); // Crank ghumane par message
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first."); // Gumball dispense karne se pehle payment karna hai
    }
}

// HasQuarterState class jab quarter insert ho chuka hai
class HasQuarterState implements State {
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You already inserted a quarter."); // Agar quarter insert hai to message
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned."); // Quarter nikaalne par message
        gumballMachine.setCurrentState(gumballMachine.noQuarterState); // State ko change karte hain
    }

    @Override
    public void turnCrank() {
        System.out.println("Crank turned."); // Crank ghumane par message
        gumballMachine.setCurrentState(gumballMachine.soldState); // State ko SoldState mein change karte hain
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed."); // Gumball dispense nahi hota
    }
}

// SoldState class jab gumball bech diya gaya hai
class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball."); // Message jab gumball diya ja raha ho
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank."); // Crank ghumane ke baad quarter nikaalne par
                                                                    // message
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!"); // Crank ghumane par message
    }

    @Override
    public void dispense() {
        gumballMachine.releaseGumball(); // Gumball dispense karne ka method call karte hain
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setCurrentState(gumballMachine.noQuarterState); // Gumball dispense hone par state ko change
                                                                           // karte hain
        } else {
            System.out.println("Oops, out of gumballs!"); // Agar gumballs khatam ho gaye to message
            gumballMachine.setCurrentState(gumballMachine.soldOutState); // State ko soldOutState mein change karte hain
        }
    }
}

// SoldOutState class jab gumballs khatam ho gaye hain
class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out."); // Sold out hone par message
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter."); // Agar quarter nahi hai to message
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs."); // Crank ghumane par gumballs nahi hone par
                                                                      // message
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed."); // Gumball dispense nahi hota
    }
}

// Client code jo gumball machine ko test karta hai
public class GumballMachineTest {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5); // Gumball machine create karte hain with 5 gumballs

        gumballMachine.insertQuarter(); // Quarter insert karte hain
        gumballMachine.turnCrank(); // Crank ghumate hain

        System.out.println();

        gumballMachine.insertQuarter(); // Quarter insert karte hain
        gumballMachine.turnCrank(); // Crank ghumate hain

        System.out.println();

        gumballMachine.insertQuarter(); // Quarter insert karte hain
        gumballMachine.ejectQuarter(); // Quarter nikaalte hain
        gumballMachine.turnCrank(); // Crank ghumate hain

        System.out.println();

        for (int i = 0; i < 5; i++) {
            gumballMachine.insertQuarter(); // Har baar quarter insert karte hain
            gumballMachine.turnCrank(); // Crank ghumate hain
            System.out.println();
        }

        gumballMachine.insertQuarter(); // Last quarter insert karte hain
        gumballMachine.turnCrank(); // Crank ghumate hain (Machine sold out ho jayegi)
    }
}
