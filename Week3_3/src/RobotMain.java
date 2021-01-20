import TI.BoeBot;
import TI.PinMode;
import TI.Servo;

public class RobotMain {

    //servo motoren op juiste poort instellen
    public static Servo servoLeft = new Servo(13);
    public static Servo servoRight = new Servo(12);

    public static void main(String[] args) {

        accel(225); //laat de boebot optrekken

        while (true) {
            BoeBot.digitalWrite(3, true); //echo
            BoeBot.wait(1);
            BoeBot.digitalWrite(3, false); //echo
            int distanceToObject = BoeBot.pulseIn(4, true, 10000) / 58; //tijd berekenen en afstand tot object bepalen
            if (distanceToObject < 20) { //wanneer de afstand kleiner dan 20 is ga dan wat doen
                accel(-100); //rij achteruit
                turnDegrees(180, 50); //draait 180 graden
                accel(200); //rij weer naar voren
            }
            BoeBot.wait(50);
        }
    }

    public static void accel(int speed) {
        int speedAtStart = 1500; //zet speed aan het begin op 1500
        if (speed > 0) { //wanneer speed hoger dan 0 is doe dan
            for (int x = 0; x < speed; x++) {
                servoLeft.update(speedAtStart - x); //update snelheid servo
                servoRight.update(speedAtStart + x); //update snelheid servo
                BoeBot.wait(50); //wacht 0,05 seconden
            }
        } else if (speed < 0) { //als speed kleiner dan 0 is doe dan
            for (int x = 0; x > speed; x--) {
                servoLeft.update(speedAtStart - x); //update snelheid servo
                servoRight.update(speedAtStart + x); //update snelheid servo
                BoeBot.wait(50); //wacht 0,05 seconden
            }
        }
    }

    public static void turnDegrees(int degrees, int turningSpeed) {
        if (turningSpeed > 0) { //is de turningspeed groter dan 0?
            int timeForDegree = 420 / turningSpeed;
            servoLeft.update(1500 + turningSpeed); //update snelheid servo
            servoRight.update(1500 + turningSpeed); //update snelheid servo
            BoeBot.wait(timeForDegree * degrees); //wacht de berekende tijd
        } else if (turningSpeed < 0) { //is de turningspeed kleiner dan 0?
            turningSpeed = Math.abs(turningSpeed); //zet om naaar positieve snelheid
            int timeForDegree = 400 / turningSpeed;
            servoLeft.update(1500 - turningSpeed); //update snelheid servo
            servoRight.update(1500 - turningSpeed); //update snelheid servo
            BoeBot.wait(timeForDegree * degrees); //wacht de berekende tijd
        }
        noodRem();
    }

    public static void noodRem() {
        servoLeft.update(1500);
        servoRight.update(1500);
    }
}
