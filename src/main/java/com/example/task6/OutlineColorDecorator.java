package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class OutlineColorDecorator extends ShapeDecorator {
    private Color outlineColor;

    public OutlineColorDecorator(Shape decoratedShape, Color outlineColor) {
        super(decoratedShape);
        this.outlineColor = outlineColor;
    }

    @Override
    public void draw(GraphicsContext gr, double x, double y) {
        gr.setStroke(outlineColor);
        super.draw(gr, x, y);
        gr.stroke(); // Убедитесь, что контур отрисовывается
    }
}