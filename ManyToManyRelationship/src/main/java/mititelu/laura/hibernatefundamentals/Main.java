package mititelu.laura.hibernatefundamentals;

import mititelu.laura.hibernatefundamentals.airport.Passenger;
import mititelu.laura.hibernatefundamentals.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernatefundamentals.m04.ex02");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Passenger laura = new Passenger("Laura Mititelu");
        Passenger george = new Passenger("George Popescu");

        Ticket ticket1 = new Ticket("AA1234");
        Ticket ticket2 = new Ticket("BB5678");

        laura.addTicket(ticket1);
        laura.addTicket(ticket2);
        george.addTicket(ticket1);
        george.addTicket(ticket2);

        ticket1.addPassenger(laura);
        ticket1.addPassenger(george);
        ticket2.addPassenger(laura);
        ticket2.addPassenger(george);


        //entityManager.persist();
        entityManager.persist(laura);
        entityManager.persist(george);
        entityManager.persist(ticket1);
        entityManager.persist(ticket2);

        //Hibernate will create the intermediary table TICKETS_PASSENGERS
        //that will model the many-to-many relationship


        entityManager.getTransaction().commit();;
        entityManagerFactory.close();
    }
}
