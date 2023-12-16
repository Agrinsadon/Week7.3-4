package Task3.dao;

import Task3.datasource.MariaDbJpaConnection;
import Task3.entity.Currency;
import jakarta.persistence.*;
import jakarta.persistence.EntityManager;


import java.util.List;

public class CurrencyDao {

    public List<String> getNames() {
        try {
            EntityManager em = MariaDbJpaConnection.getInstance();
            Query query = em.createQuery("SELECT c.name FROM Currency c order by c.id");
            List<String> names = query.getResultList();
            return names;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    return null;
    }

    public Currency find(int abbreviation) {
        try {
            EntityManager em = MariaDbJpaConnection.getInstance();
            Currency currency = em.find(Currency.class, abbreviation);
            return currency;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void persist(Currency currency){
        try {
            EntityManager em = MariaDbJpaConnection.getInstance();
            em.getTransaction().begin();
            em.persist(currency);
            em.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void update(Currency currency){
        try {
            EntityManager em = MariaDbJpaConnection.getInstance();
            em.getTransaction().begin();
            em.merge(currency);
            em.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id){
        try {
            EntityManager em = MariaDbJpaConnection.getInstance();
            em.getTransaction().begin();
            em.remove(id);
            em.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
