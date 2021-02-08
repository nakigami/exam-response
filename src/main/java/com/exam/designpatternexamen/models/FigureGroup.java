package com.exam.designpatternexamen.models;


import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;

@Component
public class FigureGroup extends Figure implements Serializable {
    private ArrayList<Figure> figures;

    public FigureGroup(Point p) {
        super(p);
        figures = new ArrayList();
    }

    public FigureGroup() {
        super(new Point(0,0));
    }

    @Override
    public double surface() {
        double surface = 0;
        for ( Figure f : this.figures) {
            surface += f.surface();
        }

        return surface;
    }

    @Override
    public double perimetre() {
        double per = 0;
        for ( Figure f : this.figures) {
            per += f.perimetre();
        }

        return per;
    }

    @Override
    public void draw() {
        for ( Figure f : this.figures) {
            f.draw();
        }
    }

    public void removeFigure(Figure F)
    {
        this.figures.remove(F);
    }

    @Override
    public void update(Observable o) {
        for (Figure f : this.figures) {
            f.update(o);
        }
    }

    public void addFigure(Figure F)
    {
        this.figures.add(F);
    }

}
