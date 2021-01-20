import TI.BoeBot;
import TI.PWM;
import TI.PinMode;

public class RobotMain {

    public static void main(String[] args) {

        //maak twee boolean variabele
        Boolean stateOne = true;
        Boolean stateTwo = false;

        //maak twee LED variabele
        int LED1 = 4;
        int LED2 = 5;

        //maak een start waarde 4 en start waarde 250 als dutycycle
        int startLED4 = 4;
        int startLED250 = 250;

        //maak twee PWM variabele
        PWM pwm1 = new PWM(LED1, startLED4);
        PWM pwm2 = new PWM(LED2, startLED250);

        //start de twee PWM variabele
        pwm1.start();
        pwm2.start();

        while (true) {
            stateOne = changeState(pwm1, startLED4, stateOne); //lees de waarde af en update de boolean
            stateTwo = changeState(pwm2, startLED250, stateTwo); //lees de waarde af en update de boolean
            if (stateOne) { //wanneer stateOne true is doe dan het volgende
                startLED4++; //dutycycle 4 +1;
                startLED250--; //dutycycle 250 -1;
            } else { //anders wanneer stateOne false is:
                startLED4--; //dutycycle 4 -1;
                startLED250++; //dutycycle 250 +1;
            }
            BoeBot.wait(8); //wacht 0,08 seconde (2000/255)
        }
    }


    private static boolean changeState(PWM pwm, int ledBrightess, boolean brightness) {
        pwm.update(ledBrightess); //update de meegegeven PWM pin met de ledBrightness
        if (brightness && ledBrightess == 250) { //als de ledBrightness 250 bereikt (hoogste) en hij staat aan:
            brightness = false; //zet de pwm lamp uit
        } else if (!brightness && ledBrightess == 4) { //als de ledBrightness 4 bereikt (laagste) en hij staat uit:
            brightness = true; //zet de pwm lamp aan
        }
        return brightness; //geef de status terug zodat we weten welke pwm aan/uit staat
    }
}