package mititelu.laura.hibernatefundamentals;

import mititelu.laura.hibernatefundamentals.airport.Airport;
import mititelu.laura.hibernatefundamentals.airport.Passenger;
import mititelu.laura.hibernatefundamentals.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        //provide argument the name of persistence-unit name defined in persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m02.ex01");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Airport airport = new Airport(1, "Henri Coanda");

        Passenger john = new Passenger(1, "John Smith");
        john.setAirport(airport);
        Passenger mike = new Passenger(2, "Michael Johnson");
        mike.setAirport(airport);
        airport.addPassenger(john);
        airport.addPassenger(mike);

        Ticket ticket1 = new Ticket(1, "AA1234");
        ticket1.setPassenger(john);

        Ticket ticket2 = new Ticket(2, "BB5678");
        ticket2.setPassenger(john);

        john.addTicket(ticket1);
        john.addTicket(ticket2);

        Ticket ticket3 = new Ticket(3, "CC0987");
        ticket3.setPassenger(mike);

        mike.addTicket(ticket3);

        //we insert into the db a corresponding record for each object created
        em.persist(airport);
        em.persist(john);
        em.persist(mike);
        em.persist(ticket1);
        em.persist(ticket2);
        em.persist(ticket3);

        em.getTransaction().commit();
        em.close();
    }
}
