package lab2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import shape_editor.ShapeObjectsEditor;

public class Lab2 extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        Pane drawingArea = new Pane();
        layout.setCenter(drawingArea);
        Scene scene = new Scene(layout, 700, 500);

        ShapeObjectsEditor shapeEditor = new ShapeObjectsEditor();

        MenuBar menuBar = new MenuBar();
        drawingArea.setMaxHeight(scene.getHeight() - menuBar.getHeight());
        Menu file = new Menu("File");
        Menu shapes = new Menu("Shapes");
        Menu help = new Menu("Help");

        menuBar.getMenus().addAll(file, shapes, help);

        MenuItem point = new MenuItem("Point");
        MenuItem line = new MenuItem("Line");
        MenuItem ellipse = new MenuItem("Ellipse");
        MenuItem rectangle = new MenuItem("Rectangle");

        shapes.getItems().addAll(point, line, ellipse, rectangle);

        layout.setTop(menuBar);

        rectangle.setOnAction(actionEvent -> {
            shapeEditor.startRectangleEditor(scene, drawingArea);
            stage.setTitle("Rectangle");
        });
        line.setOnAction(actionEvent -> {
            shapeEditor.startLineEditor(scene, drawingArea);
            stage.setTitle("Line");
        });
        point.setOnAction(actionEvent -> {
            shapeEditor.startPointEditor(scene, drawingArea);
            stage.setTitle("Point");
        });
        ellipse.setOnAction(actionEvent -> {
            shapeEditor.startEllipseEditor(scene, drawingArea);
            stage.setTitle("Ellipse");
        });

        stage.setScene(scene);
        stage.setTitle("Lab2");
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
