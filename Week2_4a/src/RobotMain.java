import TI.BoeBot;
import TI.PinMode;
import TI.Servo;

public class RobotMain {

    public static void main(String[] args) {

        //importeer linker en rechter servo op de juiste poorten
        Servo Rechts = new Servo(12);
        Servo Links = new Servo(13);

        //update beide servomotoren naar 1500 en kijk of ze stil staan
        Rechts.update(1500);
        Links.update(1500);

    }
}
