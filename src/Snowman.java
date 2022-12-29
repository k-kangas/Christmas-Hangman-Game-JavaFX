/*
 * Kurt Kangas
 * CIS 2212 Java Software Development I
 * JavaFX Christmas Hangman Game (Disappearing Snowman) - Simple hangman game using JavaFX
 */

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Snowman {
	//** Start of Class
	public Group Hat(double LayoutHeight, double LayoutWidth)
	{
		Group group = new Group();

		// Variables
		double Layout = (LayoutWidth + LayoutHeight) / 2;
		double X =  LayoutWidth / 2;
		double Y = LayoutHeight / 2 - ((Layout * 0.1125) * 1.3);
		double base = Layout * 0.05;
		double height = 10.0;
		Color c = Color.BLACK;
		Color lineColor = Color.GRAY;

		// Hat
		Rectangle rectangle = new Rectangle();
		rectangle.setHeight(height);
		rectangle.setWidth(base + 20.0);
		rectangle.setX(X - 25.0);
		rectangle.setY(Y - 30.0);
		rectangle.setFill(c);
		rectangle.setStrokeWidth(1);
		rectangle.setStroke(lineColor);
		Rectangle rectangle2 = new Rectangle();
		rectangle2.setHeight(height + 30.0);
		rectangle2.setWidth(base + 10.0);
		rectangle2.setX(X - 20.0);
		rectangle2.setY(Y - 60.0);
		rectangle2.setFill(c);
		rectangle2.setStrokeWidth(1);
		rectangle2.setStroke(lineColor);

		group.getChildren().add(rectangle2);
		group.getChildren().add(rectangle);

		return group;
	}
	public Group Buttons(double LayoutHeight, double LayoutWidth) {
		Group group = new Group();

		// Variables
		double Layout = (LayoutWidth + LayoutHeight) / 2;
		double X = LayoutWidth / 2 ;
		double Y = LayoutHeight / 2 - ((Layout * 0.0625) * 1.3);
		double R = 3.0;
		Color c = Color.BLACK;
		Color lineColor = Color.BLACK;

		// Top Button
		Circle circle = new Circle();
		circle.setCenterX(X);
		circle.setCenterY(Y - 10.0);
		circle.setRadius(R);
		circle.setFill(c);
		circle.setStroke(lineColor);
		circle.setStrokeWidth(1);

		// Middle Button
		Y = LayoutHeight / 2 - ((Layout * 0.0625) * 1.3);
		Circle circle2 = new Circle();
		circle2.setCenterX(X);
		circle2.setCenterY(Y);
		circle2.setRadius(R);
		circle2.setFill(c);
		circle2.setStroke(lineColor);
		circle2.setStrokeWidth(1);

		// Bottom Button
		Circle circle3 = new Circle();
		circle3.setCenterX(X);
		circle3.setCenterY(Y + 10.0);
		circle3.setRadius(R);
		circle3.setFill(c);
		circle3.setStroke(lineColor);
		circle3.setStrokeWidth(1);

		group.getChildren().add(circle);
		group.getChildren().add(circle2);
		group.getChildren().add(circle3);

		return group;
	}
	public Group LeftArm(double LayoutHeight, double LayoutWidth) {
		Group group = new Group();

		// Variables
		double Layout = (LayoutWidth + LayoutHeight) / 2;
		double X = LayoutWidth / 2 ;
		double Y = LayoutHeight / 2 - ((Layout * 0.0625) * 1.3);
		Color c = Color.BLACK;

		Line line = new Line();
		line.setStartX(X);
		line.setStartY(Y);
		line.setEndX(X - 60.0);
		line.setEndY(Y - 30.0);
		line.setStroke(c);
		line.setStrokeWidth(2);

		group.getChildren().add(line);
		return group;
	}
	public Group RightArm(double LayoutHeight, double LayoutWidth) {
		Group group = new Group();

		// Variables
		double Layout = (LayoutWidth + LayoutHeight) / 2;
		double X = LayoutWidth / 2 ;
		double Y = LayoutHeight / 2 - ((Layout * 0.0625) * 1.3);
		Color c = Color.BLACK;

		Line line = new Line();
		line.setStartX(X);
		line.setStartY(Y);
		line.setEndX(X + 60.0);
		line.setEndY(Y - 30.0);
		line.setStroke(c);
		line.setStrokeWidth(2);

		group.getChildren().add(line);
		return group;
	}
	public Group Bottom(double LayoutHeight, double LayoutWidth) {
		Group group = new Group();

		// Variables
		double X = LayoutWidth / 2 ;
		double Y = LayoutHeight / 2;
		double Layout = (LayoutWidth + LayoutHeight) / 2;
		double R = Layout * 0.0625;
		Color c = Color.WHITE;
		Color lineColor = Color.GRAY;

		Circle circle = new Circle();
		circle.setCenterX(X);
		circle.setCenterY(Y);
		circle.setRadius(R);
		circle.setFill(c);
		circle.setStroke(lineColor);
		circle.setStrokeWidth(1);

		group.getChildren().add(circle);
		return group;
	}
	public Group Middle(double LayoutHeight, double LayoutWidth) {
		Group group = new Group();

		// Variables
		double Layout = (LayoutWidth + LayoutHeight) / 2;
		double X = LayoutWidth / 2 ;
		double Y = LayoutHeight / 2 - ((Layout * 0.0625) * 1.3);
		double R = Layout * 0.05;
		Color c = Color.WHITE;
		Color lineColor = Color.GRAY;

		Circle circle = new Circle();
		circle.setCenterX(X);
		circle.setCenterY(Y);
		circle.setRadius(R);
		circle.setFill(c);
		circle.setStroke(lineColor);
		circle.setStrokeWidth(1);

		group.getChildren().add(circle);
		return group;

	}
	public Group Head(double LayoutHeight, double LayoutWidth) {	
		Group group = new Group();

		// Variables
		double Layout = (LayoutWidth + LayoutHeight) / 2;
		double X = LayoutWidth / 2 ;
		double R = Layout * 0.0375;
		double Y = LayoutHeight / 2 - ((Layout * 0.1125) * 1.3);
		Color c = Color.WHITE;
		Color lineColor = Color.GRAY;

		// Head Shape Circle
		Circle circle = new Circle();
		circle.setCenterX(X);
		circle.setCenterY(Y);
		circle.setRadius(R);
		circle.setFill(c);
		circle.setStroke(lineColor);
		circle.setStrokeWidth(1);

		// Eye Circle (left)
		Circle circle2 = new Circle();
		circle2.setCenterX(X);
		circle2.setCenterY(Y);
		circle2.setRadius(R);
		circle2.setFill(c);
		circle2.setStroke(lineColor);
		circle2.setStrokeWidth(1);


		// Eye Circle (Right)
		Circle circle3 = new Circle();
		circle3.setCenterX(X);
		circle3.setCenterY(Y);
		circle3.setRadius(R);
		circle3.setFill(c);
		circle3.setStroke(lineColor);
		circle3.setStrokeWidth(1);


		// Smile ~~ Add if you wish ~~
		/*
		Arc arc = new Arc();
		arc.setCenterX(50.0f);
		arc.setCenterY(50.0f);
		arc.setRadiusX(25.0f);
		arc.setRadiusY(25.0f);
		arc.setStartAngle(45.0f);
		arc.setLength(270.0f);
		arc.setType(ArcType.ROUND);
		 */
		/*
		 * Arc(double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length)
			Creates a new instance of Arc.
		Parameters:
			centerX - the X coordinate of the center point of the arc
			centerY - the Y coordinate of the center point of the arc
			radiusX - the overall width (horizontal radius) of the full ellipse of which this arc is a partial section
			radiusY - the overall height (vertical radius) of the full ellipse of which this arc is a partial section
			startAngle - the starting angle of the arc in degrees
			length - the angular extent of the arc in degrees
		 */
		// Nose
		Polygon polygon = new Polygon();
		c = Color.ORANGE;
		Layout = (LayoutWidth + LayoutHeight) / 2;
		X = LayoutWidth / 2 ;
		Y = LayoutHeight / 2 - ((Layout * 0.1125) * 1.3);
		polygon.getPoints().addAll(new Double[]{
				X - 30.0, Y,
				X, Y - 3.0,
				X, Y + 3.0 });
		polygon.setFill(c);

		// Eyes
		R = Layout * 0.00375;
		c = Color.BLACK;
		Circle LeyeCircle = new Circle();
		LeyeCircle.setCenterX(X - 10.0);
		LeyeCircle.setCenterY(Y - 10.0);
		LeyeCircle.setRadius(R);
		LeyeCircle.setFill(c);
		LeyeCircle.setStroke(lineColor);
		LeyeCircle.setStrokeWidth(1);
		Circle ReyeCircle = new Circle();
		ReyeCircle.setCenterX(X + 10.0);
		ReyeCircle.setCenterY(Y - 10.0);
		ReyeCircle.setRadius(R);
		ReyeCircle.setFill(c);
		ReyeCircle.setStroke(lineColor);
		ReyeCircle.setStrokeWidth(1);

		group.getChildren().add(circle);
		group.getChildren().add(polygon);
		group.getChildren().add(LeyeCircle);
		group.getChildren().add(ReyeCircle);
		return group;
	}
	public Group Background(double LayoutHeight, double LayoutWidth) {
		Group group = new Group();

		// Variables
		double X = 0.0;
		double Y = 0.0;
		double width = LayoutWidth;
		double height = LayoutHeight;
		Color c = Color.AQUA;

		Rectangle rectangle = new Rectangle();
		rectangle.setHeight(height);
		rectangle.setWidth(width);
		rectangle.setX(X);
		rectangle.setY(Y);
		rectangle.setFill(c);

		group.getChildren().add(rectangle);
		return group;
	}
}
