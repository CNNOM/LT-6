package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {

    private double radius ;

    public Circle(double radius) {
        type = "Прямоугольник";
        this.radius = radius;
    }

    //  рисует прямоугольник на Canvas
    public void draw(GraphicsContext gr, Double poinX, Double poinY) {
        gr.setFill(Color.BLACK);
        gr.fillOval(poinX - radius, poinY - radius, radius * 2, radius * 2);
    }

    public String toString() {
        return "Circle";
    }

}