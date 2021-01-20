import TI.BoeBot;
import TI.PinMode;
import TI.Servo;

public class RobotMain {

    //IK HEB DEZE OPDRACHT SAMEN MET JOEP GEMAAKT

    static Servo sLinks = new Servo(12);
    static Servo sRechts = new Servo(13);

    public static void main(String[] args) {

        while (true) {
            // benodigde variables
            String icode = "";
            int iKnop ;

            //kijk naar pulse lengte
            int Pulselengte = BoeBot.pulseIn(0, false, 6000);

            //als pulse lengte groter is dan 2000 voer uit
            if (Pulselengte > 2000){
                // lengnte lijs
                int lengtes[] = new int[12];

                //i is 0 als i kleiner is dan 12 i++
                for (int i = 0; i < 12; i++){lengtes[i] = BoeBot.pulseIn(0, false, 20000);}

                //i is 0 als i kleiner is dan 12 i++
                for (int i = 0; i < 12; i++) {
                    // waardes omzetten en in icode zetten
                    icode += waardes(lengtes[i]);
                }

                // knop code van aftands bediening
                iKnop = afstandbediening(icode);

                //print iknop
                System.out.println("Kmop = " + iKnop);
            }
            // Even wachten
            BoeBot.wait(10);
        }
    }

    //ga naar aangegevnen snelheid
    public static void snelheid(int hoogte) {

        // start snelheid
        int istart = 1500;

        // als hoogte hoger is dan 0 ga lankzaam naar snelheid
        if (hoogte > 0) {

            //i is 0 i kleiner dan hoogte i+1
            for (int i = 0; i < hoogte; i++) {
                RobotMain.sLinks.update(istart - i);
                RobotMain.sRechts.update(istart + i);
                //wacht 15 ms anders gaat het te snel
                BoeBot.wait(15);
            }

            // rem aanroepen
            rem();

            //als hooget kleiner is dan 0 rij achteruit
        } else if (hoogte < 0) {
            //i is 0 i groter dan hoogte i-1
            for (int i = 0; i > hoogte; i--) {
                RobotMain.sLinks.update(istart - i);
                RobotMain.sRechts.update(istart + i);
                //wacht 23ms om lanksaam achteruit te gaan
                BoeBot.wait(23);
            }


            // rem aanroepen
            rem();

        } else {
            // zet motor waarde op start dus stil
            RobotMain.sLinks.update(istart);
            RobotMain.sRechts.update(istart);
        }
        return istart;
    }


    public static void draai(int graden, int snelheid) {

        // start snelheid
        int istart = 1500;

        // als snelheid groter is dan 0
        if (snelheid > 0){

            // berenken draaitijd
            int TPG = 430 / snelheid;

            // bot laten draaine
            RobotMain.sLinks.update(istart + snelheid);
            RobotMain.sRechts.update(istart + snelheid);

            // wacht berekende tijd
            BoeBot.wait(TPG * graden);

            // Boebot stoppen
            rem();

            //als snelheid kleiner dan 0 is
        } else if (snelheid < 0) {

            // -snelhei waarde naar positive waarde
            snelheid = Math.abs(snelheid);

            // berenken draaitijd
            int TPG = 430 / snelheid;

            // bot draaien
            RobotMain.sLinks.update(istart - snelheid);
            RobotMain.sRechts.update(istart - snelheid);

            // wacht berekende tijd
            BoeBot.wait(TPG * graden);

            // Boebot stoppen
            rem();

        }
        return graden;
    }


    public static void rem() {
        //zet moteoren stil
        RobotMain.sLinks.update(1500);
        RobotMain.sRechts.update(1500);

        BoeBot.wait(270);
    }


    public static int waardes(int ilengte){
        // als ilengte groter is dan 1000 return 1
        if (ilengte > 1000) {
            return 1;
            //anders return 0
        }else{
            return 0;
        }



        public static int Rechts(){

            RobotMain.sLinks.update(1450);
            RobotMain.sRechts.update(1600);

            BoeBot.wait(250);
            return 0;
        }

        public static int AchterRechts(){

            RobotMain.sLinks.update(1600);
            RobotMain.sRechts.update(1490);

            BoeBot.wait(250);
            return 0;
        }


        public static int links(){
            RobotMain.sLinks.update(1401);
            RobotMain.sRechts.update(1550);

            BoeBot.wait(250);
            return 0;
        }


        public static int AchterLinks(){
            RobotMain.sLinks.update(1601);
            RobotMain.sRechts.update(1420);

            BoeBot.wait(250);
            return 0;
        }


        public static int afstandbediening(String icode) {
            //voer functie uit aandehand va icode

            switch (icode) {
                //Naar links voren
                case "000000010000": return links();
                //recht vooruit
                case "100000010000": return toSpeed(200);
                //naar rechts voren
                case "010000010000": return Rechts();
                //draai 90 graden
                case "110000010000": return turnDegrees(90, 30);
                //STOP
                case "001000010000": return emergencyBrake();
                //Draai 90 graden
                case "101000010000": return turnDegrees(-90, 30);
                //Naar links achter
                case "011000010000": return AchterLinks();
                //volle kracht achteruit
                case "111000010000": return toSpeed(-200);
                //naar rechts achter
                case "000100010000": return AchterRechts();
                case "100100010000": return 0;
                default: return -1;
            }
        }}
