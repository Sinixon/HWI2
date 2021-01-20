import TI.BoeBot;
import TI.PWM;
import TI.PinMode;

public class RobotMain {


    public static void main(String[] args) {
        //import PWM
        PWM pwm = new PWM(4, 128); //sluit PWM aan op poort 0 met dutycycle 128
        pwm.start(); //start PWM
        while (true) {
            BoeBot.wait(100); //wacht 100 seconde met een nieuwe loop beginnen
        }
    }
}