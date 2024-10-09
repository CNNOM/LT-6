package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {
    private double side;
    private Color color;

    public Triangle(double side) {
        this.side = side;
        this.type = "Треугольник";
    }

    @Override
    public void draw(GraphicsContext gc, Double poinX, Double poinY) {
        gc.setFill(color.BLUE);
        double height = side * Math.sqrt(3) / 2; // Высота равностороннего треугольника
        double[] xPoints = {poinX, poinX + side / 2, poinX + side};
        double[] yPoints = {poinY + height, poinY, poinY + height};
        gc.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public String toString() {
        return "Triangle";
    }
}