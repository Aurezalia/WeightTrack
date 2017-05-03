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
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JPanel;

//This didn't get used because Java was mean to me and I couldn't make a chart. 
//But it's still here. Looking pretty. 

public class Chart extends JPanel {
	ArrayList<Point2D.Double> points = new ArrayList<Point2D.Double>();
	Point2D.Double p;
	String userName;
	Double userHeight;
	Double userWeight;
	Double userGoal;
	private newLinkedList<Record> weightStack;
	private GraphDrawer drawer = new WhateverDrawer();

	public Chart(newLinkedList<Record> weightStack){
		this.weightStack = weightStack;
	}
	
	//@Override
	@SuppressWarnings("unchecked")
	public void sortList(){
		Collections.sort(weightStack);
	}

	public void setPoints() {
		double scalex = 123 / (weightStack.size() - 1);
		for (int i = 0; i < weightStack.size(); i++) {
			Record n = weightStack.get(i);
			Point2D.Double p = new Point2D.Double(scalex * i, n.userWeight);
			points.add(p);
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		drawer.draw(g2d);
	}

	public void drawGraph() {
		JPanel graph = new JPanel();
		repaint();

	}
	
	private interface GraphDrawer {
		void draw(Graphics2D g);
	}
	
	private class WhateverDrawer implements GraphDrawer {
		public void draw(Graphics2D g) {
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(Color.red);
			g.setStroke(new BasicStroke(2));
			for (int i = 1; i < weightStack.size(); i++) {
				g.draw(new Line2D.Double(points.get(i-1), points.get(i)));
			}

		}
	}

	private class PurpleDrawer implements GraphDrawer {
		public void draw(Graphics2D g) {
			// Again but purple this time.
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(Color.red);
			g.setStroke(new BasicStroke(2));
			for (int i = 1; i < weightStack.size(); i++) {
				g.draw(new Line2D.Double(points.get(i-1), points.get(i)));
			}

		}
	}
/*	public void retrieveLines() throws IOException {
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

	@Override
	public void chartPressed() {
		// TODO Auto-generated method stub
		
	}*/
}
