package com.taxiapp;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
    int id;
    int currentPoint; // 0 = A, 1 = B, ..., 5 = F
    int freeTime;
    int totalEarnings;
    List<String> trips;

    public Taxi(int id) {
        this.id = id;
        this.currentPoint = 0;
        this.freeTime = 0;
        this.totalEarnings = 0;
        this.trips = new ArrayList<>();
    }

    public void addTrip(String tripDetails, int dropPoint, int dropTime, int fare) {
        this.trips.add(tripDetails);
        this.currentPoint = dropPoint;
        this.freeTime = dropTime;
        this.totalEarnings += fare;
    }
}
