package lab2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import shape_editor.ShapeObjectsEditor;

public class Lab2 extends Application {
    private ShapeObjectsEditor shapeEditor;

    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        Canvas canvas = new Canvas(700, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        layout.setCenter(canvas);

        shapeEditor = new ShapeObjectsEditor(canvas, gc);

        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("File");
        Menu shapes = new Menu("Shapes");
        Menu help = new Menu("Help");

        menuBar.getMenus().addAll(file, shapes, help);

        MenuItem point = new MenuItem("Point");
        MenuItem line = new MenuItem("Line");
        MenuItem circle = new MenuItem("Circle");
        MenuItem rectangle = new MenuItem("Rectangle");

        shapes.getItems().addAll(point, line, circle, rectangle);

        line.setOnAction(actionEvent -> shapeEditor.startLineEditor());
        point.setOnAction(actionEvent -> shapeEditor.startPointEditor());


        layout.setTop(menuBar);

        Scene scene = new Scene(layout, 700, 500);
        stage.setScene(scene);
        stage.setTitle("Lab2");
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
