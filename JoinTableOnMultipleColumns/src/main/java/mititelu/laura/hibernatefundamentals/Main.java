package mititelu.laura.hibernatefundamentals;

import mititelu.laura.hibernatefundamentals.airport.Payment;
import mititelu.laura.hibernatefundamentals.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m04.ex04");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Ticket ticket = new Ticket();
        ticket.setNumber("AA1234");
        ticket.setOrigin("Bucharest");
        ticket.setDestination("New York");

        Payment payment = new Payment();
        payment.setTicket(ticket);
        payment.setAmount(200);

        em.persist(ticket);
        em.persist(payment);

        em.getTransaction().commit();
        emf.close();

    }
}
