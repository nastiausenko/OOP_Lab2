package lab2;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;

public class RectangleShape extends Shape {
    private Rectangle currentRectangle;

    public RectangleShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void draw() {
        root.setOnMousePressed(event -> {
            currentRectangle = new Rectangle();
            currentRectangle.setX(event.getX());
            currentRectangle.setY(event.getY());
            currentRectangle.setWidth(0);
            currentRectangle.setHeight(0);
            currentRectangle.setStroke(Color.BLACK);
            currentRectangle.setStrokeWidth(1.5);
            currentRectangle.setFill(null);
            root.getChildren().add(currentRectangle);
        });

        root.setOnMouseDragged(event -> {
            if (currentRectangle != null) {
                currentRectangle.setStrokeLineCap(StrokeLineCap.BUTT);
                currentRectangle.setStrokeLineJoin(StrokeLineJoin.MITER);
                currentRectangle.getStrokeDashArray().addAll(5.0, 5.0);
                currentRectangle.setWidth(event.getX() - currentRectangle.getX());
                currentRectangle.setHeight(event.getY() - currentRectangle.getY());
            }
        });

        root.setOnMouseReleased(event -> {
            currentRectangle.getStrokeDashArray().clear();
            currentRectangle = null;
        });
    }
}
