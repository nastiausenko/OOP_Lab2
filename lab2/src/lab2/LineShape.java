package lab2;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;

public class LineShape extends Shape {
    private double startX, startY;
    private Canvas canvas;
    private GraphicsContext gc;
    private List<Line> lines = new ArrayList<>();
    private boolean isDrawing = false;

    public LineShape(Canvas canvas, GraphicsContext gc) {
        this.canvas = canvas;
        this.gc = gc;
    }
    @Override
    public void show(){
        canvas.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                startX = event.getX();
                startY = event.getY();
                isDrawing = true;
            }
        });

        canvas.setOnMouseDragged(event -> {
            if (isDrawing) {
                double endX = event.getX();
                double endY = event.getY();

                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                for (Line line : lines) {
                    gc.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
                }
                gc.strokeLine(startX, startY, endX, endY);}
        });

        canvas.setOnMouseReleased(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                isDrawing = false;
                double endX = event.getX();
                double endY = event.getY();
                lines.add(new Line(startX, startY, endX, endY));
            }
        });
    }
}
