package mititelu.laura.hibernatefundamentals;

import mititelu.laura.hibernatefundamentals.airport.Department;
import mititelu.laura.hibernatefundamentals.airport.Manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m04.ex03");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Manager laura = new Manager("Laura Mititelu");
        Department it = new Department();
        it.setName("IT");
        laura.setDepartment(it);

        em.persist(laura);
        em.persist(it);

        em.getTransaction().commit();
        em.close();


    }

}
