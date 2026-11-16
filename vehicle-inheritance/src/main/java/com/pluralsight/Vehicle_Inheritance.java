package com.pluralsight;

public class Vehicle_Inheritance {
    static void main(String[] args) {
        Moped slowRide = new Moped("Red", 1, 0, 5);
        System.out.println("Color: "+slowRide.getColor()+"\n"+"Fuel Capacity: "+slowRide.getFuelCapacity());
    }
}
