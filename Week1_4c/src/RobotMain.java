import TI.BoeBot;
import TI.PinMode;
import TI.Timer;

public class RobotMain {


    public static void main(String[] args) {

        boolean LEDStateOne = false;
        boolean LEDStateTwo = false;

        int button1 = 8;
        int button2 = 0;
        int LED1 = 11;
        int LED2 = 2;

        //zet timers op 1sec
        Timer timer1 = new Timer(1000);
        Timer timer2 = new Timer(1000);
        Timer timer3 = new Timer(700);
        Timer timer4 = new Timer(700);
        Timer timer5 = new Timer(1300);
        Timer timer6 = new Timer(700);

        timer1.mark(); //start timer 1
        timer3.mark(); //start timer 3
        timer5.mark(); //start timer 5

        while (true) {
            if (BoeBot.digitalRead(button1) == true) { //wanneer de button1 ingedrukt wordt doe dan het volgende
                if (timer1.timeout() && (LEDStateOne == false)) { //als timer 1 een timeout heeft en de status is false doe dan
                    LEDStateOne = !LEDStateOne; //status op true zetten
                    BoeBot.digitalWrite(LED1, LEDStateOne); //de LED aan
                    timer2.mark(); //start timer 2
                } else if (timer2.timeout() && (LEDStateOne == true)) { //als timer 2 een timeout heeft en de status is true doe dan
                    LEDStateOne = !LEDStateOne; //status op false zetten
                    BoeBot.digitalWrite(LED1, LEDStateOne); //de LED uitzetten
                }
            } else if (BoeBot.digitalRead(button2) == true) { //wanneer de button2 ingedrukt wordt doe dan het volgende
                if (timer3.timeout() && (LEDStateTwo == false)) { //als timer 3 een timeout heeft en de status is false doe dan
                    LEDStateTwo = !LEDStateTwo; //status op true zetten
                    BoeBot.digitalWrite(LED2, LEDStateTwo); //de LED aan
                    timer4.mark(); //start timer 4
                } else if (timer4.timeout() && (LEDStateTwo == true)) { //als timer 4 een timeout heeft en de status is true doe dan
                    LEDStateTwo = !LEDStateTwo; //status op false zetten
                    BoeBot.digitalWrite(LED2, LEDStateTwo); //de LED uitzetten
                }
            }
            else { //doe dit wanneer de button niet is ingedrukt!
                if (timer5.timeout() && (LEDStateOne == false)) { //als timer 5 een timeout heeft en de status is false doe dan
                    LEDStateOne = !LEDStateOne; //status op true zetten
                    BoeBot.digitalWrite(LED2, LEDStateOne); //led2 aanzetten
                    BoeBot.digitalWrite(LED1, !LEDStateOne); //led1 uitzetten
                    timer6.mark(); //start timer 6
                } else if (timer6.timeout() && (LEDStateOne == true)) { //als timer 6 een timeout heeft en de status is true doe dan
                    LEDStateOne = !LEDStateOne; //status op false zetten
                    BoeBot.digitalWrite(LED2, LEDStateOne); //led2 uitzetten
                    BoeBot.digitalWrite(LED1, !LEDStateOne); //led1 aanzetten
                }
            }
            BoeBot.wait(25); //wacht 0,025 seconde en loop opnieuw
        }
    }
}