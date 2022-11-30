package mititelu.laura.hibernatefundamentals;

import mititelu.laura.hibernatefundamentals.airport.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    //inainte de a rula tb sa creez database-ul + use it
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m03.ex01");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Passenger john = new Passenger(1, "Laura Mititelu", "Piata Unirii nr 3, Bucuresti");

        //em.persist
        em.persist(john);

        em.getTransaction().commit();

        emf.close();
    }
}
