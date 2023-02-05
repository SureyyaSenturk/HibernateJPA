package service;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.HashSet;
import java.util.Set;

public class Service {

    public void add(){


        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction tx= session.beginTransaction();

        Author author= new Author();
        author.setAge(45);
        author.setName("Şükrü Erbaş");

        Category category= new Category();
        category.setCategory_name("Klasik");

        Publisher publisher= new Publisher();
        publisher.setPublisher("ABC");

        Language language= new Language();
        language.setLanguage("English");

       Book book1= new Book("Yaşıyoruz Sessizce",100,language,author,category,publisher);
       Book book2= new Book("ABC",98,language,author,category,publisher);

        Set<Book> bookSet= new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);

        Address address= new Address();
        address.setStreet("Güzel");
        address.setZipCode(1222);
        address.setAuthor(author);
        author.setAddress(address);


        session.persist(author);
        session.persist(category);
        session.persist(publisher);
        session.persist(language);
        session.persist(address);
        session.persist(book1);
        session.persist(book2);

        tx.commit();
        session.close();



    }
}
