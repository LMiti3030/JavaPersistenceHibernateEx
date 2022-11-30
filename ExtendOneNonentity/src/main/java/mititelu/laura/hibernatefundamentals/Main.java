package mititelu.laura.hibernatefundamentals;

import mititelu.laura.hibernatefundamentals.airport.OneWayTicket;
import mititelu.laura.hibernatefundamentals.airport.Passenger;
import mititelu.laura.hibernatefundamentals.airport.ReturnTicket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m05.ex02");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Passenger laura = new Passenger("Mititelu Laura");

        OneWayTicket oneWayTicket = new OneWayTicket();
        oneWayTicket.setNumber("AA1234");
        oneWayTicket.setLatestDepartureDate(LocalDate.of(2022,12,25));
        oneWayTicket.setPassenger(laura);

        ReturnTicket returnTicket = new ReturnTicket();
        returnTicket.setNumber("BB0789");
        returnTicket.setLatestReturnDate(LocalDate.of(2023, 04, 20));
        returnTicket.setPassenger(laura);

        em.persist(laura);
        em.persist(oneWayTicket);
        em.persist(returnTicket);


        Passenger george = new Passenger("Popescu George");

        OneWayTicket oneWayTicket1 = new OneWayTicket();
        oneWayTicket1.setNumber("AA1234");
        oneWayTicket1.setLatestDepartureDate(LocalDate.of(2022,12,25));
        oneWayTicket1.setPassenger(george);

        ReturnTicket returnTicket2 = new ReturnTicket();
        returnTicket2.setNumber("BB0789");
        returnTicket2.setLatestReturnDate(LocalDate.of(2023, 04, 20));
        returnTicket2.setPassenger(george);

        em.persist(george);
        em.persist(oneWayTicket1);
        em.persist(returnTicket2);


        em.getTransaction().commit();
        emf.close();
    }
}
