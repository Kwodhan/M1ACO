package test_receiver;

import java.util.Random;

public class MyRandom {

	public static String randomString(int length) {
		char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890 &é".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}

		return sb.toString();
	}

	public static Character randomChar() {
		char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890 &é".toCharArray();

		Random random = new Random();

		return chars[random.nextInt(chars.length)];
	}

	public static int randomInt(int debut, int fin) {
		Random rand = new Random();
		return rand.nextInt(fin - debut + 1) + debut;
	}
}
