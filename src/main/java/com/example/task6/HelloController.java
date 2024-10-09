package com.example.task6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ListView<Shape> listView;

    @FXML
    private Canvas canvas;

    private ObservableList<Shape> items;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle(50);
        Square square = new Square(60);
        Pentagon pentagon = new Pentagon(30);
        Triangle triangle = new Triangle(40);

        items = FXCollections.observableArrayList(rectangle, circle, square, pentagon, triangle);
        listView.setItems(items);

        // Устанавливается режим выбора в ListView на SINGLE, что означает,
        // что пользователь может выбрать только один элемент за раз
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, this::addShape);
    }

    @FXML
    public void addShape(MouseEvent event) {
        System.out.println("Mouse event occurred at: " + event.getX() + ", " + event.getY());

        GraphicsContext gr = canvas.getGraphicsContext2D();

        // Получение индекса выбранного элемента
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();

        if (selectedIndex != -1) {
            Shape selectedShape = items.get(selectedIndex);
            Shape newShape = selectedShape.clone();
            newShape.draw(gr, event.getX(), event.getY());
        } else {
            System.out.println("No shape selected.");
        }
    }

    public void cleanCan() {
        GraphicsContext gr = canvas.getGraphicsContext2D();
        gr.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}