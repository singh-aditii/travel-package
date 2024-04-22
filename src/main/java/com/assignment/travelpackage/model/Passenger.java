package com.assignment.travelpackage.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String passengerType; // Standard, Gold, Premium
    private String passengerNumber;
    private double balance;

    @ManyToMany
    @JoinTable(
            name = "passenger_activity",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private List<Activity> activities;

    @ManyToMany
    @JoinTable(
            name = "passenger_travel_package",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "travel_package_id")
    )
    private List<TravelPackage> travelPackages;

    // Constructors, getters, and setters

    public Passenger() {
    }

    public Passenger(String name, String passengerType, String passengerNumber, double balance) {
        this.name = name;
        this.passengerType = passengerType;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
    }

    // Getters and setters
    public String getName() {
        return name;
    }
    public String getPassengerNumber() {
        return passengerNumber;
    }
    public double getBalance() {
        if (passengerType.equals("STANDARD") || passengerType.equals("GOLD")) {
            return balance;
        } else {
            return 0;
        }

    }
    public String getPassengerType() {
        return passengerType;
    }
    public List<Activity> getActivities() {
        return activities;
    }

}

