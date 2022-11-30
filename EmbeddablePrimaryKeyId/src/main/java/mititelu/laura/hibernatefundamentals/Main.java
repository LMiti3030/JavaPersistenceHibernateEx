package mititelu.laura.hibernatefundamentals;

import mititelu.laura.hibernatefundamentals.airport.Ticket;
import mititelu.laura.hibernatefundamentals.airport.TicketKey;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    //inainte de a rula tb sa creez database-ul + use it
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m03.ex05");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TicketKey ticketKey = new TicketKey();
        ticketKey.setSeries("BB");
        ticketKey.setNumber("4567");

        Ticket ticket1 = new Ticket();
        ticket1.setId(ticketKey);
        ticket1.setOrigin("Bucharest");
        ticket1.setDestination("Berlin");

        //em.persist
        em.persist(ticket1);

        em.getTransaction().commit();
        emf.close();
    }
}
