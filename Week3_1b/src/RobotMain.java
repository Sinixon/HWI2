import TI.BoeBot;
import TI.PinMode;

public class RobotMain {


    public static void main(String[] args) {

        while (true) {
            //variabele stringCode
            String stringCode = "";
            //variable remoteButton
            int remoteButton;

            //lengte van de pulse ophalen
            int lengthPulse = BoeBot.pulseIn(14, false, 6000);
            //als de lengte hoger is dan 2000
            if (lengthPulse > 2000) {
                //array maken van de waarde
                int length[] = new int[12];
                //zet de waardes in de array
                for (int i = 0; i < 12; i++) {
                    length[i] = BoeBot.pulseIn(14, false, 20000);
                }
                //zet de lengtes om in 1 of 0
                for (int i = 0; i < 12; i++) {
                    //voeg een binary string toe
                    System.out.print(getCode(length[i]));
                }
                //haal knop vd afstandbedieing op
                remoteButton = getRemoteButton(stringCode);
                System.out.println("Dit is de ingedrukte knop " + remoteButton);
            }
            BoeBot.wait(10); //wacht 0,01 seconde
        }
    }

    public static int getCode(int pulse) {
        //wanner de pulse groter dan1000 is
        if (pulse > 1000) {
            return 1; //geef een 1 terug
        } else if (pulse < 1000) {
            //wanneer de pulse kleiner dan1000 is
            return 0; //geef een 0 terug
        } else {
            return -1; //geef anders een -1 terug
        }
    }

    public static int getRemoteButton(String binair) {
        //check welk binair getal welke knop op de afstandbedieing is.
        switch (binair) {
            case "000000010000": return 1;
            case "100000010000": return 2;
            case "010000010000": return 3;
            case "110000010000": return 4;
            case "001000010000": return 5;
            case "101000010000": return 6;
            case "011000010000": return 7;
            case "111000010000": return 8;
            case "000100010000": return 9;
            case "100100010000": return 0;
            default: return -1;
        }
    }
}
