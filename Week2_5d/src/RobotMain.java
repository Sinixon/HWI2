import TI.BoeBot;
import TI.PinMode;
import TI.Servo;

public class RobotMain {

    //servomotoren aanmaken
    static Servo servoLinks = new Servo(13);
    static Servo servoRechts = new Servo(12);

    public static int speedAtStart = 1500;

    public static void main(String[] args) {
        while(true) {
            draaiGraden(90, 25);
            draaiGraden(270, 75);
            draaiGraden(60, 50);
        }
    }
    public static void draaiGraden(int graden, int draaiSnelheid) {
        if (draaiSnelheid > 0){ //wanneer draaisnelheid groter dan 0 is doe dan:
            int x = 430 / draaiSnelheid; //draai berekenen
            RobotMain.servoLinks.update(speedAtStart + draaiSnelheid); //update linker servo
            RobotMain.servoRechts.update(speedAtStart + draaiSnelheid); //update rechter servo
            BoeBot.wait(x * graden); //bereken de tijd die de bot moet wachten
            noodRem(); //gebruik functie om te stoppen
        } else if (draaiSnelheid < 0) { //wanneer draaisnelheid kleiner dan 0 is doe dan:
            draaiSnelheid = Math.abs(draaiSnelheid); //snelheid positief maken via math.abs
            int x = 430 / draaiSnelheid; //wederom draai berekenen
            RobotMain.servoLinks.update(speedAtStart - draaiSnelheid); //update linker servo
            RobotMain.servoRechts.update(speedAtStart - draaiSnelheid); //update rechter servo
            BoeBot.wait(x * graden); //bereken de tijd die de bot moet wachten
            noodRem(); //gebruik functie om te stoppen
        }
    }

    public static void noodRem() {
        //zet beide motoren op stilstand = 1500
        servoLinks.update(1500);
        servoRechts.update(1500);
        BoeBot.wait(2000); //wacht 2 seconden
    }
}
