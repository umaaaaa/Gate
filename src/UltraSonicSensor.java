import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;


public class UltraSonicSensor extends Thread{
	int centimeter;
	private static final RegulatedMotor Motor1 = Motor.B;
	private static final EV3UltrasonicSensor ursensor = new EV3UltrasonicSensor(SensorPort.S4);
	public void run(){
		SampleProvider distanceMode = ursensor.getDistanceMode();
		float value[] = new float[distanceMode.sampleSize()];
		while (true) {
			distanceMode.fetchSample(value, 0);
			centimeter = (int) (value[0] * 100);
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
			if (centimeter > 3 && centimeter <= 10) {
			executeIndividualOperation (2, centimeter);
			} else if (centimeter > 10 && centimeter <= 20) { 
				executeIndividualOperation (3, centimeter);
			} else if (Integer.MAX_VALUE != centimeter && centimeter <= 250) {
				executeIndividualOperation (1, centimeter);
			}
			Delay.msDelay(100);
		}
	}
	
	private void executeIndividualOperation(int pattern, int centimeter) {	
		Button.LEDPattern(pattern);
		LCD.clearDisplay();
	 	LCD.drawString("Distance : " + centimeter, 0, 0);
	 }
	  	
	public int returnCentimeter(){
		return centimeter;
	}
}