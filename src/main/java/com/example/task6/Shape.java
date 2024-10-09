package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


// абстрактный класс Shape, который реализует интерфейс Cloneable.
public abstract class Shape implements Cloneable {
    protected String type;

    // для рисования на Canvas, а также координаты poinX и poinY, которые могут использоваться для позиционирования фигуры.
    public abstract void draw(GraphicsContext gr, Double poinX, Double poinY);

    // это метод, который создает копию объекта. Он вызывает метод clone()
    // суперкласса и обрабатывает исключение CloneNotSupportedException,
    // если оно возникает.
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
        return super.toString();
    }
}