package com.exam.designpatternexamen.models;

import com.exam.designpatternexamen.models.aspectsAOP.LoggerMessage;
import com.exam.designpatternexamen.models.aspectsAOP.SecuredByAspect;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component

public class Circle extends Figure implements Serializable {
    private double rayon;

    public Circle(double v, Point point) {
        super(point);
        this.rayon = v;
    }

    public Circle() {
        super(new Point(0,0));
    }

    @Override
    public double surface() {
        return Math.PI * Math.pow(rayon, 2);
    }

    @Override
    public double perimetre() {
        return 2 * Math.PI*rayon;
    }

    @Override
    public void draw() {
        System.out.println("Rayon : " + rayon + " Surface : " + this.surface() + "Partimetre : " + this.perimetre());
    }

    @Override
    @LoggerMessage
    @SecuredByAspect(roles = {"ADMIN"})
    public void update(Observable o) {
        int CouleurContour= ((Params) o).getColorC();
        int CouleurSurface = ((Params) o).getColorS();
        int epaisseur = ((Params) o).getEpaisseurC();
        System.out.println("Color contour : " + CouleurContour +
                " Couleur surface : " + CouleurSurface +
                " Epaisseur : " + epaisseur);
    }
}
