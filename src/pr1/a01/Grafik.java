package pr1.a01;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Grafik extends Frame {

	public static void main(String[] args) {
		new Grafik();
	}

	public Grafik() {
		super("Grafik-Test");
		setSize(800, 600);

		Canvas canvas = new Canvas();

		add("Center", canvas);


		setLocationRelativeTo(null);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

}
