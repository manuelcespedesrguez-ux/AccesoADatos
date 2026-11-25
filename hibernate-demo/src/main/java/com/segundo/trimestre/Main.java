package com.segundo.trimestre;

import java.util.Comparator;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aulaPU");
        EntityManager em = emf.createEntityManager();

        try {
            Object nombreBD = em
                    .createNativeQuery("SELECT DATABASE()")
                    .getSingleResult();
            System.out.println("Conexión correcta.");
            System.out.println("Base de datos: " + nombreBD);

            // 1. Listado de actores ordenados por ID
            List<Actor> actores = em.createQuery("""
                    SELECT a FROM Actor a ORDER BY a.actor_id
                    """, Actor.class).getResultList();

            System.out.println("ID | NOMBRE | APELLIDO");
            for (Actor a : actores) {
                System.out.println(a.getActor_id() + " | " + a.getFirst_name() + " | " + a.getLast_name());
            }
            System.out.println("El número de actores es: " + actores.size());

            System.out.println("----------------------------------------");

            // 2. Películas del actor con ID 1 en orden alfabético
            Actor actor = em.find(Actor.class, 1);
            if (actor == null) {
                System.out.println("No existe un actor con ID 1");
            } else {
                System.out.println(actor.getFirst_name() + " | " + actor.getLast_name() + ":");
                
                List<Film> peliculasOrdenadas = actor.getFilms().stream()
                        .sorted(Comparator.comparing(Film::getTitle))
                        .toList();

                for (Film film : peliculasOrdenadas) {
                    System.out.println(" - " + film.getTitle());
                }
                System.out.println("El total de películas es de: " + peliculasOrdenadas.size());
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}