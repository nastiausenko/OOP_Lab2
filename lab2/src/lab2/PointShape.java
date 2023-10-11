package lab2;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class PointShape extends Shape {
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
