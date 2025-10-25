package pr1.a01;

import java.io.PrintWriter;

import pr1.helper.Range;

public class FirstMethods {

	// bequeme Anpassungsmöglichkeit für das Rahmen-Symbol
	public static String frameChar = "*"; // oder: [...] char frameChar = '*';

	public static void main(String[] args) {
		PrintWriter writer = new PrintWriter(System.out);

		// Aufgaben
		printDecorated(writer, "23.10.: Aufgabe 1b");
		printValue(writer, 4);
		printFlaecheSiebeneck(writer, 1);

		// START:	Testdurchlauf mit Fehlerbehandlung
		double a = 1;

		for (int i : new Range(3, 9)) {
			try {
				writer.printf("Die Fläche des %d-Ecks mit a=%.2f ergibt %.2f Flächeneinheiten.%n", i, a,
						flaecheAllgemein(a, i));
			} catch (RuntimeException e) {
				writer.print("FEHLER:\t" + e.getMessage());
			}
		}
		// ENDE:	Testdurchlauf mit Fehlerbehandlung

		// gesammelte Ausgaben ausgeben
		writer.flush();
	}

	/**
	 * Text mit Rahmen dekorieren und dem PrintWriter hinzufügen.
	 * 
	 * @param out  Instanz des PrintWriters
	 * @param text Eingabetext
	 */
	public static void printDecorated(PrintWriter out, String text) {
		printBorder(out, text);
		printHeadline(out, text);
		printBorder(out, text, 2);
	}

	/**
	 * Berechne das Ergebnis mit a in der Methode value(); und gib das Ergebnis aus.
	 * 
	 * @param out Instanz des PrintWriters
	 * @param a   ganze Zahl
	 */
	public static void printValue(PrintWriter out, int a) {
		out.printf("Die Berechnung mit %d ergibt %d%n", a, value(a));
	}

	/**
	 * Formel mit Parameter a berechnen.
	 * 
	 * @param a ganze Zahl
	 * @return Ergebnis der Berechnung als ganze Zahl
	 */
	public static int value(int a) {
		// (a + 13) * 9 - a wäre eigentlich sinnvoller.
		return (a + 1 + 5 + 7) * 9 - a;
	}

	/**
	 * Berechne den Flächeninhalt eines regelmäßigen Siebenecks und runde das
	 * Ergebnis auf 2 Nachkommastellen.
	 * 
	 * @param out Instanz des PrintWriters
	 * @param a   Seitenlänge
	 */
	public static void printFlaecheSiebeneck(PrintWriter out, double a) {
		out.printf("Die Fläche des Siebenecks mit a=%.2f ergibt %.2f Flächeneinheiten.%n", a, flaecheSiebeneck(a));
	}

	/**
	 * Berechne den Flächeninhalt eines regelmäßigen Siebenecks. Quelle: <a href=
	 * "https://www.mathespass.at/formeln/regelm%C3%A4%C3%9Figes-siebeneck-formeln-und-eigenschaften">Mathespass.at</a>
	 * 
	 * @param a Seitenlänge
	 * @return Flächeninhalt
	 */
	public static double flaecheSiebeneck(double a) {
		return flaecheAllgemein(a, 7);
	}

	/**
	 * 
	 * @param aSeitenlänge
	 * @return Innenradius
	 */
	public static double innenRadiusSiebeneck(double a) {
		return innenRadiusAllgemein(a, 7);
	}

	/**
	 * Allgemeine Formel zur Berechnung von regelmäßigen n-eckigen Flächen.
	 * 
	 * @param a Seitenlänge
	 * @param n Anzahl der Ecken
	 * @return Flächeninhalt
	 */
	public static double flaecheAllgemein(double a, int n) {
		if (n < 3)
			throw new RuntimeException(String.format("%d-seitige Flächen sind nicht definiert!%n", n));

		if (a <= 0)
			throw new RuntimeException(
					String.format("Flächen mit einer Seitenlänge von a=%.2f sind nicht definiert!%n", a));

		return (n * Math.pow(a, 2)) / (4 * Math.tan(Math.PI / n));
	}

	/**
	 * 
	 * @param a Seitenlänge
	 * @param n Anzahl der Ecken
	 * @return Innenradius
	 */
	public static double innenRadiusAllgemein(double a, int n) {
		return a / (2 * Math.tan(Math.PI / n));
	}

	/**
	 * Rahmen erzeugen, der so breit ist wie der Eingabetext (mit Padding und
	 * bottom-Margin von 1).
	 * 
	 * @param out  Instanz des PrintWriters
	 * @param text Eingabetext
	 */
	public static void printBorder(PrintWriter out, String text) {
		printBorder(out, text, 1);
	}

	/**
	 * Rahmen erzeugen, der so breit ist wie der Eingabetext (mit Padding und
	 * bottom-Margin von n).
	 * 
	 * @param out           Instanz des PrintWriters
	 * @param text          Eingabetext
	 * @param marginBottomm Anzahl der Zeilenumbrüche am Ende der Ausgabe
	 */
	public static void printBorder(PrintWriter out, String text, int marginBottom) {
		for (int i = -4; i < text.length(); i++)
			out.print(frameChar);
		for (int i = 0; i < marginBottom; i++)
			out.printf("%n");
	}

	/**
	 * Links und rechts mit Padding ein "Rahmen"-Symbol dem Eingabetext hinzufügen.
	 * 
	 * @param out  Instanz des PrintWriters
	 * @param text Eingabetext
	 */
	public static void printHeadline(PrintWriter out, String text) {
		out.printf("%s %s %s%n", frameChar, text, frameChar);
	}

}
