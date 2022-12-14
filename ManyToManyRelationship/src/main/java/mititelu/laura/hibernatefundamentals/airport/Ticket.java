package mititelu.laura.hibernatefundamentals.airport;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name ="TICKETS")
public class Ticket {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name  = "NUMBER")
    private String number;

    //many tickets may be owned by many passengers
    @ManyToMany
    private List<Passenger> passengers = new ArrayList<>();

    public Ticket(){}

    public Ticket(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Passenger> getPassengers(){
        return Collections.unmodifiableList(passengers);
    }

    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }
}
