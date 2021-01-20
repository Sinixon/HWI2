import TI.BoeBot;
public class RobotMain {

    public static void main(String[] args) {

        int freq = 1000;
        while (true) {
            //1 seconde op 1000hz
            if(freq < 2000){
                freq++;
            }
            //zodra de freq op 2000 staat zet hem op 1000
            if(freq == 2000){
                freq= 1000;
            }
            BoeBot.freqOut(0,freq,1);
            System.out.println(freq);
        }
    }
}