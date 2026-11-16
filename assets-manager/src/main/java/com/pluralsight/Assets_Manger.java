package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Assets_Manger {
    static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

        assets.add(new House("My House", "05/15/2018",
                BigDecimal.valueOf(250000), "123 Main Street", 1, 2000, 10000));

        assets.add(new House("Vacation Home", "07/10/2020",
                BigDecimal.valueOf(175000), "456 Ocean Drive", 2, 1500, 8000));

        assets.add(new Vehicle("My Car", "03/12/2022",
                BigDecimal.valueOf(30000), "Honda Civic", 2022, 120000));

        assets.add(new Vehicle("Tom's Truck", "06/20/2019",
                BigDecimal.valueOf(45000), "Ford F-150", 2019, 130000));

        for (Asset asset : assets) {

            System.out.println("\nDescription: " + asset.getDescription());

            System.out.println("Date Acquired: " + asset.getDateAcquired());

            System.out.println("Original Cost: $" + asset.getValue());

            System.out.println("Current Value: $" + asset.getValue());

            if (asset instanceof House) {

                House house = (House) asset;

                System.out.println("Address: " + house.getAddress());

            } else if (asset instanceof Vehicle) {

                Vehicle vehicle = (Vehicle) asset;

                System.out.println("Vehicle: " + vehicle.getYear() + " " + vehicle.getMakeModel());
            }

            System.out.println("--------------------------------");
        }
    }
}

