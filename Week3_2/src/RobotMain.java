import TI.BoeBot;
import TI.Servo;

public class RobotMain {

    static Servo servoLinks = new Servo(12);
    static Servo servoRechts = new Servo(13);

    public static int speedAtStart = 1500;

    public static void main(String[] args) {

        while (true) {
            String binaryCode = "";
            int button;

            int Pulselengte = BoeBot.pulseIn(1, false, 6000);

            if (Pulselengte > 2000) {
                int lengtes[] = new int[12];
                for (int i = 0; i < 12; i++) {
                    lengtes[i] = BoeBot.pulseIn(1, false, 20000);
                }
                for (int i = 0; i < 12; i++) {
                    System.out.print(lengtes[i] + ",");
                    System.out.println(" ");
                    binaryCode += checkWaarde(lengtes[i]);
                }
                button = checkRemote(binaryCode);
                System.out.println("deze knop was ingedrukt " + button);
            }
            BoeBot.wait(125); //wacht
        }
    }

    public static int gaNaarSnelHeid(int snelheid) {
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
        return snelheid;
    }


    public static int draaiGraden(int graden, int draaiSnelheid) {
        if (draaiSnelheid > 0) { //wanneer draaisnelheid groter dan 0 is doe dan:
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
        return graden;
    }


    public static int checkWaarde(int x){
            //als x > 1000 return dan 1 (soort van true)
            if (x > 1000) {
                return 1;
                //anders 0 returnen (soort van false)
            } else {
                return 0;
            }
        }

    public static int behindRechts () {
        servoLinks.update(1600);
        servoRechts.update(1485);
        BoeBot.wait(300);
        return 0;
    }

        public static int goRechts () {
            servoLinks.update(1450);
            servoRechts.update(1600);
            BoeBot.wait(300);
            return 0;
        }

        public static int behindLeft() {
            servoLinks.update(1601);
            servoRechts.update(1420);
            BoeBot.wait(300);
            return 0;
        }

        public static int goLeft() {
            servoLinks.update(1401);
            servoRechts.update(1550);
            BoeBot.wait(300);
            return 0;
        }

        public static int checkRemote(String remote){
            //swtich voor wat de remote geeft
            switch (remote) {
                //naar links voren
                case "000000010000":
                    return goLeft();
                //recht vooruit
                case "100000010000":
                    return gaNaarSnelHeid(200);
                //naar rechts voren
                case "010000010000":
                    return goRechts();
                //draai 90 graden
                case "110000010000":
                    return draaiGraden(90, 30);
                //stoppuh
                case "001000010000":
                    return noodRem();
                //90 graden draaien
                case "101000010000":
                    return draaiGraden(-90, 30);
                //links achter
                case "011000010000":
                    return behindLeft();
                //achteruit
                case "111000010000":
                    return gaNaarSnelHeid(-200);
                //naar rechts achter
                case "000100010000":
                    return behindRechts();
                case "100100010000":
                    return 0;
                default:
                    return -1;
            }
        }


        public static int noodRem() {
            //zet beide motoren op stilstand = 1500
            servoLinks.update(1500);
            servoRechts.update(1500);
            BoeBot.wait(2000); //wacht 2 seconden
            return 0;
        }
    }

