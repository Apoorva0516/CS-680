package edu.umb.cs680.hw11;

import java.util.ArrayList;

public class Car {
    private String make, model;
    private int mileage, year, price, dominationCount;

    public Car(String make, String model, int mileage, int year, int price) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getMileage() {
        return this.mileage;
    }

    public int getYear() {
        return this.year;
    }

    public int getPrice() {
        return this.price;
    }

    public void setDominationCount(ArrayList<Car> cars) {
        int count = 0;
        for (Car car : cars) {
            if (!car.equals(this)) {
                int price = car.getPrice();
                int year = car.getYear();
                int mileage = car.getMileage();

                if (this.getYear() >= year && this.getMileage() <= mileage && this.getPrice() <= price) {
                    if (this.getYear() > year || this.getMileage() < mileage || this.getPrice() < price) {
                        count++;
                    }
                }
            }
        };
        this.dominationCount = count;
    }

    public int getDominationCount() {
        return this.dominationCount;
    }

    public static void main(String args[]) {
        Car newCar = new Car("Tesla", "Model 3", 50, 2020, 105000);
        System.out.println("Make: " + newCar.getMake());
        System.out.println("Model: " + newCar.getModel());
        System.out.println("Year: " + newCar.getYear());
    }
}
