package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {

    public Rectangle() {
        type = "Прямоугольник";
    }

    //  рисует прямоугольник на Canvas
    public void draw(GraphicsContext gr, Double poinX, Double poinY) {
        gr.setFill(Color.RED);
        gr.fillPolygon(new double[]{poinX, poinX + 25, poinX + 25, poinX},
                new double[]{poinY, poinY, poinY + 75, poinY + 75}, 4);
    }

    public String toString() {
        return "Rectangle";
    }

}
