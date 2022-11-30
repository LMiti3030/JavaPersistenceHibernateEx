package mititelu.laura.hibernatefundamentals.airport;

import javax.persistence.*;

@MappedSuperclass //=it does not have its own persistence but the defined state and mapping information common to multiple entity subclasses
public abstract class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;

    @ManyToOne //many tickets may be owned by one passenger
    @JoinColumn(name = "PASSENGER_ID")
    private Passenger passenger;

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
