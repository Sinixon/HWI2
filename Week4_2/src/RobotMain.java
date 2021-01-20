import TI.*;

public class RobotMain {

    static int AnalogPin1 = 2;  //right sensor
    static int AnalogPin2 = 1;  //middle sensor
    static int AnalogPin3 = 0;  //left sensor

    static Servo servoLeft = new Servo(13);
    static Servo servoRight = new Servo(12);

    static int speedRightServo = 1500;
    static int speedLeftServo = 1500;
    static int speed = 30;
    static int sensitivity = 150;

    public static void main(String[] args) {

        while (true) {
            //constant de waardes van de IR sensoren uitlezen
            int sensor1 = BoeBot.analogRead(AnalogPin1);
            int sensor2 = BoeBot.analogRead(AnalogPin2);
            int sensor3 = BoeBot.analogRead(AnalogPin3);

            if (((sensor1 >= sensitivity) && (sensor2 <= sensitivity) && (sensor3 <= sensitivity)) || ((sensor1 >= sensitivity) && (sensor2 >= sensitivity) && (sensor3 <= sensitivity))) {
                //aanpassen naar rechts
                servoLeft.update(speedRightServo);
                servoRight.update(speedLeftServo);
                servoLeft.update(speedRightServo);
                servoRight.update(speedLeftServo + speed);
            } else if (((sensor1 <= sensitivity) && (sensor2 <= sensitivity) && (sensor3 >= sensitivity)) || ((sensor1 <= sensitivity) && (sensor2 >= sensitivity) && (sensor3 >= sensitivity))) {
                //aanpassen naar links
                servoLeft.update(speedRightServo);
                servoRight.update(speedLeftServo);
                servoLeft.update(speedRightServo - speed);
                servoRight.update(speedLeftServo);
            } else if ((sensor1 <= sensitivity) && (sensor2 >= sensitivity) && (sensor3 <= sensitivity)) {
                //rechtdoor rijden als alleen de middelste sensor aan staat
                servoLeft.update(speedRightServo - speed);
                servoRight.update(speedLeftServo + speed);
            } else if ((sensor1 >= sensitivity) && (sensor2 >= sensitivity) && (sensor1 >= sensitivity)) {
                //draaien bij een kruispunt
                servoLeft.update(speedRightServo - speed);
                servoRight.update(speedLeftServo + speed);
            }
        }
    }
}