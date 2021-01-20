import TI.BoeBot;
import TI.PinMode;
import TI.Servo;

public class RobotMain {

    //importeer linker en rechter servo op de juiste poorten
    static Servo Links = new Servo(13);
    static Servo Rechts = new Servo(12);

    public static void main(String[] args) {

        //maak een variabele speedToStop op 1500, speed 1500 en een boolean stop op false.
        int speedToStop = 1500;
        int speed = 1500;

        while (true) {
            if (speed > 1400) { //als de speed (1500) groter is dan 1400
                speed--; //laat de snelheid aflopen
            }
            if (speedToStop < 1599) {  //als de speedToStop (1500) kleiner is dan 1600
                speedToStop++; //laat de snelheid oplopen
            }
            gaNaarSnelheid(speedToStop, speed); //spreek de functie gaNaarSnelheid aan
            BoeBot.wait(50);
        }
    }

    public static void gaNaarSnelheid(int speedToStop, int speed) {
        Rechts.update(speedToStop); //update de rechter servo met de speedToStop
        Links.update(speed); //update de linker servo met de speed
        if (speed == 1399 && speedToStop == 1599) { //wanneer de een 1399 heeft bereikt en ander 1599
            draaien(-90, speedToStop, speed); //spreek functie draaien aan
        }
    }

    public static void draaien(int turnSpeed, int speedToStop, int speed){
        if(turnSpeed < 0 ){ //als de turnspeed kleiner dan 0 is (negatief)
            int Draaihoek = speedToStop + turnSpeed; //snelheid wordt +turnSpeed
            Links.update(Draaihoek); //update de linker servo met deze waarde
        }
        else if(turnSpeed > 0){ //als de turnspeed groter is dan 0 (positief)
            int Draaihoek = speed + turnSpeed; //snelheid wordt +turnSpeed
            Rechts.update(Draaihoek); //update de rechter servo
        }
    }
}