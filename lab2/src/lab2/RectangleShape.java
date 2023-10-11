package lab2;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class RectangleShape extends Shape {
    private List<Rectangle> rectangles = new ArrayList<>();
    private boolean isDotted = true;

    public RectangleShape(Canvas canvas, GraphicsContext gc) {
        this.canvas = canvas;
        this.gc = gc;
    }

    @Override
    public void show() {
        canvas.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                startX = event.getX();
                startY = event.getY();
                isDotted = true;


                gc.setStroke(Color.BLACK);
                if (isDotted) {
                    gc.setLineDashes(5, 5);
                } else {
                    gc.setLineDashes(0);
                }
                gc.setLineWidth(2);
            }
        });

        canvas.setOnMouseDragged(event -> {
                double endX = event.getX();
                double endY = event.getY();

                gc.clearRect(startX, startY, endX - startX, endY - startY);

                gc.strokeRect(startX, startY, endX - startX, endY - startY);
                gc.setLineDashes(5, 5);
                gc.setFill(Color.TRANSPARENT);
        });

        canvas.setOnMouseReleased(event -> {
                double endX = event.getX();
                double endY = event.getY();

                gc.setLineDashes(0);
                gc.setStroke(Color.BLACK);
                gc.setLineWidth(2);

                gc.strokeRect(startX, startY, endX - startX, endY - startY);

                rectangles.add(new Rectangle(startX, startY, endX - startX, endY - startY));
        });
    }
}
