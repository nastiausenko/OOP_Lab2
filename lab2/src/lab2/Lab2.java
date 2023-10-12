package lab2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import shape_editor.ShapeObjectsEditor;

public class Lab2 extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        Scene scene = new Scene(layout, 700, 500);

        ShapeObjectsEditor shapeEditor = new ShapeObjectsEditor();

        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("File");
        Menu shapes = new Menu("Shapes");
        Menu help = new Menu("Help");

        menuBar.getMenus().addAll(file, shapes, help);

        MenuItem point = new MenuItem("Point");
        MenuItem line = new MenuItem("Line");
        MenuItem ellipse = new MenuItem("Ellipse");
        MenuItem rectangle = new MenuItem("Rectangle");

        shapes.getItems().addAll(point, line, ellipse, rectangle);

        rectangle.setOnAction(actionEvent -> shapeEditor.startRectangleEditor(scene, layout));
        line.setOnAction(actionEvent -> shapeEditor.startLineEditor(scene, layout));
        point.setOnAction(actionEvent -> shapeEditor.startPointEditor(scene, layout));
        ellipse.setOnAction(actionEvent -> shapeEditor.startEllipseEditor(scene, layout));


        layout.setTop(menuBar);

        stage.setScene(scene);
        stage.setTitle("Lab2");
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
