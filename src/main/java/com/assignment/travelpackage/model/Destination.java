package com.assignment.travelpackage.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "destinations")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destination")
    private List<Activity> activities;

    @ManyToOne
    @JoinColumn(name = "travel_package_id")
    private TravelPackage travelPackage;

    // Constructors, getters, and setters

    public Destination() {
    }

    public Destination(String name, List<Activity> activities, TravelPackage travelPackage) {
        this.name = name;
        this.activities = activities;
        this.travelPackage = travelPackage;
    }

    // Getters and setters
    public String getName() {
        return name;
    }
    public List<Activity> getActivities() {
        return activities;
    }
}

