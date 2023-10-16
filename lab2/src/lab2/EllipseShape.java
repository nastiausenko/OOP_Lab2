package lab2;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;

public class EllipseShape extends Shape{
    private Ellipse currentEllipse;

    public EllipseShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void draw() {
        root.setOnMousePressed(event -> {
            currentEllipse = new Ellipse();
            currentEllipse.setCenterX(event.getX() - currentEllipse.getCenterX());
            currentEllipse.setCenterY(event.getY() - currentEllipse.getCenterY());
            currentEllipse.setRadiusX(0);
            currentEllipse.setRadiusY(0);
            currentEllipse.setStroke(Color.BLACK);
            currentEllipse.setStrokeWidth(1.5);
            currentEllipse.setFill(null);
            root.getChildren().add(currentEllipse);
        });

        root.setOnMouseDragged(event -> {
            if (currentEllipse != null) {
                currentEllipse.setStrokeLineCap(StrokeLineCap.BUTT);
                currentEllipse.setStrokeLineJoin(StrokeLineJoin.MITER);
                currentEllipse.getStrokeDashArray().addAll(5.0, 5.0);
                currentEllipse.setRadiusX(event.getX() - currentEllipse.getCenterX());
                currentEllipse.setRadiusY(event.getY() - currentEllipse.getCenterY());
            }
        });

        root.setOnMouseReleased(event -> {
            currentEllipse.getStrokeDashArray().clear();
            currentEllipse.setStroke(Color.BLACK);
            currentEllipse.setFill(Color.ORANGE);
            currentEllipse = null;
        });

    }
}
