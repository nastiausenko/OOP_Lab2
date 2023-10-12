package lab2;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;


public abstract class Shape {
    protected Scene scene;
    protected Pane root;
    protected abstract void show();
    protected List<Ellipse> points = new ArrayList<>();
    protected List<Rectangle> rectangles = new ArrayList<>();
    protected List<Line> lines = new ArrayList<>();
    protected List<Ellipse> ellipses = new ArrayList<>();

    public Shape(Scene scene, Pane root) {
        this.scene = scene;
        this.root = root;
    }
}