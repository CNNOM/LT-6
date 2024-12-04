package com.example.task6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Stack;

public class HelloController implements Initializable {
    @FXML
    private ListView<Shape> listView;

    //    private Queue<Shape> shapeQueue = new LinkedList<>();
    private Stack<Shape> shapeStack = new Stack<>();
    private Stack<Shape> redoStack = new Stack<>();


    @FXML
    private Canvas canvas;

    @FXML
    private TextField sizeField;

    @FXML
    private ColorPicker colorPicker;

    private ObservableList<Shape> items;

    private boolean isDrawing = false;
    private double currentSize = 50; // Переменная для хранения текущего размера

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Rectangle rectangle = new Rectangle(currentSize, Color.RED);
        Circle circle = new Circle(currentSize, Color.BLUE);
        Square square = new Square(currentSize, Color.GREEN);
        Pentagon pentagon = new Pentagon(currentSize, Color.YELLOW);
        Triangle triangle = new Triangle(currentSize, Color.ORANGE);

        items = FXCollections.observableArrayList(rectangle, circle, square, pentagon, triangle);
        listView.setItems(items);

        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::onMousePressed);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::onMouseDragged);
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, this::onMouseReleased);
    }

    private void onMousePressed(MouseEvent event) {
        isDrawing = true;
        drawShape(event);
    }

    private void onMouseDragged(MouseEvent event) {
        if (isDrawing) {
            drawShape(event);
        }
    }

    private void onMouseReleased(MouseEvent event) {
        isDrawing = false;
    }

    @FXML
    public void drawShape(MouseEvent event) {
        System.out.println("Mouse event occurred at: " + event.getX() + ", " + event.getY());

        GraphicsContext gr = canvas.getGraphicsContext2D();

        int selectedIndex = listView.getSelectionModel().getSelectedIndex();

        if (selectedIndex != -1) {
            Shape selectedShape = items.get(selectedIndex);
            Color color = colorPicker.getValue();
            Shape newShape = selectedShape.clone();
            newShape.size = currentSize;
            newShape.color = color;
            newShape.draw(gr, event.getX(), event.getY());

//            shapeQueue.add(newShape);
            shapeStack.push(newShape);
        } else {
            System.out.println("No shape selected.");
        }
    }

    @FXML
    public void applySize() {
        try {
            currentSize = Double.parseDouble(sizeField.getText());
            System.out.println("Size applied: " + currentSize);
        } catch (NumberFormatException e) {
            System.out.println("Invalid size input.");
        }
    }

    public void cleanCan() {
        GraphicsContext gr = canvas.getGraphicsContext2D();
        gr.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

//        shapeQueue.clear();
        shapeStack.clear();
        redoStack.clear();
    }

    @FXML
    public void undo() {
//        if (!shapeQueue.isEmpty()) {
//            Shape lastShape = shapeQueue.poll();
//            redrawCanvas();
//        }

        if (!shapeStack.isEmpty()) {
            Shape lastShape = shapeStack.pop();
            redoStack.push(lastShape);
            redrawCanvas();
        }
    }

    @FXML
    public void redo() {
        if (!redoStack.isEmpty()) {
            Shape lastUndoneShape = redoStack.pop();
            shapeStack.push(lastUndoneShape);
            redrawCanvas();
        }
    }

    private void redrawCanvas() {
        GraphicsContext gr = canvas.getGraphicsContext2D();
        gr.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
//        for (Shape shape : shapeQueue) {
//            shape.draw(gr, shape.getX(), shape.getY());
//        }

        for (Shape shape : shapeStack) {
            shape.draw(gr, shape.getX(), shape.getY());
        }
    }
}