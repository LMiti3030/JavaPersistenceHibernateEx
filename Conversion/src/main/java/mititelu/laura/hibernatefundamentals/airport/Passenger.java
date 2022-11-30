package mititelu.laura.hibernatefundamentals.airport;

import javax.persistence.*;

@Entity
@Table(name = "PASSENGERS")
public class Passenger {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Convert(converter = VipConverter.class)
    //this converter will be used for the read and write operations from and to the database
    private boolean vip;

    public Passenger(){}

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
