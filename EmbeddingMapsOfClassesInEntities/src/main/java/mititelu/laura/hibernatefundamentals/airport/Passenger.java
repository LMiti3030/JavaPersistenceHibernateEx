package mititelu.laura.hibernatefundamentals.airport;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "PASSENGERS")
public class Passenger {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ElementCollection
    @CollectionTable(name = "PASSENGER_TICKETS", joinColumns = {
            @JoinColumn(name = "PASSENGER_ID", referencedColumnName = "ID")
    })
    private List<Ticket> tickets = new ArrayList<>();

    //attributes of the passenger that will be kept as pairs of string
    @ElementCollection
    @MapKeyColumn(name = "ATTRIBUTE_NAME") //name of key column
    @Column(name = "ATTRIBUTE_VALUE") //name of value column
    @CollectionTable(name = "PASSENGER_ATTRIBUTES", joinColumns = {
            @JoinColumn(name = "PASSENGER_ID", referencedColumnName = "ID")
    }) //a new table will be created PASSENGER_ATTRIBUTES with PASSENGER_ID as foreign key + other columns
    private Map<String, String> attributes = new HashMap<>();

    public Passenger(String name) {
        this.name = name;
    }

    public Passenger() {
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

    public List<Ticket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public Map<String, String> getAttributes(){
        return Collections.unmodifiableMap(attributes);
    }

    public void addAttribute(String key, String value){
        attributes.put(key, value);
    }

}