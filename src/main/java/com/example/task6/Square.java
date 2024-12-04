package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {
    private double side;

    public Square(double side, Color color) {
        super(side, color);
        this.side = side;
        this.type = "Квадрат";
    }

    @Override
    public void draw(GraphicsContext gc, double x, double y) {
        this.x = x;
        this.y = y;
        gc.setFill(color);
        gc.fillRect(x, y, side, side);
    }

    @Override
    public String toString() {
        return "Square";
    }
}