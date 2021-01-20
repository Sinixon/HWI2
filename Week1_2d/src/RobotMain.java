import TI.BoeBot;
import TI.PinMode;
import TI.Timer;

import javax.swing.*;

public class RobotMain {

    public static void main(String[] args) {

        //twee timers zijn nodig. Eentje met 700 delay en eentje met 1300 als parameter
        TI.Timer Timer1 = new TI.Timer(700);
        TI.Timer Timer2 = new Timer(1300);

        Timer1.mark(); //start timer1
        Timer2.mark(); //start timer2

        boolean LEDStateOne = true;
        boolean LEDStateTwo = true;

        int LED1 = 0;
        int LED2 = 1;

        while (true) {
            if (Timer1.timeout()){LEDStateOne = !LEDStateOne; //wanneer timer 1 afloopt dan moet de LEDStateTwo op false gezet worden
                BoeBot.digitalWrite(LED1, LEDStateOne);}
            if (Timer2.timeout()){LEDStateTwo = !LEDStateTwo; //wanneer timer 2 afloopt dan moet de LEDStateOne op false gezet worden
                BoeBot.digitalWrite(LED2, LEDStateTwo);}
            BoeBot.wait(1); //wacht 0,01 seconden en loop opnieuw
        }
    }
}