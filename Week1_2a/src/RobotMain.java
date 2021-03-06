import TI.BoeBot;
import TI.PinMode;

public class RobotMain {

    public static void main(String[] args) {

        boolean LEDState = true;

        int LED1 = 0;
        int LED2 = 1;

        while (true) {
            BoeBot.digitalWrite(LED1, LEDState); //gebruik digitalwrite om de status mee te geven aan LED1
            BoeBot.digitalWrite(LED2, LEDState); //gebruik digitalwrite om de status mee te geven aan LED2
            LEDState = !LEDState; //zet de LED status naar false om de LED uit te zetten
            BoeBot.digitalWrite(LED1, LEDState); //gebruik digitalwrite om de status mee te geven aan LED1
            BoeBot.digitalWrite(LED2, LEDState); //gebruik digitalwrite om de status mee te geven aan LED2
            BoeBot.wait(1000); //wacht 1 seconde en loop opnieuw
        }
    }
}
