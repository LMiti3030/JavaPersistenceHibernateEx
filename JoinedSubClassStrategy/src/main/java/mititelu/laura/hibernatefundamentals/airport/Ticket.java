package mititelu.laura.hibernatefundamentals.airport;

import javax.persistence.*;

@Entity
@Table(name ="TICKETS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Ticket {

    @Id
    @GeneratedValue
    private int id;
    private String number;

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
