package com.exam.designpatternexamen.models;

import com.exam.designpatternexamen.models.aspectsAOP.LoggerMessage;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Rectangle extends Figure implements Serializable {
    private double larg;
    private double hauteur;

    public Rectangle(double l, double h, Point p) {
        super(p);
        this.larg = l;
        this.hauteur = h;
    }

    public Rectangle() {
        super(new Point(0,0));

    }

    @Override
    @LoggerMessage
    public double surface() {
        return larg*hauteur;
    }

    @Override
    @LoggerMessage
    public double perimetre() {
        return 2*(larg+hauteur);
    }

    @Override
    @LoggerMessage
    public void draw() {
        System.out.println("L : " + larg + "H :" + hauteur + " permietre : " + perimetre() + " Surface : " + surface());
    }

    @Override
    public void update(Observable o) {

        int CouleurContour= ((Params) o).getColorC();
        int CouleurSurface = ((Params) o).getColorS();
        int epaisseur = ((Params) o).getEpaisseurC();
        System.out.println("Color contour : " + CouleurContour +
                " Couleur surface : " + CouleurSurface +
                " Epaisseur : " + epaisseur);
    }
}
