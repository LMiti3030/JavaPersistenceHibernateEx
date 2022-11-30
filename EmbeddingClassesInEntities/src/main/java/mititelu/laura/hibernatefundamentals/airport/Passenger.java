package mititelu.laura.hibernatefundamentals.airport;

import javax.persistence.*;

@Entity
@Table(name = "PASSENGERS")
public class Passenger {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @Embedded//indicating that we have this adress embedded in the Passenger
    @AttributeOverrides({ //define names for columns in the table by overriding the automatic names based on property name
            @AttributeOverride(name = "street", column = @Column(name = "PASSENGER_STREET")),
            @AttributeOverride(name = "number", column = @Column(name = "PASSENGER_NUMBER")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "PASSENGER_ZIP_CODE")),
            @AttributeOverride(name = "city", column = @Column(name = "PASSENGER_CITY"))
    })
    private Address address;

    public Passenger(){}

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAdress() {
        return address;
    }

    public void setAdress(Address adress) {
        this.address = adress;
    }
}
