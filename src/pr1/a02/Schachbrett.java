package pr1.a02;

import java.io.PrintWriter;

public class Schachbrett {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		out.print(schachbrett());
		out.println();
		out.print(schachbrettReverse());
		out.flush();
	}

	public static String schachbrett() {
		return schachbrett(false);
	}

	public static String schachbrettReverse() {
		return schachbrett(true);
	}

	public static String schachbrett(boolean isReverse) {
		StringBuilder result = new StringBuilder();

		if (isReverse) {
			for (int i = 1; i <= 8; i++) {
				for (char c = 'H'; c >= 'A'; c--) {
					result.append(String.format("%s%d ", c, i));
				}
				result.append("\n");
			}
		} else {
			for (int i = 8; i >= 1; i--) {
				for (char c = 'A'; c <= 'H'; c++) {
					result.append(String.format("%s%d ", c, i));
				}
				result.append("\n");
			}
		}
		return result.toString();
	}

}
