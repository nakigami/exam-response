package com.exam.designpatternexamen.models;

import ch.qos.logback.core.net.ObjectWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Dessin {
    ArrayList<Figure> figures;
    Traitement t;

    public Dessin() {
        figures = new ArrayList<>();
    }

    public void traiter() {
        t.traitement();
    }

    public void ajouter(Figure f) {
        figures.add(f);
    }

    public void supprimer(Figure f) {
        figures.remove(f);
    }

    public void dessiner()
    {
        for (Figure f : figures) {
            f.draw();
        }
    }

    public void serialiser() throws Exception {
        File file = new File("CUSTOMISED PATH");

        FileOutputStream f = new FileOutputStream(file);

        ObjectOutputStream object = new ObjectOutputStream(f);
        for (Figure figure : figures) {
            object.writeObject(figure);
        }
    }
}
