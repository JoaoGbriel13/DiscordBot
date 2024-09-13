package DTO;

public class FuelResultResponse {
    private double fuel;
    private double laps;

    public FuelResultResponse(double fuel, double laps) {
        this.fuel = fuel;
        this.laps = laps;
    }


    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getLaps() {
        return laps;
    }

    public void setLaps(double laps) {
        this.laps = laps;
    }
}
