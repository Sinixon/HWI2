import TI.BoeBot;
import TI.PinMode;
import TI.Servo;

public class RobotMain {
    //importeer linker en rechter servo op de juiste poorten
    static Servo Links = new Servo(13);
    static Servo Rechts = new Servo(12);

    public static void main(String[] args) {
        noodRem(); //gebruik noodrem om de boebot te laten stoppen
    }

    public static void noodRem() {
        //zet beide motoren op stilstand = 1500
        Links.update(1500);
        Rechts.update(1500);
        BoeBot.wait(2000); //wacht 2 seconden
    }
}
