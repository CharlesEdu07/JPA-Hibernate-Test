package com.charlesedu.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.charlesedu.domain.Person;

public class App {
    public static void main(String[] args) throws Exception {
        Person person1 = new Person(null, "Agnaldo", "agnaldo@gmail.com");
        Person person2 = new Person(null, "Dudu", "dudu@gmail.com");
        Person person3 = new Person(null, "John", "john@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
        EntityManager em = emf.createEntityManager();

        // Busca por ID

        Person person = em.find(Person.class, 1);
        System.out.println(person);

        //==================================================================================================

        //Inserção no banco de dados

        em.getTransaction().begin();
        em.persist(person1);
        em.persist(person2);
        em.persist(person3);
        em.getTransaction().commit();


        //==================================================================================================

        //Remoção no banco de dados
        
        // Person person = em.find(Person.class, 3);

        // em.getTransaction().begin();
        // em.remove(person);
        // em.getTransaction().commit();

        em.close();
        emf.close();

        // System.out.println("Persons saved successfully!");

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

        System.out.println("\nPronto!");
    }
}
