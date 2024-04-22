package com.assignment.travelpackage.controller;

import com.assignment.travelpackage.service.TravelPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelPackageController {

    private final TravelPackageService travelPackageService;

    @Autowired
    public TravelPackageController(TravelPackageService travelPackageService) {
        this.travelPackageService = travelPackageService;
    }

    @GetMapping("/{id}/itinerary")
    public void printItinerary(@PathVariable Long id) {
        travelPackageService.printItinerary(id);
    }

    @GetMapping("/{id}/passengers")
    public void printPassengerList(@PathVariable Long id) {
        travelPackageService.printPassengerList(id);
    }

    @GetMapping("/passenger/{passengerId}")
    public void printPassengerDetails(@PathVariable Long passengerId) {
        travelPackageService.printPassengerDetails(passengerId);
    }

    @GetMapping("/available-activities")
    public void printAvailableActivities() {
        travelPackageService.printAvailableActivities();
    }
}
