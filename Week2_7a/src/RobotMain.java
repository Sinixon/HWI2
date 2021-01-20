import TI.BoeBot;
import TI.PinMode;

public class RobotMain {

    public static void main(String[] args) {
        //laat de speaker piepen met een frequentie van 1000. Speaker staat op poort 0.
        while (true) {
            BoeBot.freqOut(0, 1000, 1);
        }
    }
}