package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pentagon extends Shape {
    private double side;
    private Color color;

    public Pentagon(double side) {
        this.side = side;
        this.type = "Пятиугольник";
    }

    @Override
    public void draw(GraphicsContext gc, Double poinX, Double poinY) {
        gc.setFill(color.KHAKI);
        double[] xPoints = new double[5];
        double[] yPoints = new double[5];
        double angle = Math.PI / 180 * 72; // Угол между сторонами пятиугольника
        double radius = side / (2 * Math.sin(Math.PI / 5)); // Радиус описанной окружности

        for (int i = 0; i < 5; i++) {
            xPoints[i] = poinX + radius * Math.cos(angle * i);
            yPoints[i] = poinY + radius * Math.sin(angle * i);
        }

        gc.fillPolygon(xPoints, yPoints, 5);
    }

    @Override
    public String toString() {
        return "Pentagon";
    }
}