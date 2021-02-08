package com.exam.designpatternexamen.models;

import com.exam.designpatternexamen.models.aspectsAOP.LoggerMessage;
import com.exam.designpatternexamen.models.aspectsAOP.SecuredByAspect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component @Data @AllArgsConstructor
public class Params implements Observable{
    private int colorC;
    private int colorS;
    private int epaisseurC;
    private ArrayList<ObserverFigure> figures;

    public Params(){
        figures = new ArrayList<>();
    }

    @Override
    public void notifierFigures() {
        for (ObserverFigure o : figures) {
            o.update(this);
        }
    }

    @LoggerMessage
    @SecuredByAspect(roles = {"ADMIN"})
    @Override
    public void supprimerFigure(Figure f) {
        figures.remove(f);
    }

    @LoggerMessage
    @SecuredByAspect(roles = {"ADMIN"})
    @Override
    public void ajouterFigure(Figure f) {
        figures.add(f);
    }
}
