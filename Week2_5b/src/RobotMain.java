import TI.BoeBot;
import TI.PinMode;
import TI.Servo;

public class RobotMain {
    //importeer linker en rechter servo op de juiste poorten
    static Servo servoLinks = new Servo(13);
    static Servo servoRechts = new Servo(12);

    public static void main(String[] args) {
        noodRem(); //gebruik noodrem om de boebot te laten stoppen
    }

    public static void noodRem() {
        //zet beide motoren op stilstand = 1500
        servoLinks.update(1500);
        servoRechts.update(1500);
        BoeBot.wait(2000); //wacht 2 seconden
    }
}
