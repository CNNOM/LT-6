package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Square extends Shape {
    public Square(double size, Paint color) {
        super(size, color);
        this.type = "Square";
    }

    @Override
    public void draw(GraphicsContext gr, double x, double y) {
        this.x = x;
        this.y = y;
        gr.setFill(color);
        gr.fillRect(x - size / 2, y - size / 2, size, size);
        gr.strokeRect(x - size / 2, y - size / 2, size, size); // Добавляем отрисовку контура
    }

    @Override
    public String toString() {
        return "Square";
    }
}