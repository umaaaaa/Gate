import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;


public class RotateMotor extends Thread{
	private static final RegulatedMotor Motor1 = Motor.B;
	UltraSonicSensor ursensor = new UltraSonicSensor();
	int centimeter;
	public void run(){
		centimeter = ursensor.returnCentimeter();
		if(centimeter < 32){
			Motor1.setSpeed(500);
			Motor1.backward();
			Delay.msDelay(1500);
			Motor1.stop();
			Delay.msDelay(1000);
			Motor1.setSpeed(500);
			Motor1.forward();
			Delay.msDelay(1500);
			Motor1.stop();	
		}
	}
}
