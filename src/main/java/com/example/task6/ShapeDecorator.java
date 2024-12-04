package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class ShapeDecorator extends Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        super(decoratedShape.size, decoratedShape.color);
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw(GraphicsContext gr, double x, double y) {
        decoratedShape.draw(gr, x, y);
    }

    @Override
    public Shape clone() {
        return decoratedShape.clone();
    }
}