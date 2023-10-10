package shape_editor;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import lab2.LineShape;

public class ShapeObjectsEditor {
    private Canvas canvas;
    private GraphicsContext gc;

    public ShapeObjectsEditor(Canvas canvas, GraphicsContext gc) {
        this.canvas = canvas;
        this.gc = gc;
    }
    public void startLineEditor(){
        LineShape line = new LineShape(canvas, gc);
        line.show();
    }
}