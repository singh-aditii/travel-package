package com.assignment.travelpackage.service;

import com.assignment.travelpackage.model.Activity;
import com.assignment.travelpackage.model.Destination;
import com.assignment.travelpackage.model.Passenger;
import com.assignment.travelpackage.model.TravelPackage;
import com.assignment.travelpackage.repository.ActivityRepository;
import com.assignment.travelpackage.repository.PassengerRepository;
import com.assignment.travelpackage.repository.TravelPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelPackageService {

    private final TravelPackageRepository travelPackageRepository;
    private final ActivityRepository activityRepository;
    private final PassengerRepository passengerRepository;

    @Autowired
    public TravelPackageService(TravelPackageRepository travelPackageRepository, ActivityRepository activityRepository, PassengerRepository passengerRepository) {
        this.travelPackageRepository = travelPackageRepository;
        this.activityRepository = activityRepository;
        this.passengerRepository = passengerRepository;
    }
    public void printItinerary(Long travelPackageId) {
        //print package name
        //destination and details of activities available like name, cost, capacity, description

        TravelPackage travelPackage = travelPackageRepository.findById(travelPackageId)
                .orElseThrow(() -> new IllegalArgumentException("Travel Package not found with id: " + travelPackageId));

        System.out.println("Travel Package: " + travelPackage.getName());
        System.out.println("Itinerary:");
        for (Destination destination : travelPackage.getDestinations()) {
            System.out.println("Destination: " + destination.getName());
            System.out.println("Activities:");
            for (Activity activity : destination.getActivities()) {
                System.out.println("- " + activity.getName() + ": " + activity.getDescription() +
                        ", Cost: " + activity.getCost() + ", Capacity: " + activity.getCapacity());
            }
        }
    }
    public void printPassengerList(Long travelPackageId) {
        TravelPackage travelPackage = travelPackageRepository.findById(travelPackageId)
                .orElseThrow(() -> new IllegalArgumentException("Travel Package not found with id: " + travelPackageId));

        System.out.println("Travel Package: " + travelPackage.getName());
        System.out.println("Passenger List:");
        System.out.println("Capacity: " + travelPackage.getPassengerCapacity());
        System.out.println("Number of Passengers enrolled: " + travelPackage.getPassengersEnrolled());
        for (Passenger passenger : travelPackage.getPassengers()) {
            System.out.println("- Name: " + passenger.getName() + ", Number: " + passenger.getNumber());
        }
    }
    public void printPassengerDetails(Long passengerId) {
        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new IllegalArgumentException("Passenger not found with id: " + passengerId));

        System.out.println("Passenger Details:");
        System.out.println("Name: " + passenger.getName());
        System.out.println("Number: " + passenger.getPassengerNumber());
        System.out.println("Balance: " + passenger.getBalance());
        System.out.println("Activities:");
        for (Activity activity : passenger.getActivities()) {
            System.out.println("- Destination: " + activity.getDestination().getName() +
                    ", Activity: " + activity.getName() + ", Price: " + activity.getPassengerActivityCost(passenger));
        }
    }
    public void printAvailableActivities() {
        List<Activity> activities = activityRepository.findAll();
        for (Activity activity : activities) {
            int availableSpaces = activity.getCapacity() - activity.getPassengers().size();
            if (availableSpaces > 0) {
                System.out.println("Activity: " + activity.getName());
                System.out.println("Description: " + activity.getDescription());
                System.out.println("Cost: " + activity.getCost());
                System.out.println("Capacity: " + activity.getCapacity());
                System.out.println("Available Spaces: " + availableSpaces);
                System.out.println();
            }
        }
    }
}

