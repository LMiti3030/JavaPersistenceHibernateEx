package mititelu.laura.hibernatefundamentals;

import mititelu.laura.hibernatefundamentals.airport.OneWayTicket;
import mititelu.laura.hibernatefundamentals.airport.ReturnTicket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m05.ex01");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        OneWayTicket oneWayTicket = new OneWayTicket();
        oneWayTicket.setNumber("AA1234");
        oneWayTicket.setLatestDepartureDate(LocalDate.of(2022,12,25));
        ReturnTicket returnTicket = new ReturnTicket();
        returnTicket.setNumber("BB0789");
        returnTicket.setLatestReturnDate(LocalDate.of(2023, 04, 20));

        em.persist(oneWayTicket);
        em.persist(returnTicket);

        em.getTransaction().commit();
        emf.close();
    }
}
