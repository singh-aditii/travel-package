package com.assignment.travelpackage.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double cost;
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;
    @ManyToMany(mappedBy = "activities")
    private List<Passenger> passengers;

    // Constructors, getters, and setters

    public Activity() {
    }

    public Activity(String name, String description, double cost, int capacity, Destination destination, List<Passenger> passengers) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.passengers = passengers;
    }

    // Getters and setters
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPassengerActivityCost(Passenger passenger) {
        String type = passenger.getPassengerType();
        if (type.equals("STANDARD")) {
            return cost;
        } else if (type.equals("GOLD")) {
            return cost * 0.9; // 10% discount for gold passengers
        } else if (type.equals("PREMIUM")) {
            return 0; // Premium passengers have free activities
        }
        return cost;
    }
    public int getCapacity() {
        return capacity;
    }
    public Destination getDestination() {
        return destination;
    }
    public double getCost() {
        return cost;
    }
    public List<Passenger> getPassengers() {
        return passengers;
    }
}

