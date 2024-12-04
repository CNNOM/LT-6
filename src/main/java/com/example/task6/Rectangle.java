package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {

    public Rectangle(double size, Color color) {
        super(size, color);
        this.type = "Прямоугольник";
    }

    @Override
    public void draw(GraphicsContext gr, double x, double y) {
        this.x = x;
        this.y = y;
        gr.setFill(color);
        gr.fillRect(x, y, size, size);
    }

    @Override
    public String toString() {
        return "Rectangle";
    }
}