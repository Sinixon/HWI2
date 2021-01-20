import TI.BoeBot;
import TI.PinMode;

public class RobotMain {

    public static void main(String[] args) {

        int button = 8;
        int LED = 0;

        BoeBot.digitalWrite(LED, false); //zet de LED bij aanvang uit

        while (true){
            boolean state = BoeBot.digitalRead(button); // lees de status van de button af
            if (state) { //bij indrukken
                BoeBot.digitalWrite(LED, true); //zet LED aan
                BoeBot.wait(1000); //wacht 1 seconde
                BoeBot.digitalWrite(LED, false); //zet LED uit
                BoeBot.wait(1000); //wacht 1 seconde
            }
            else { //anders bij niet indrukken
                BoeBot.digitalWrite(LED, false); //zet LED uit
            }
        }
    }
}
