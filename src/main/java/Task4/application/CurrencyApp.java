package Task4.application;

import Task4.dao.CurrencyDao;
import Task4.entity.Currency;
import Task4.view.CurrencyView;
import Task4.dao.TransactionDao;
import javafx.application.Application;

import java.util.List;

import static javafx.application.Application.launch;

public class CurrencyApp {
    CurrencyDao cd = new CurrencyDao();
    TransactionDao td = new TransactionDao();
    Currency currency1, currency2;
    public List<String> getNames() {
        return cd.getNames();
    }

    public double convert(double amount, int from, int to) {
        currency1 = cd.find(from);
        currency2 = cd.find(to);
        td.persist(amount, currency1, currency2);
        double fromRate = currency1.getConversion_rate_to();
        double toRate = currency2.getConversion_rate_to();
        return amount * toRate / fromRate;
    }

    public void addCurrency(String abbreviation, String name, double rateToEuro, double rateFromEuro) {
        Currency currency = new Currency(abbreviation, name, rateToEuro, rateFromEuro);
        cd.persist(currency);
    }


    public static void main(String[] args) {
        Application.launch(CurrencyView.class, args);
    }
}


