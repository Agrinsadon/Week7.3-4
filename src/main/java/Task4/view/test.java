package Task4.view;

import Task4.application.CurrencyApp;
import Task3.dao.CurrencyDao;

public class test {

    public static void main(String[] args) {
        CurrencyApp ca = new CurrencyApp();
        CurrencyDao cd = new CurrencyDao();
        ca.getNames();
        cd.delete("12");
        cd.delete("11");
        cd.delete("10");
        }
    }

