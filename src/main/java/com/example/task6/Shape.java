package com.example.task6;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public abstract class Shape implements Cloneable {
    protected String type;
    protected double size;
    protected Paint color; // Изменено на Paint
    protected double x;
    protected double y;
    protected DoubleProperty opacity = new SimpleDoubleProperty(1.0); // Добавлено свойство opacity

    public Shape(double size, Paint color) { // Изменено на Paint
        this.size = size;
        this.color = color;
    }

    public abstract void draw(GraphicsContext gr, double x, double y, double opacity);

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public DoubleProperty opacityProperty() { // Добавлен метод для получения свойства opacity
        return opacity;
    }

    public double getOpacity() { // Добавлен метод для получения значения opacity
        return opacity.get();
    }

    public void setOpacity(double opacity) { // Добавлен метод для установки значения opacity
        this.opacity.set(opacity);
    }

    @Override
    public Shape clone() {
        try {
            Shape cloned = (Shape) super.clone();
            cloned.opacity = new SimpleDoubleProperty(this.opacity.get()); // Клонируем свойство opacity
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return type;
    }
}