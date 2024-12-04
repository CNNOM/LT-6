package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius, Color color) {
        super(radius * 2, color);
        this.type = "Circle";
        this.radius = radius;
    }

    @Override
    public void draw(GraphicsContext gr, double x, double y) {
        this.x = x;
        this.y = y;
        gr.setFill(color);
        gr.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public String toString() {
        return "Circle";
    }
}