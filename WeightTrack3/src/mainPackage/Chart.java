package mainPackage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JPanel;

//This didn't get used because Java was mean to me and I couldn't make a chart. 
//But it's still here. Looking pretty. 

public class Chart extends JPanel {
	File file = new File("./src/mainPackage/Record");
	ArrayList<Double> weightArray = new ArrayList<Double>();
	ArrayList<Point2D.Double> points = new ArrayList<Point2D.Double>();
	Point2D.Double p;
	String userName;
	Double userHeight;
	Double userWeight;
	Double userGoal;

	public void setPoints() {
		for (double i = 0.0; i < weightArray.size(); i++) {
			for (int k = 0; k < weightArray.size(); i++) {
				double n = weightArray.get(k);
				Point2D.Double p = new Point2D.Double(i, n);
				// p.setLocation(i,(weightArray.get(k)));
				points.add(p);
			}
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.red);
		g2d.setStroke(new BasicStroke(2));
		for (int i = 0; i < 12; i++) {
			for (int j = 1; j < 13; j++) {
				g2d.draw(new Line2D.Double(points.get(i), points.get(j)));
			}
		}
	}

	public void drawGraph() {
		JPanel graph = new JPanel();
		repaint();

	}

	public void retrieveLines() throws IOException {
		Scanner scanner = null;
		try {
			scanner = new Scanner(file).useDelimiter(",");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if (scanner.hasNext()) {
			userName = scanner.next().trim();
			userHeight = Double.parseDouble(scanner.next().trim());
			userWeight = Double.parseDouble(scanner.next().trim());
			weightArray.add(userWeight);
			userGoal = Double.parseDouble(scanner.next().trim());
		} else {
			scanner.close();
		}

	}
}
