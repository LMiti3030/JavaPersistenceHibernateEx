package mititelu.laura.hibernatefundamentals;

import mititelu.laura.hibernatefundamentals.airport.Address;
import mititelu.laura.hibernatefundamentals.airport.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m04.ex05");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Passenger laura = new Passenger("Laura Mititelu");
        Address address = new Address();

        address.setStreet("Aleea Castanilor");
        address.setNumber("2");
        address.setZipCode("041026");
        address.setCity("Bucuresti");

        laura.setAdress(address);

        em.persist(laura);

        //em.persist(address); Clasa Address nu e entitate separata si nu o pot persista, ea va fi integrata in pasageri

        em.getTransaction().commit();
        emf.close();

    }
}
