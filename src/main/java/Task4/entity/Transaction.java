package Task4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue
    private int id;
    private double amount;

    @ManyToOne
    private Currency sourceCurrency;

    @ManyToOne
    private Currency targetCurrency;


    public Transaction() {
    }

    public Transaction(double amount, Currency sourceCurrency, Currency targetCurrency) {
        this.amount = amount;
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;

    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
