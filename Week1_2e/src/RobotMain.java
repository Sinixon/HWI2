import TI.BoeBot;
import TI.PinMode;
import TI.Timer;

public class RobotMain {

    public static void main(String[] args) {

        Timer Timer1 = new Timer(1300); //timer 1 met 1300 parameter
        Timer Timer2 = new Timer(700); //timer 2 met 700 parameter
        Timer Timer3 = new Timer(800); //timer 3 met 800 parameter
        Timer Timer4 = new Timer(1700); //timer 4 met 1700 parameter

        Timer1.mark(); //start alleen timer 1 en 3
        Timer3.mark(); //start alleen timer 1 en 3

        int LED1 = 0;
        int LED2 = 1;


        //Het idee van deze loop hieronder is als volgt:
        //Wanneer de eerste timer is afgelopen dan moet de status van de LED naar waarde 0 veranderd worden (licht uit)
        //Wanneer de status een waarde van 0 heeft dan moet de status naar false veranderd worden en timer 2 gestart worden
        //Op deze manier blijven de lampjes met de juiste tijd uit en aan gaan
        while (true) {
            if (Timer1.timeout()) {
                boolean state = BoeBot.digitalRead(LED1);
                if (state) {
                    BoeBot.digitalWrite(LED1, false);
                    Timer2.mark();
                }
            }
            if (Timer2.timeout()) {
                boolean state = BoeBot.digitalRead(LED1);
                if (!state) {
                    BoeBot.digitalWrite(LED1, true);
                    Timer1.mark();
                }
            }
            if (Timer3.timeout()) {
                boolean state = BoeBot.digitalRead(LED2);
                if (state) {
                    BoeBot.digitalWrite(LED2, false);
                    Timer4.mark();
                }
            }
            if (Timer4.timeout()) {
                boolean state = BoeBot.digitalRead(LED2);
                if (!state) {
                    BoeBot.digitalWrite(LED2,true);
                    Timer3.mark();
                }
            }
            BoeBot.wait(1); //wacht 0,01 seconden en loop opnieuw
        }
    }
}
