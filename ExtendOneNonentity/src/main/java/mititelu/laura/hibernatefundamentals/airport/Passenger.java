package mititelu.laura.hibernatefundamentals.airport;

import javax.persistence.*;

@Entity
@Table(name = "PASSENGERS")
public class Passenger {

    @Id //primary key
   // @GeneratedValue //value provided by database
    @GeneratedValue(strategy = GenerationType.IDENTITY) //unique value
    private int id;
    private String name;

    public Passenger(){}

    public Passenger(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
