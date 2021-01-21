import TI.BoeBot;
import TI.PinMode;
import TI.Servo;

public class RobotMain {

    //importeer linker en rechter servo op de juiste poorten
    static Servo servoLinks = new Servo(13);
    static Servo servoRechts = new Servo(12);

    public static int speedAtStart = 1500;

    public static void main(String[] args) {
        while(true) {

            //deze functie gebruiken voor draai
            draaiGraden(360, 100);

            //deze twee functies gebruiken voor vierkant
            //gaNaarSnelHeid(200);
            //draaiGraden(90, 50);

            //deze twee functies gebruiken voor driehoek
            //gaNaarSnelHeid(200);
            //draaiGraden(120, 50);
        }
    }

    public static void gaNaarSnelHeid(int snelheid) {
        if (snelheid > 0) { //als de snelheid groter is dan 0 ga dan het volgende doen
            for (int x = 0; x < snelheid; x++) { //for loop waarbij x telkens 1 omhoog gaat
                servoLinks.update(snelheid + x); //snelheid wordt uiteindelijk 1300
                servoRechts.update(snelheid - x); //snelheid wordt uiteindelijk 1700
                BoeBot.wait(100); // wacht 0,1 seconden voordat de for loop weer aangesproken wordt
            }
            // rem aanroepen
            noodRem();

            //als snelheid kleiner is dan 0 moet de bot achteruit rijden
        } else if (snelheid < 0) { //als de snelheid kleiner is dan 0 ga dan het volgende doen
            for (int x = 0; x > snelheid; x--) {//for loop waarbij x telkens 1 omlaag gaat
                servoLinks.update(snelheid - x); //zelfde als functie hierboven maar dan tegenovergestelde
                servoRechts.update(snelheid + x);
                BoeBot.wait(100); // wacht 0,1 seconden voordat de for loop weer aangesproken wordt
            }
            // rem aanroepen
            noodRem();
        } else { //als de snelheid 0 heeft bereikt zet dan beide motoren weer op stilstand = beide 1500.
            servoLinks.update(speedAtStart);
            servoRechts.update(speedAtStart);
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