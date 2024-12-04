package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public abstract class Shape implements Cloneable {
    protected String type;
    protected double size;
    protected Paint color; // Изменено на Paint
    protected double x;
    protected double y;

    public Shape(double size, Paint color) { // Изменено на Paint
        this.size = size;
        this.color = color;
    }

    public abstract void draw(GraphicsContext gr, double x, double y);

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return type;
    }
}