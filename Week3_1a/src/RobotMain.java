import TI.BoeBot;
import TI.PinMode;

public class RobotMain {

    //deze code komt rechtstreeks uit de presentatie.

    public static void main(String[] args) {

        System.out.println("luisteren");

        while(true) {
            int Pulselengte = BoeBot.pulseIn(1,false, 6000);

            if(Pulselengte>2000){
                int lengtes[] = new int [12];
                for(int i=0; i<12; i++){
                    lengtes[i] = BoeBot.pulseIn(1,false,20000);
                }
                for(int i=0;i<12; i++){
                    System.out.print(lengtes[i]+",");
                    System.out.println(" ");}
            }
            BoeBot.wait(10);
        }
    }
}