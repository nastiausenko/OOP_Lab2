package shape_editor;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import lab2.EllipseShape;
import lab2.LineShape;
import lab2.PointShape;
import lab2.RectangleShape;

public class ShapeObjectsEditor {

    public void startRectangleEditor(Scene scene, Pane root) {
        RectangleShape rectangle = new RectangleShape(scene, root);
        rectangle.show();
    }

    public void startLineEditor(Scene scene, Pane root){
        LineShape line= new LineShape(scene, root);
        line.show();
    }

    public void startPointEditor(Scene scene, Pane root){
        PointShape point = new PointShape(scene, root);
        point.show();
    }

    public void startEllipseEditor(Scene scene, Pane root){
        EllipseShape ellipseShape = new EllipseShape(scene, root);
        ellipseShape.show();
    }
}