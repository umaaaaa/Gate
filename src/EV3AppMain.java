public class EV3AppMain{
	public static void main(String... argv) {
		UltraSonicSensor ultra = new UltraSonicSensor();
		KeyTouch key = new KeyTouch();
		ultra.start();
		key.start();
	}
}