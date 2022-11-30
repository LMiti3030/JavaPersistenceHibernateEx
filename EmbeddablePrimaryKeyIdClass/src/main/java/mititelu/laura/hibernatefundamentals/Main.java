package mititelu.laura.hibernatefundamentals;

import mititelu.laura.hibernatefundamentals.airport.Ticket;
import mititelu.laura.hibernatefundamentals.airport.TicketKey;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    //inainte de a rula tb sa creez database-ul + use it
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m03.ex06");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Ticket ticket  = new Ticket();
        ticket.setSeries("CC");
        ticket.setNumber("7890");
        ticket.setOrigin("Bucharest");
        ticket.setDestination("Paris");

        //em.persist
        em.persist(ticket);

        em.getTransaction().commit();
        emf.close();
    }

}
