package com.exam.designpatternexamen.models;

public interface Observable {
    void notifierFigures();
    void supprimerFigure(Figure f);
    void ajouterFigure(Figure f);
}
