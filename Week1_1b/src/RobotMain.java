import TI.BoeBot;
import TI.PinMode;

public class RobotMain {

    public static void main(String[] args) {

        boolean LEDState = true;

        int LED = 0;

        while (true) {
            BoeBot.digitalWrite(LED, LEDState); //gebruik digitalwrite om de status mee te geven
            BoeBot.wait(1000); //wacht 1 seconde
            LEDState = !LEDState; //zet de LED status naar false om de LED uit te zetten
            BoeBot.digitalWrite(LED, LEDState); //gebruik digitalwrite om de status mee te geven
            BoeBot.wait(2000); //wacht 2 seconde en loop opnieuw
        }
    }
}
