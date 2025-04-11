# TaxiBookingSystem
Console based taxi booking system.
Call Taxi Booking Application
Description:
Design a taxi booking application where customers can book taxis available at certain points
in a linear route.
Problem Assumptions:
• Taxi Count: Assume 4 taxis for simplicity, but it should scale to any number of taxis.
• Points on Route: A, B, C, D, E, F (each 15 km apart)
• Travel Time Between Points: 60 minutes
• Charges:
o Minimum Rs.100 for the first 5 km
o Rs.10 per km thereafter
• Initial Taxi Position: All taxis are stationed at A.
Booking Rules:
• When a customer books a taxi:
o A free taxi at the pickup point is allocated.
o If no free taxi is available, the nearest taxi is allocated.
o If two taxis are free at the same point, the one with lower earnings is
allocated.
o Taxis only charge from the pickup point to the drop point.
o If no taxi is available, the booking is rejected.
Modules:
1. Call Taxi Booking
Sample Inputs and Outputs:
Input 1:
o Customer ID: 1
o Pickup Point: A
o Drop Point: B
o Pickup Time: 9
Output 1:
o Taxi can be allotted.
o Taxi-1 is allotted
