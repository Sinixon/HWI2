import TI.BoeBot;
import TI.PinMode;
import TI.Servo;

public class RobotMain {
    //importeer linker en rechter servo op de juiste poorten
    static Servo Links = new Servo(13);
    static Servo Rechts = new Servo(12);

    public static void main(String[] args) {
        gaNaarSnelHeid(200); //parameter = 200 zodat de snelheid rechts 1700 wordt en links 1300 uiteindelijk.
    }

    public static void gaNaarSnelHeid(int snelheid) {
        // start snelheid op 1500 zetten
        int speedAtStart = 1500;
        if (snelheid > 0) { //als de snelheid groter is dan 0 ga dan het volgende doen
            for (int x = 0; x < snelheid; x++) { //for loop waarbij x telkens 1 omhoog gaat
                Links.update(speedAtStart - x); //snelheid wordt uiteindelijk 1300
                Rechts.update(speedAtStart + x); //snelheid wordt uiteindelijk 1700
                BoeBot.wait(100); // wacht 0,1 seconden voordat de for loop weer aangesproken wordt
            }

        } else { //als de snelheid 0 heeft bereikt zet dan beide motoren weer op stilstand = beide 1500.
            Links.update(speedAtStart);
            Rechts.update(speedAtStart);
        }
    }
}
