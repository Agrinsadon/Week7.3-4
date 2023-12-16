package Task3.application;

import Task3.dao.CurrencyDao;
import Task3.entity.Currency;
import Task3.view.CurrencyView;
import javafx.application.Application;

import java.util.List;

import static javafx.application.Application.launch;

public class CurrencyApp {
    CurrencyDao cd = new CurrencyDao();
    Currency currency1, currency2;
    public List<String> getNames() {
        return cd.getNames();
    }

    public double convert(double amount, int from, int to) {
        currency1 = cd.find(from);
        currency2 = cd.find(to);
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


