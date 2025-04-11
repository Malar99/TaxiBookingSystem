package com.taxiapp;

import java.util.*;

public class TaxiBookingApp {

    static final int BASE_FARE = 100;
    static final int BASE_KM = 5;
    static final int EXTRA_FARE_PER_KM = 10;
    static final int DISTANCE_BETWEEN_POINTS = 15;
    static final int TIME_BETWEEN_POINTS = 60;

    static List<Taxi> taxis = new ArrayList<>();

    public static void initializeTaxis(int count) {
        for (int i = 1; i <= count; i++) {
            taxis.add(new Taxi(i));
        }
    }

    public static void bookTaxi(int custId, char pickupChar, char dropChar, int pickupTimeHour) {
        int pickup = pickupChar - 'A';
        int drop = dropChar - 'A';
        int travelDistance = Math.abs(drop - pickup) * DISTANCE_BETWEEN_POINTS;
        int travelTime = Math.abs(drop - pickup) * TIME_BETWEEN_POINTS;
        int pickupTime = pickupTimeHour * 60; // in minutes
        int dropTime = pickupTime + travelTime;

        int fare = BASE_FARE + Math.max(0, travelDistance - BASE_KM) * EXTRA_FARE_PER_KM;

        List<Taxi> eligible = new ArrayList<>();
        for (Taxi t : taxis) {
            if (t.freeTime <= pickupTime) {
                eligible.add(t);
            }
        }

        if (eligible.isEmpty()) {
            System.out.println("No taxis available. Booking rejected.");
            return;
        }

        eligible.sort((t1, t2) -> {
            int d1 = Math.abs(t1.currentPoint - pickup);
            int d2 = Math.abs(t2.currentPoint - pickup);
            if (d1 != d2) return Integer.compare(d1, d2);
            return Integer.compare(t1.totalEarnings, t2.totalEarnings);
        });

        Taxi assigned = eligible.get(0);

        String tripDetails = "CustomerID: " + custId + ", From: " + pickupChar + ", To: " + dropChar +
                ", Pickup: " + pickupTimeHour + ":00, Drop: " + (dropTime / 60) + ":00, Fare: Rs." + fare;

        assigned.addTrip(tripDetails, drop, dropTime, fare);

        System.out.println("Taxi can be allotted.");
        System.out.println("Taxi-" + assigned.id + " is allotted.");
    }

    public static void displayTaxis() {
        for (Taxi t : taxis) {
            System.out.println("Taxi-" + t.id + " | Total Earnings: Rs." + t.totalEarnings);
            for (String trip : t.trips) {
                System.out.println("  -> " + trip);
            }
        }
    }
}
