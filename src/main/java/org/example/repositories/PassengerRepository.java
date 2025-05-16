package org.example.repositories;

import org.example.entities.Passenger;

import java.util.ArrayList;
import java.util.List;

public class PassengerRepository {
    private final List<Passenger> passengers = new ArrayList<>();

    public void salve(Passenger passenger) {
        passengers.add(passenger);
    }

    public List<Passenger> listAll() {
        return passengers;
    }
}
