import TI.BoeBot;
import TI.PinMode;
import TI.Timer;

public class RobotMain {


    public static void main(String[] args) {

        boolean LEDState = false;

        int button = 8;
        int LED1 = 0;

        //zet timers op 1sec
        Timer timer1 = new Timer(1000);
        Timer timer2 = new Timer(1000);

        timer1.mark(); //start timer 1

        while (true) {
            if (BoeBot.digitalRead(button) == true) { //wanneer de button ingedrukt wordt doe dan het volgende
                if (timer1.timeout() && (LEDState == false)) { //als timer 1 een timeout heeft en de status is false doe dan
                    LEDState = !LEDState; //status op true zetten
                    BoeBot.digitalWrite(LED1, LEDState); //de LED aan
                    timer2.mark(); //start timer 2
                } else if (timer2.timeout() && (LEDState == true)) { //als timer 2 een timeout heeft en de status is true doe dan
                    LEDState = !LEDState; //status op false zetten
                    BoeBot.digitalWrite(LED1, LEDState); //de LED uitzetten
                }
            }
            BoeBot.wait(1); //wacht 0,01 seconde en loop opnieuw
        }
    }
}
