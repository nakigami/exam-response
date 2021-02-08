package com.exam.designpatternexamen;

import com.exam.designpatternexamen.models.*;
import com.exam.designpatternexamen.models.aspectsAOP.AppContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class DesignPatternExamenApplication {

    public static void main(String[] args) {
        AppContext.authenticateUser("anas","anas",new String[]{"ADMIN"});
        SpringApplication.run(DesignPatternExamenApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(Params params){
        return args -> {
            Rectangle rectangle = new Rectangle(1 ,2, new Point(2,4));
            Circle circle1 = new Circle(2,new Point(2,3));
            System.out.println("La surface est : " + circle1.surface());
            System.out.println("Le perimetre du rectabngle est : " + rectangle.perimetre());
            params.ajouterFigure(circle1);
            params.notifierFigures();
        };
    }
}
