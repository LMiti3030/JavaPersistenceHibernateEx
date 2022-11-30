package mititelu.laura.hibernatefundamentals;

import mititelu.laura.hibernatefundamentals.airport.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    //inainte de a rula tb sa creez database-ul + use it
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m03.ex02");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Passenger laura = new Passenger(1, "Laura Mititelu");
        laura.setCity("BUCURESTI");
        laura.setStreet("PIATA UNIRII");
        laura.setNumber("25");
        laura.setZipCode("012564");

        //em.persist
        em.persist(laura);

        em.getTransaction().commit();
        emf.close();
    }
}
