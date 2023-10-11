package lab2;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


public abstract class Shape {
    protected double startX, startY, endX, endY;
    protected Canvas canvas;
    protected GraphicsContext gc;
    abstract void show();
}