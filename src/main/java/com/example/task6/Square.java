package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {
    private double side;
    private Color color;

    public Square(double side) {
        this.side = side;
        this.type = "Квадрат";
    }

    @Override
    public void draw(GraphicsContext gc, Double poinX, Double poinY) {
        gc.setFill(color.OLIVEDRAB);
        gc.fillRect(poinX, poinY, side, side);
    }

    @Override
    public String toString() {
        return "Square";
    }
}