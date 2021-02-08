package com.exam.designpatternexamen.models;

import com.exam.designpatternexamen.models.aspectsAOP.LoggerMessage;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public abstract class Figure implements ObserverFigure, Serializable {
    public Point p;

    public Figure(Point p)
    {
        this.p = p;
    }
    @LoggerMessage
    public abstract double surface();
    @LoggerMessage
    public abstract double perimetre();
    @LoggerMessage
    public abstract void draw();
}
