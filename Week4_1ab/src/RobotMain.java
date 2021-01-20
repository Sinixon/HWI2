import TI.BoeBot;
import TI.PinMode;

public class RobotMain {

    public static void main(String[] args) {


        int LS1 = 0;
        int LS2 = 1;
        int LS3 = 2;


        while (true) {
            int sensor1 = BoeBot.analogRead(LS1);
            int sensor2 = BoeBot.analogRead(LS2);
            int sensor3 = BoeBot.analogRead(LS3);
            System.out.println("Dit is sensor1 " + sensor1);
            System.out.println("Dit is sensor2 " + sensor2);
            System.out.println("Dit is sensor3 " + sensor3);
        }
    }
}
