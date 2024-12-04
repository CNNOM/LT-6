package com.example.task6;

import javafx.scene.canvas.GraphicsContext;

public class OutlineSizeDecorator extends ShapeDecorator {
    private double outlineSize;

    public OutlineSizeDecorator(Shape decoratedShape, double outlineSize) {
        super(decoratedShape);
        this.outlineSize = outlineSize;
    }

    @Override
    public void draw(GraphicsContext gr, double x, double y) {
        gr.setLineWidth(outlineSize);
        super.draw(gr, x, y);
        gr.stroke(); // Убедитесь, что контур отрисовывается
    }
}