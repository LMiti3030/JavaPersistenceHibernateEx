package mititelu.laura.hibernatefundamentals;



import mititelu.laura.hibernatefundamentals.airport.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m05.ex06");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Passenger laura = new Passenger("Laura Mititelu");
        laura.setVip(true);

        Passenger george = new Passenger("George Ionescu");
        george.setVip(false);

        em.persist(laura);



        em.getTransaction().commit();

        em.persist(george);
        emf.close();
    }
}

