package lab2;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;

public class PointShape extends Shape {
    private double startX, startY;
    private Canvas canvas;
    private GraphicsContext gc;
    private List<Line> lines = new ArrayList<>();
    private boolean isDrawing = false;

    public PointShape(Canvas canvas, GraphicsContext gc) {
        this.canvas = canvas;
        this.gc = gc;
    }
    @Override
    public void show() {
            canvas.setOnMousePressed(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    double x = event.getX();
                    double y = event.getY();

                    gc.setFill(Color.BLACK); // Встановлює колір крапки на чорний (або інший бажаний колір)
                    double pointSize = 15;    // Розмір крапки (можете змінити на бажаний)

                    // Малюємо крапку на позиції (x, y)
                    gc.fillOval(x - pointSize / 2, y - pointSize / 2, pointSize, pointSize);
                }
            });
    }
}
