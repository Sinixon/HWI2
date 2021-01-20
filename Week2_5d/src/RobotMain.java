import TI.BoeBot;
import TI.PinMode;
import TI.Servo;

public class RobotMain {
    // zet servo op 13 en 12
    static Servo sLinks = new Servo(13);
    static Servo sRechts = new Servo(12);

    public static void main(String[] args) {
        while(true) {
            draai(90, 25);
            draai(270, 75);
            draai(60, 50);
        }
    }
    public static void draai(int graden, int snelheid) {
        //start snelheid
        int istart = 1500;
        //als snelheid groter is dan 0
        if (snelheid > 0){
            //berenken draaitijd
            int TPG = 430 / snelheid;
            //bot laten draaien
            RobotMain.sLinks.update(istart + snelheid);
            RobotMain.sRechts.update(istart + snelheid);
            //wacht berekende tijd
            BoeBot.wait(TPG * graden);
            //boebot stoppen
            rem();
            //als snelheid kleiner dan 0 is
        } else if (snelheid < 0) {
            //snelheid waarde naar positive waarde
            snelheid = Math.abs(snelheid);
            //bereken draaitijd
            int TPG = 430 / snelheid;
            //bot draaien
            RobotMain.sLinks.update(istart - snelheid);
            RobotMain.sRechts.update(istart - snelheid);
            // wacht berekende tijd
            BoeBot.wait(TPG * graden);
            //boebot stoppen
            rem();

        }
    }

    public static void rem() {
        //zet motoren stil
        RobotMain.sLinks.update(1500);
        RobotMain.sRechts.update(1500);
        BoeBot.wait(500);
    }
}
