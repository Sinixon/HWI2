import TI.BoeBot;
import TI.PinMode;

public class RobotMain {

    public static void main(String[] args) {

        boolean LEDState = true;

        int LED = 0;

        //van wat ik kan zien blijft de LED branden bij 5 milliseconden.

        while (true) {
            BoeBot.digitalWrite(LED, LEDState); //gebruik digitalwrite om de status mee te geven
            BoeBot.wait(5); //wacht 0,05 seconde
            LEDState = !LEDState; //zet de LED status naar false om de LED uit te zetten
            BoeBot.digitalWrite(LED, LEDState); //gebruik digitalwrite om de status mee te geven
            BoeBot.wait(5); //wacht 0,05 seconde en loop opnieuw
        }
    }
}