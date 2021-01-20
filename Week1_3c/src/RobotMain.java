import TI.BoeBot;
import TI.PinMode;

public class RobotMain {

    public static void main(String[] args) {

        int button = 8;
        int LED1 = 0;
        int LED2 = 1;

        BoeBot.digitalWrite(LED1, false); //zet de LED1 bij aanvang uit

        while (true){
            boolean state = BoeBot.digitalRead(button); // lees de status van de button af
            if (state) { //bij indrukken
                BoeBot.digitalWrite(LED1, true); //zet LED1 aan
                BoeBot.wait(1300); //wacht 1,3 seconde
                BoeBot.digitalWrite(LED1, false); //zet LED1 uit
                BoeBot.wait(700); //wacht 0,7 seconde
            }
            else { //anders bij niet indrukken
                BoeBot.digitalWrite(LED1, false); //zet LED1 uit
                BoeBot.digitalWrite(LED1, true); //zet LED2 aan
            }
        }
    }
}
