package com.assignment.travelpackage.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "travel_packages")
public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int passengerCapacity;
    private int passengersEnrolled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "travelPackage")
    private List<Destination> destinations;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "travelPackage")
    private List<Passenger> passengers;

    // Constructors, getters, and setters

    public TravelPackage() {
    }

    public TravelPackage(String name, int passengerCapacity, int passengersEnrolled, List<Destination> destinations, List<Passenger> passengers) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.destinations = destinations;
        this.passengers = passengers;
        this.passengersEnrolled = passengersEnrolled;
    }

    // Getters and setters
    public String getName() {
        return name;
    }
    public List<Destination> getDestinations() {
        return destinations;
    }
    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    public List<Passenger> getPassengers() {
        return passengers;
    }
    public int getPassengersEnrolled() {
        return passengersEnrolled;
    }
}
