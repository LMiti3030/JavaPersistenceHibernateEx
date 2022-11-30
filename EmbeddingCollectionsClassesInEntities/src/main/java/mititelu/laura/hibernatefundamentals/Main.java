package mititelu.laura.hibernatefundamentals;



import mititelu.laura.hibernatefundamentals.airport.Passenger;
import mititelu.laura.hibernatefundamentals.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m04.ex06");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Passenger laura = new Passenger("Laura Mititelu");

        Ticket ticket1 = new Ticket("AA1234");
        Ticket ticket2 = new Ticket("BB0789");

        laura.addTicket(ticket1);
        laura.addTicket(ticket2);

        Passenger george = new Passenger("George Popescu");
        Ticket ticket3 = new Ticket("CC9876");

        george.addTicket(ticket3);


        em.persist(laura);
        em.persist(george);


        em.getTransaction().commit();
        emf.close();

    }
}