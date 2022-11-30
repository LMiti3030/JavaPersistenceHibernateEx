package mititelu.laura.hibernatefundamentals;

import mititelu.laura.hibernatefundamentals.airport.Passenger;
import mititelu.laura.hibernatefundamentals.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    //inainte de a rula tb sa creez database-ul + use it
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m04.ex01");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Passenger laura = new Passenger("Laura Mititelu");
        Ticket ticket1 = new Ticket("AA1234");
        ticket1.setPassenger(laura);
        Ticket ticket2 = new Ticket("BB5678");
        ticket2.setPassenger(laura);
        laura.addTicket(ticket1);
        laura.addTicket(ticket2);

        //em.persist for all created objects
        em.persist(laura);
        em.persist(ticket1);
        em.persist(ticket2);

        em.getTransaction().commit();
        emf.close();
    }

}
