import TI.BoeBot;
import TI.PinMode;
import TI.Servo;

public class RobotMain {

    public static void main(String[] args) {

        //importeer linker en rechter servo op de juiste poorten
        Servo Rechts = new Servo(12);
        Servo Links = new Servo(13);

        //test of max snelheid voor rechter motor 1700 is en linker 1300.
        Rechts.update(1700);
        Links.update(1300);

        }
    }

