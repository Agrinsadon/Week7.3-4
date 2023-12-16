package Task3.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "currency")

public class Currency {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "abbreviation")
    String abbreviation;
    @Column(name = "name")
    String name;
    @Column(name = "conversion_rate_from")
    double conversion_rate_from;
    @Column(name = "conversion_rate_to")
    double conversion_rate_to;

    public Currency(String abbreviation, String name, double conversion_rate_from, double conversion_rate_to) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.conversion_rate_from = conversion_rate_from;
        this.conversion_rate_to = conversion_rate_to;
    }

    public Currency() {
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getConversion_rate_from() {
        return conversion_rate_from;
    }

    public void setConversion_rate_from(double conversion_rate_from) {
        this.conversion_rate_from = conversion_rate_from;
    }

    public double getConversion_rate_to() {
        return conversion_rate_to;
    }

    public void setConversion_rate_to(double conversion_rate_to) {
        this.conversion_rate_to = conversion_rate_to;
    }

    @Override
    public String toString() {
        return "currency{" +
                "abbreviation='" + abbreviation + '\'' +
                ", name='" + name + '\'' +
                ", conversion_rate_from='" + conversion_rate_from + '\'' +
                ", conversion_rate_to='" + conversion_rate_to + '\'' +
                '}';
    }

}
