package edu.umb.cs680.hw11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ComparatorTest {

    private String[] carsToStringArray(ArrayList<Car> cars) {
        String[] carsMake =  new String[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            carsMake[i] = cars.get(i).getMake();
        }
        return carsMake;
    }

    private static ArrayList<Car> cars = new ArrayList<>();;

    @BeforeAll
    public static void setUp() {
        cars.add(new Car("Ford", "Lexus", 200, 2010, 1000));
        cars.add(new Car("Lambhorgini", "Gallardo", 190, 2018, 400));
        cars.add(new Car("Porsche", "Cayman", 10, 2019, 200));
        cars.add(new Car("Tesla", "Model 3", 5, 2020, 150));

    }

    @Test
    public void compareYear() {
        String[] expected = {"Tesla", "Porsche", "Lambhorgini", "Ford"};
        Collections.sort(cars, new PriceComparator());
        String[] actual = carsToStringArray(cars);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void compareMileage() {
    	String[] expected = {"Tesla", "Porsche", "Lambhorgini", "Ford"};
        Collections.sort(cars, new MileageComparator());
        String[] actual = carsToStringArray(cars);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void comparePrice() {
    	String[] expected = {"Tesla", "Porsche", "Lambhorgini", "Ford"};
        Collections.sort(cars, new PriceComparator());
        String[] actual = carsToStringArray(cars);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void comparePareto() {
        for (Car car : cars) {
            car.setDominationCount(cars);
        }

        String[] expected = {"Tesla", "Porsche", "Lambhorgini", "Ford"};
        Collections.sort(cars, new ParetoComparator());
        String[] actual = carsToStringArray(cars);
        assertArrayEquals(expected, actual);
    }
}

