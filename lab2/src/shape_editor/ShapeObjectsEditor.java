package shape_editor;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import lab2.LineShape;
import lab2.PointShape;
import lab2.RectangleShape;

public class ShapeObjectsEditor {
    private Canvas canvas;
    private GraphicsContext gc;
    public double startX, startY, endX, endY;

    public ShapeObjectsEditor(Canvas canvas, GraphicsContext gc) {
        this.canvas = canvas;
        this.gc = gc;
    }
    public void startLineEditor(){
        LineShape line = new LineShape(canvas, gc);
        line.show();
    }

    public void startPointEditor(){
        PointShape point = new PointShape(canvas, gc);
        point.show();
    }

    public void startRectangleEditor() {
        RectangleShape rectangle = new RectangleShape(canvas, gc);
        rectangle.show();
    }
}