import TI.BoeBot;
import TI.PWM;
import TI.PinMode;

public class RobotMain {

    public static int cycleCounter = 0;

    public static void main(String[] args) {
        while (true) {

            cycleCounter++; //gooi de cycleCounter omhoog

            if (cycleCounter <= 255) { //wanneer de cycleCounter kleiner of gelijk aan 255 (volledige dutycycle) is, dan:
                //import PWM
                PWM pwm = new PWM(4, cycleCounter); //sluit PWM aan op poort 0 met dutycycle cycleCounter om de LED te laten branden
                pwm.start(); //start PWM
            } else {
                cycleCounter = 0;
            }
                BoeBot.wait(2000 / 255); //de tijd die over is dat de boebot moet wachten berekenen met 2sec / 255 van de cycleCounter
            }
        }
    }

