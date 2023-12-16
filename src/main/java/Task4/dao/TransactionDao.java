package Task4.dao;

import Task4.datasource.MariaDbJpaConnection;
import Task4.entity.Currency;
import Task4.entity.Transaction;
import jakarta.persistence.EntityManager;

public class TransactionDao {
    public void persist(double amount, Currency currency1, Currency currency2) {
        try {
            EntityManager em = MariaDbJpaConnection.getInstance();
            em.getTransaction().begin();
            em.persist(new Transaction(amount, currency1, currency2));
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
