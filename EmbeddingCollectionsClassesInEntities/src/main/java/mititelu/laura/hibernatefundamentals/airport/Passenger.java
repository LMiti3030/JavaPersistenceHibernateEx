package mititelu.laura.hibernatefundamentals.airport;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name ="PASSENGERS")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "PASSENGER_TICKETS", joinColumns = {
            @JoinColumn(name = "PASSENGER_ID", referencedColumnName = "ID")
    })
    //va crea o noua tabela PASSENGER_TICKETS   cu foreign key PASSENGER_ID care corespunde ID din Passengers
    private List<Ticket> tickets = new ArrayList<>();

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

    public List<Ticket> getTickets(){
        return Collections.unmodifiableList(tickets);
    }

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }
}
