package pr1.a02;

import java.io.PrintWriter;
import java.util.Random;

public class SomeFunctions {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		Random random = new Random();
		
		// Anzahl der Durchläufe
		int i = 2;
		
		// Flächenparameter
		double a;
		double b;
		double r;

		while (i > 0) {
			a = random.nextDouble(.1, 10);
			b = random.nextDouble(.1, 10);
			r = random.nextDouble(.1, 10);

			out.printf("U (Kreis) mit r = %.2f = %.2f.%n", r, kreisUmfang(r));
			out.printf("U (Rechteck) mit a = %.2f und b = %.2f = %.2f.%n", a, b, rechteckUmfang(a, b));
			out.printf("A (Rechteck) mit a = %.2f und b = %.2f = %.2f.%n", a, b, rechteckFlaeche(a, b));
			out.println();
			i--;
		}
		
		out.flush();
		
		/*
		 * Beispielausgabe:
		 * 
		 * U (Kreis) mit r = 4,08 = 25,66.
		 * U (Rechteck) mit a = 3,05 und b = 9,97 = 26,03.
		 * A (Rechteck) mit a = 3,05 und b = 9,97 = 30,37.
		 * 
		 * U (Kreis) mit r = 1,59 = 10,02.
		 * U (Rechteck) mit a = 2,79 und b = 10,00 = 25,57.
		 * A (Rechteck) mit a = 2,79 und b = 10,00 = 27,85.
		 * 
		 */

	}

	public static double kreisUmfang(double radius) {
		return 2 * Math.PI * radius;
	}

	public static double rechteckUmfang(double a, double b) {
		return 2 * (a + b);
	}

	public static double rechteckFlaeche(double a, double b) {
		return a * b;
	}

}
